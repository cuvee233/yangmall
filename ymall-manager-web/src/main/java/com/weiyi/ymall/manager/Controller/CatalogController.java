package com.weiyi.ymall.manager.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.weiyi.ymall.beans.PmsBaseCatalog1;
import com.weiyi.ymall.beans.PmsBaseCatalog2;
import com.weiyi.ymall.beans.PmsBaseCatalog3;
import com.weiyi.ymall.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weiyi
 * @since 2020/2/22 - 23:44
 */
@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> catalog1List = catalogService.getCatalog1();
        return catalog1List;
    }

    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog1(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}
