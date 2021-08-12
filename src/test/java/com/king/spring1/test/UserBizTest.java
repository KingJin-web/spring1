package com.king.spring1.test;

import com.king.spring1.bean.User;
import com.king.spring1.biz.UserBiz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserBizTest {

    @Autowired
    UserBiz userBiz;
    @Test
    void addUser() {
        addUser1();
    }

    void addUser1() {
        for (int i = 10; i < 24; i++) {
            User user = new User();
            user.setUsername("test" + i);
            user.setPassword("a");
            user.setGender("男");
            userBiz.addUser(user);
        }

    }
    @Test
    void addUser2() {
        User user = new User();
        user.setUsername("test5");
        user.setPassword("a");
        user.setGender("男");
        userBiz.addUser(user);
    }
    @Test
    void query() {
        System.out.println(userBiz.query("test"));
        System.out.println(userBiz.query(null));
    }
}