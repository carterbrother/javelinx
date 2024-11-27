package com.ms.demo.service;


import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.ms.demo.entity.User;
import com.ms.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    //id不为空并且大于0，则缓存，否则不缓存
    @Cached(name = "userCache",key = "#id" ,condition = "#id != null && #id > 0",postCondition = "#result != null")
    @CachePenetrationProtect
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @CacheInvalidate(name = "userCache",key = "#user.id" ,condition = "#user.id != null && #user.id > 0")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @CacheInvalidate(name = "userCache",key = "#id" ,condition = "#id != null && #id > 0")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}