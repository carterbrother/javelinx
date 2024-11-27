package com.joysky.api.demo.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joysky.api.demo.mp.entity.User;
import com.joysky.api.demo.mp.mapper.UserMapper;
import com.joysky.api.demo.mp.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
