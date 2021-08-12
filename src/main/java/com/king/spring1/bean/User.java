package com.king.spring1.bean;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @program: spring1
 * @description:
 * @author: King
 * @create: 2021-08-12 13:48
 */

@Data

public class User {
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private Timestamp createAt;

    public User() {
    }
}
