package com.king.spring1.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.king.spring1.bean.User;
import com.king.spring1.biz.UserBiz;
import com.king.spring1.mapper.UserMapper;
import com.king.spring1.util.EmptyUtil;
import com.king.spring1.vo.JsonLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @program: spring1
 * @description:
 * @author: King
 * @create: 2021-08-12 14:24
 */

@RestController
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/add.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonLayui add(String name, String pwd, String sex) {
        JsonLayui jm = new JsonLayui();
        if (EmptyUtil.isEmpty(name)) {
            jm.setCode(0);
            jm.setMsg("请输入用户名！");
            return jm;
        }
        if (EmptyUtil.isEmpty(pwd)) {
            jm.setCode(0);
            jm.setMsg("请输入密码！");
            return jm;
        }
        if (EmptyUtil.isEmpty(sex)) {
            jm.setCode(0);
            jm.setMsg("请输入性别！");
            return jm;
        }
        User user = new User();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setGender(sex);
        System.out.println(user);
        if (userBiz.addUser(user)) {
            jm.setCode(1);
            jm.setMsg("添加成功");
        } else {
            jm.setCode(0);
            jm.setMsg("添加失败");
        }

        return jm;

    }

    @RequestMapping(value = "/query.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonLayui query(String name, Integer page, Integer limit) {
        List<User> users;
        System.out.println(page + "" + limit);
        JsonLayui jm = new JsonLayui();
        if (EmptyUtil.isEmpty(name)) {
            users = userBiz.query(null);
        } else {
            users = userBiz.query(name);
        }
        int size = users.size();
        int a = (page - 1) * limit; //开始行数
        int b = page * limit; //结束行数
        if (b > size) {
            b = size;
        }
       users = users.subList(a, b);
        jm.setData(users);
        jm.setCount(size);
        jm.setCode(0);
        return jm;
    }

    @RequestMapping(value = "/del.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonLayui deleteById(Integer id) {
        JsonLayui jm = new JsonLayui();
        if (userBiz.deleteById(id)) {
            jm.setCode(1);
            jm.setMsg("删除成功");
        } else {
            jm.setCode(1);
            jm.setMsg("删除失败");
        }

        return jm;
    }

    @RequestMapping(value = "/change.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonLayui change(Integer id, String name, String pwd, String sex) {
        JsonLayui jm = new JsonLayui();
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setPassword(pwd);
        user.setGender(sex);
        if (EmptyUtil.isEmpty(name)) {
            jm.setCode(1);
            jm.setMsg("请输入用户名！");
            return jm;
        }
        if (EmptyUtil.isEmpty(pwd)) {
            jm.setCode(1);
            jm.setMsg("请输入密码！");
            return jm;
        }
        if (EmptyUtil.isEmpty(sex)) {
            jm.setCode(1);
            jm.setMsg("请输入性别！");
            return jm;
        }
        if (userBiz.change(user)) {
            jm.setCode(1);
            jm.setMsg("修改成功");
        } else {
            jm.setCode(1);
            jm.setMsg("修改失败");
        }
        return jm;
    }

    @RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonLayui login(String name, String pwd) {
        JsonLayui jm = new JsonLayui();
        if (EmptyUtil.isEmpty(name)) {
            jm.setCode(1);
            jm.setMsg("请输入用户名！");
            return jm;
        }
        if (EmptyUtil.isEmpty(pwd)) {
            jm.setCode(1);
            jm.setMsg("请输入密码！");
            return jm;
        }
        if (userMapper.selectByNameAndPwd(name, pwd).size() == 1) {
            jm.setCode(0);
            jm.setMsg("登录成功");

        } else {
            jm.setCode(1);
            jm.setMsg("用户名或密码错误！");
        }
        return jm;
    }
}
