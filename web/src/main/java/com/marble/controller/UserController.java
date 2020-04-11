package com.marble.controller;

import com.marble.domain.User;
import com.marble.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author marble
 * @date 2020/4/11 13:08
 * @description
 */
@RestController
public class UserController {
    private UserRepository repository;

    //使用构造器注入 1.不能修改 2.提前创建
    @Autowired
    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public User addUser(@RequestParam("name") String name) {
        System.out.println("获取参数：" + name);
        User user = new User();
        user.setName(name);
        if (repository.save(user)) {
            System.out.printf("添加成功，用户为:%s \n", user);
        }
        return user;
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "success";
    }
}
