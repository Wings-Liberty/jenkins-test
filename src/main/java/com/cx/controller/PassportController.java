package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cx.bean.ResUtils;
import com.cx.bean.User;
import com.cx.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class PassportController {

    @Autowired
    UserService userService;

    /**
     * 登录成功页面
     * 无认证流程，可直接使用url访问此接口
     * @return 返回到登录成功页面
     */

    @GetMapping("/success")
    public String toSuccess(){
        System.out.println("success");
        return "success";
    }

    /**
     * 返回到登录页
     * @return 返回到登录页
     */
    @GetMapping("/index")
    public String toIndex(){
        System.out.println("index");
        return "index";
    }

    /**
     * 注册用户
     * @param user 包含用户的用户名和密码
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ResUtils register(User user){

        // 判空
        if (user == null) {
            return ResUtils.failure("参数为空，重新填写参数");
        } else if (StringUtils.isEmpty(user.getUsername())){
            return ResUtils.failure("用户名为空，请重新填写");
        } else if(StringUtils.isEmpty(user.getPassword())){
            return ResUtils.failure("密码为空，请重新填写");
        }

        // 检查用户名是否已经存在
        User one = userService.getOne(
                new QueryWrapper<User>()
                        .eq("username", user.getUsername())
        );

        if (one != null) {
            return ResUtils.failure("用户名已存在");
        }

        // 对密码进行加密
        String salt = UUID.randomUUID().toString();
        user.setPassword(user.getPassword() + salt);
        user.setSalt(salt);

        // 存入数据库
        boolean res = userService.save(user);
        if(!res){
            return ResUtils.failure("数据库error");
        }

        return ResUtils.success("注册成功");
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResUtils login(User user){

        // 判空
        if (user == null) {
            return ResUtils.failure("参数为空，重新填写参数");
        } else if (StringUtils.isEmpty(user.getUsername())){
            return ResUtils.failure("用户名为空，请重新填写");
        } else if(StringUtils.isEmpty(user.getPassword())){
            return ResUtils.failure("密码为空，请重新填写");
        }

        // 根据用户名获取user对象并匹配密码
        User one = userService.getOne(
                new QueryWrapper<User>()
                        .eq("username", user.getUsername())
        );

        if(one ==null){
            return ResUtils.failure("用户名或密码错误");
        }

        boolean res = one.getPassword().equals(user.getPassword() + one.getSalt());

        if(!res){
            return ResUtils.failure("用户名或密码错误");
        }

        return ResUtils.success("登录成功");

    }



}