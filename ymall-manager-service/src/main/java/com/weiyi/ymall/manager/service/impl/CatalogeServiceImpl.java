package com.weiyi.ymall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weiyi.ymall.beans.PmsBaseCatalog1;
import com.weiyi.ymall.beans.PmsBaseCatalog2;
import com.weiyi.ymall.beans.PmsBaseCatalog3;
import com.weiyi.ymall.manager.service.mapper.Catalog1Mapper;
import com.weiyi.ymall.manager.service.mapper.Catalog2Mapper;
import com.weiyi.ymall.manager.service.mapper.Catalog3Mapper;
import com.weiyi.ymall.service.BaseService;
import com.weiyi.ymall.service.manager.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * 平台属性分类相关
 *
 * @author weiyi
 * @since 2020/2/22 - 23:58
 */
@Service
@CrossOrigin
public class CatalogeServiceImpl extends BaseService implements CatalogService {

    @Autowired
    private Catalog1Mapper catalog1Mapper;
    @Autowired
    private Catalog3Mapper catalog3Mapper;
    @Autowired
    private Catalog2Mapper catalog2Mapper;


    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        logger.info("getCatalog1 start ");
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        logger.info("getCatalog2 start catalog1Id = {}", catalog1Id);
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return catalog2Mapper.select(pmsBaseCatalog2);

    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        logger.info("getCatalog3 start catalog2Id = {}", catalog2Id);
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return catalog3Mapper.select(pmsBaseCatalog3);

    }
}
