package com.weiyi.ymall.user.mapper;


import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsMemberMapper extends Mapper<UmsMember> {

    List<UmsMember> getAllUser();
}
