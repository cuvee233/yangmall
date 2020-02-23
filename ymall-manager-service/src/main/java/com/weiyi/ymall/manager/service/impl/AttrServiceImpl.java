package com.weiyi.ymall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weiyi.ymall.beans.PmsBaseAttrInfo;
import com.weiyi.ymall.beans.PmsBaseAttrValue;
import com.weiyi.ymall.manager.service.mapper.PmsBaseAttrInfoMapper;
import com.weiyi.ymall.manager.service.mapper.PmsBaseAttrValueMapper;
import com.weiyi.ymall.service.BaseService;
import com.weiyi.ymall.service.manager.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author weiyi
 * @since 2020/2/23 - 14:11
 */
@Service
public class AttrServiceImpl extends BaseService implements AttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id) {
        logger.info("getAttrInfo start catalog3Id = {}", catalog3Id);

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        // 封装Value
        for (PmsBaseAttrInfo baseAttrInfo : attrInfoList) {
            String attrInfoId = baseAttrInfo.getId();
            List<PmsBaseAttrValue> attrValueList = getAttrValue(attrInfoId);
            baseAttrInfo.setAttrValueList(attrValueList);
        }

        logger.info("getAttrInfo finished catalog3Id = {} | size = {}", catalog3Id, attrInfoList.size());
        return attrInfoList;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValue(String attrId) {
        logger.info("getAttrValue start attrId = {}", attrId);

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);

        logger.info("getAttrValue finished attrId = {} | size = {}", attrId, attrValueList.size());
        return attrValueList;
    }

    @Override
    public Boolean addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        logger.info("addAttrInfo start pmsBaseAttrInfo = {}", pmsBaseAttrInfo);

        int result = 0;
        String attrInfoId = pmsBaseAttrInfo.getId();

        // 属性值
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        if (StringUtils.isBlank(attrInfoId)) {
            // 保存属性
            result = pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            String attr_id = pmsBaseAttrInfo.getId();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(attr_id);
                addAttrValue(pmsBaseAttrValue);
            }
        } else {
            // 删除所有属性对应的属性值数据
            deleteAttrValueByInfoId(attrInfoId);
            // 重新添加一次页面传递的属性值集合
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(attrInfoId);
                this.addAttrValue(pmsBaseAttrValue);
            }
        }

        logger.info("addAttrInfo finished result = {}", result);
        return result > 0;
    }

    @Override
    public Boolean addAttrValue(PmsBaseAttrValue pmsBaseAttrValue) {
        logger.info("addAttrValue start pmsBaseAttrValue = {}", pmsBaseAttrValue);

        int result = pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
        logger.info("addAttrValue finished result = {}", result);
        return result > 0;
    }

    @Override
    public Boolean updateAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        logger.info("updateAttrInfo start pmsBaseAttrInfo = {}", pmsBaseAttrInfo);

        int result = pmsBaseAttrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);

        logger.info("updateAttrInfo finished result = {}", result);
        return result > 0;
    }


    @Override
    public Boolean delteAttrInfo(String id) {
        logger.info("delteAttrInfo start id = {}", id);

        int result = pmsBaseAttrInfoMapper.deleteByPrimaryKey(id);

        logger.info("delteAttrInfo finished result = {}", result);
        return result > 0;
    }

    @Override
    public Boolean deleteAttrValue(String id) {
        logger.info("deleteAttrValue start id = {}", id);

        int result = pmsBaseAttrValueMapper.deleteByPrimaryKey(id);

        logger.info("deleteAttrValue finished result = {}", result);
        return result > 0;
    }

    private Boolean deleteAttrValueByInfoId(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        int result = pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
        logger.info("deleteAttrValueByInfoId start attrId = {} | result = {}", attrId, result);
        return result > 0;
    }
}
