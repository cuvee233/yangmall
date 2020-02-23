package com.weiyi.ymall.manager.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiyi
 * @since 2020/2/22 - 19:02
 */
@RestController
public class ManagerController {

    @RequestMapping("/index")
    public String index() {
        return "hello";
    }
}
