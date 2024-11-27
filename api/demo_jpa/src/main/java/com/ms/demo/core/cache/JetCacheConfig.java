package com.ms.demo.core.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.template.QuickConfig;
import com.ms.demo.entity.User;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class JetCacheConfig {


//    @Bean
//    public RedissonClient redissonClient(@Autowired RedissonConfig redissonConfig){
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress(redissonConfig.getAddress())
//                .setPassword(redissonConfig.getPassword())
//                .setDatabase(redissonConfig.getDatabase());
//        return Redisson.create(config);
//    }


    @Bean
    public Cache<Long, User> userCache(@Autowired CacheManager cacheManager){
        //name用于统计信息显示，area用于区分不同的业务
        QuickConfig quickConfig = QuickConfig.newBuilder("userCache")
                //配置jetcache的二级缓存，本地缓存使用 Caffeine，远程缓存使用 Redisson
                .cacheType(CacheType.BOTH)
                .expire(Duration.ofHours(2))
                //本地缓存元素个数限制，只对CacheType.LOCAL和CacheType.BOTH有效
                .localLimit(1000)
                //两级缓存的情况下，缓存更新时发消息让其它JVM实例中的缓存失效，需要配置broadcastChannel才生效。
                .syncLocal(true)
                .build();



        return cacheManager.getOrCreateCache(quickConfig);
    }



}
