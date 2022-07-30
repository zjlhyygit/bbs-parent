package com.zjl.subject.controller;

import com.zjl.dto.user.dto.GetUserDto;
import com.zjl.dto.user.dto.JwtTokenDto;
import com.zjl.subject.adapter.UserFeignAdapter;
import com.zjl.subject.adapter.UserAdapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RestController
public class TestController {

    @Resource
    private UserAdapter userAdapter;

    @Resource
    private UserFeignAdapter feignAdapter;

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<GetUserDto> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userAdapter.getUserById(id));
    }

    @RequestMapping(path = "jwt/get", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<JwtTokenDto> getToken(@Param("account") String account, @Param("password") String password) throws UnsupportedEncodingException {
        return feignAdapter.getToken(account, password);
    }

}
