package com.zjl.subject.adapter;

import com.zjl.dto.user.dto.JwtTokenDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface FeignAdapter {

    @RequestMapping(path = "/jwt/get", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public ResponseEntity<JwtTokenDto> getToken(@RequestParam("account") String account, @RequestParam("password") String password);


}
