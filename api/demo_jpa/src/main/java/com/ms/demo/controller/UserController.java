package com.ms.demo.controller;


import com.ms.demo.core.R;
import com.ms.demo.entity.User;
import com.ms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create") // 创建用户
    public R<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new R<>(0, "成功", 1, savedUser); // 返回保存后的用户
    }

    @PostMapping("/all") // 获取所有用户（带分页）
    public R<List<User>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<User> userPage = userService.getAllUsers(PageRequest.of(page-1, size));

        return new R<>(0, "成功", userPage.getTotalElements(), userPage.getContent());
    }

    @PostMapping("/getUserById") // 根据 ID 获取用户
    public R<User> getUserById(@RequestParam Long id) {
        User user = userService.getUserById(id);
        return new R<>(0, "成功", 1, user);
    }

    @PostMapping("/update") // 更新用户
    public R<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new R<>(0, "成功", 1, updatedUser);
    }

    @PostMapping("/delete") // 删除用户
    public R<Void> deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return new R<>(0, "删除成功", 0, null);
    }
}