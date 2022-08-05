package com.zjl.subject.adapter;

import com.zjl.dto.user.dto.GetTokenDto;
import com.zjl.dto.user.dto.GetUserDto;
import com.zjl.dto.user.dto.JwtTokenDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;


public interface UserAdapter {

    ResponseEntity<GetUserDto> getUserById(Integer userId);



}
