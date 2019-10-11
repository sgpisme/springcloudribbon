package com.sgp.ribbonclient.service;

import com.sgp.ribbonclient.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("service-hello")
public interface IFeignClientService {
    @RequestMapping("/hello")
    String hello(@RequestParam("id") String id);

    @RequestMapping(value = "/playgameornot",method = RequestMethod.POST)
    String playgameornot(@RequestBody User user);
}
