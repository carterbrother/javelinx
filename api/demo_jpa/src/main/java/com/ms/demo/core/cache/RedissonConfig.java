package com.ms.demo.core.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "redisson")
@Component
@Data
public class RedissonConfig {

    private String address;
    private String password;
    private int database;
    private int timeout;
    private int connectionPoolSize;
    private int connectionMinimumIdleSize;
    private int idleConnectionTimeout;
    private int pingTimeout;
    private int retryAttempts;
    private int retryInterval;
    private int reconnectionTimeout;
    private int failedAttempts;
    private int subscriptionsPerConnection;
    private String clientName;
    private String dnsMonitoringInterval;
    private String subClientName;
    private String pubClientName;


}
