package com.zyd.learn.spring;

import javax.swing.*;

public class UserServiceImpl implements UserService {
    public String getName() {
        System.out.println("获取用户名称： "+"zyd");
        return "zyd";
    }
}
