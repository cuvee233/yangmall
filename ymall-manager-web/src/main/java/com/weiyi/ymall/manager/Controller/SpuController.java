package com.weiyi.ymall.manager.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.weiyi.ymall.beans.PmsBaseSaleAttr;
import com.weiyi.ymall.beans.PmsProductInfo;
import com.weiyi.ymall.manager.util.MyUploadUtil;
import com.weiyi.ymall.service.manager.SpuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author weiyi
 * @since 2020/2/23 - 20:19
 */
@RestController
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;

    @RequestMapping("spuList")
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        return spuService.getSpuList(catalog3Id);
    }

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {

        long size = multipartFile.getSize();

        // 调用图片服务器，上传图片，返回服务器的url图片地址
        String imgUrl = MyUploadUtil.fileUpLoad(multipartFile);
        return imgUrl;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = spuService.baseSaleAttrList();

        return pmsBaseSaleAttrs;
    }

}
