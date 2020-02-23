package com.weiyi.ymall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weiyi.ymall.beans.PmsProductInfo;
import com.weiyi.ymall.manager.service.mapper.SpuMapper;
import com.weiyi.ymall.service.manager.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author weiyi
 * @since 2020/2/23 - 20:50
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return spuMapper.select(pmsProductInfo);
    }
}
