package com.qt.userserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author MuYang @Perfma
 * @Date 2022/7/14 15:13
 * @version: V1.0
 */
@FeignClient(name = "ORDERSERVER")
public interface OrderFeginService {

    @RequestMapping("/order/get")
    String get(@RequestParam("id") Long id);


}
