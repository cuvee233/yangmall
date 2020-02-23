package com.weiyi.ymall.manager.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.weiyi.ymall.beans.PmsProductInfo;
import com.weiyi.ymall.service.manager.SpuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
