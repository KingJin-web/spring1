package com.king.spring1.biz;

import com.king.spring1.bean.User;
import com.king.spring1.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring1
 * @description:
 * @author: King
 * @create: 2021-08-12 14:00
 */
@Service
public class UserBiz {
    @Autowired
    UserMapper userMapper;

    public boolean addUser(User user) {
        return userMapper.insertUser(user.getUsername(), user.getPassword(), user.getGender());
    }

    public List<User> query(String name) {
        if (name == null) {
            return userMapper.selectAll();
        } else {
            return userMapper.selectByName(name);
        }
    }

    public boolean deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public boolean change(User user) {
        return userMapper.updateById(user.getId(), user.getUsername(), user.getPassword(), user.getGender());
    }
}
