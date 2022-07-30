package com.zjl.subject.adapter;

import com.zjl.dto.user.dto.JwtTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserFeignAdapter {

    @RequestMapping(path = "/jwt/get", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    ResponseEntity<JwtTokenDto> getToken(@RequestParam("account") String account, @RequestParam("password") String password);

    @RequestMapping(path = "/test" ,method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    ResponseEntity<String> test();
    

}
