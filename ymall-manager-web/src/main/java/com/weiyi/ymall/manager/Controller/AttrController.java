package com.weiyi.ymall.manager.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.weiyi.ymall.beans.PmsBaseAttrInfo;
import com.weiyi.ymall.beans.PmsBaseAttrValue;
import com.weiyi.ymall.service.manager.AttrService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台属性相关
 *
 * @author weiyi
 * @since 2020/2/23 - 14:04
 */
@RestController
@CrossOrigin
public class AttrController {

    @Reference
    private AttrService attrService;

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id) {
        return attrService.getAttrInfo(catalog3Id);
    }

    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValue(String attrId) {
        return attrService.getAttrValue(attrId);
    }

    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        Boolean success = attrService.addAttrInfo(pmsBaseAttrInfo);
        return "Success";
    }

    public static void main(String[] args) {

        // 平方
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream().map(num -> num * num).collect(Collectors.toList()).forEach(System.out::println);

    }
}
