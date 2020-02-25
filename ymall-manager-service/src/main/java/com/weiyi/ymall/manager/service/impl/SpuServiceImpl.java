package com.weiyi.ymall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weiyi.ymall.beans.PmsBaseSaleAttr;
import com.weiyi.ymall.beans.PmsProductInfo;
import com.weiyi.ymall.manager.service.mapper.PmsBaseSaleAttrMapper;
import com.weiyi.ymall.manager.service.mapper.SpuMapper;
import com.weiyi.ymall.service.BaseService;
import com.weiyi.ymall.service.manager.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author weiyi
 * @since 2020/2/23 - 20:50
 */
@Service
public class SpuServiceImpl extends BaseService implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        logger.info("getSpuList start");

        Example example = new Example(PmsProductInfo.class);
        example.setOrderByClause("id desc");
        example.and().andEqualTo("catalog3Id", catalog3Id);

        return spuMapper.selectByExample(example);
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        logger.info("baseSaleAttrList start");
        return pmsBaseSaleAttrMapper.selectAll();
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        logger.info("saveSpuInfo start pmsProductInfo = {}", pmsProductInfo);
        spuMapper.insertSelective(pmsProductInfo);
    }
}
