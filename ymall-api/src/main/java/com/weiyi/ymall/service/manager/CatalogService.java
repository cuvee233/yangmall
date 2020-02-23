package com.weiyi.ymall.service.manager;

import com.weiyi.ymall.beans.PmsBaseCatalog1;
import com.weiyi.ymall.beans.PmsBaseCatalog2;
import com.weiyi.ymall.beans.PmsBaseCatalog3;

import java.util.List;

/**
 * 平台属性分类相关
 *
 * @author weiyi
 * @since 2020/2/22 - 23:58
 */
public interface CatalogService {

    /**
     * 获取平台一级分类
     *
     * @return 一级分类列表
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * 获取平台二级分类
     *
     * @param catalog1Id 一级分类ID
     * @return 二级分类列表
     */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 获取平台三级分类
     *
     * @param catalog2Id 二级分类ID
     * @return 三级分类列表
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);

}
