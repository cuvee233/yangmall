package com.weiyi.ymall.service.manager;

import com.weiyi.ymall.beans.PmsBaseAttrInfo;
import com.weiyi.ymall.beans.PmsBaseAttrValue;

import java.util.List;

/**
 * 平台属性相关
 *
 * @author weiyi
 * @since 2020/2/23 - 14:06
 */
public interface AttrService {

    /**
     * 根据三级分类ID查询平台属性名称
     *
     * @param catalog3Id 三级分类ID
     * @return 属性名集合
     */
    List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id);

    /**
     * 根据平台属性名称ID查询平台属性值
     *
     * @param attrId 属性ID
     * @return 属性值集合
     */
    List<PmsBaseAttrValue> getAttrValue(String attrId);

    /**
     * 保存平台属性
     *
     * @param pmsBaseAttrInfo 属性DO
     * @return result
     */
    Boolean addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     * 保存平台属性值
     *
     * @param pmsBaseAttrValue 属性值DO
     * @return result
     */
    Boolean addAttrValue(PmsBaseAttrValue pmsBaseAttrValue);

    /**
     * 更新平台属性
     *
     * @param pmsBaseAttrInfo 属性DO
     * @return result
     */
    Boolean updateAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);


    /**
     * 删除平台属性
     *
     * @param id 属性ID
     * @return result
     */
    Boolean delteAttrInfo(String id);

    /**
     * 删除平台属性值
     *
     * @param id 属性值ID
     * @return result
     */
    Boolean deleteAttrValue(String id);

}
