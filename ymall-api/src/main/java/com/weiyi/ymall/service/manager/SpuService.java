package com.weiyi.ymall.service.manager;

import com.weiyi.ymall.beans.PmsBaseSaleAttr;
import com.weiyi.ymall.beans.PmsProductInfo;

import java.util.List;

/**
 * 产品单元相关
 *
 * @author weiyi
 * @since 2020/2/23 - 20:50
 */
public interface SpuService {

    /**
     * 查询Spu列表
     *
     * @param catalog3Id 平台三级分类ID
     * @return SPU列表
     */
    List<PmsProductInfo> getSpuList(String catalog3Id);

    /**
     * 查询销售属性列表
     *
     * @return
     */
    List<PmsBaseSaleAttr> baseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

}
