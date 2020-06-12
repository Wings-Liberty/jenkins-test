package com.cx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.bean.User;
import com.cx.mapper.UserMapper;
import com.cx.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
