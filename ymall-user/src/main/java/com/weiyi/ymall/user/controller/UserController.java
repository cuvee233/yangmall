package com.weiyi.ymall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.weiyi.ymall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;


    @RequestMapping("getUserById/{uid}")
    @ResponseBody
    public UmsMember getUserById(@PathVariable("uid") String uid) {

        UmsMember umsMember = userService.getUserById(uid);

        return umsMember;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = userService.getAllUser();

        return umsMembers;
    }
}
