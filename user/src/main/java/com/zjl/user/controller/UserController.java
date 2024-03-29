package com.zjl.user.controller;

import com.zjl.dto.user.dto.AddUserDto;
import com.zjl.dto.user.dto.GetUserDto;
import com.zjl.sentinel.MyHttpResponseData;
import com.zjl.user.config.DemoConfig;
import com.zjl.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
//
    @Resource
    private DemoConfig demoConfig;


    @Value("${spring:datasource:druid:url}")
    private String name;

    @RequestMapping(path = "/add", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<Integer> addOneUser(@RequestBody AddUserDto req) throws UnsupportedEncodingException {
        return ResponseEntity.ok(userService.addOneUser(req));
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<MyHttpResponseData> getUserById(@PathVariable("id") Integer id) {
        GetUserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(new MyHttpResponseData<GetUserDto>(userDto,GetUserDto.class));
    }

    @RequestMapping(path = "/nacos/configTest", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<String> configTest() {
        return ResponseEntity.ok(name);
    }


}
