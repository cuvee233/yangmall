package com.weiyi.ymall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weiyi.ymall.service.BaseService;
import com.weiyi.ymall.service.UserService;
import com.weiyi.ymall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getAllUser() {
        logger.info("getAllUser start");
        return umsMemberMapper.selectAll();
    }

    @Override
    public UmsMember getUserById(String uid) {
        logger.info("getUserById start uid = {}", uid);
        UmsMember umsMember = new UmsMember();
        umsMember.setId(uid);
        umsMember = umsMemberMapper.selectOne(umsMember);
        logger.info("getUserById start umsMember = {}", umsMember);
        return umsMember;
    }
}
