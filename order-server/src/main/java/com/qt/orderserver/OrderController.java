package com.qt.orderserver;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MuYang @Perfma
 * @Date 2022/7/14 15:10
 * @version: V1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserFeginService userFeginService;

    @GetMapping("/get")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String get(@RequestParam("id") Long id){
        return "OrderController"+id;
    }
    public String fallbackMethod(Long id){
        return "这是fallbackMethod"+id;
    }


    @GetMapping("/getUser")
    public String getUser(){
        return userFeginService.get(1L);
    }

}
