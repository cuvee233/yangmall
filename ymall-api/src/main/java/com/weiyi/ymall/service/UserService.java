package com.weiyi.ymall.service;

import com.weiyi.ymall.beans.UmsMember;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    UmsMember getUserById(String uid);
}
