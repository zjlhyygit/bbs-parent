package com.zjl.subject.adapter.impl;

import com.zjl.dto.user.dto.GetUserDto;
import com.zjl.subject.adapter.UserAdapter;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserAdapterImpl implements UserAdapter {

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Override
    public ResponseEntity<GetUserDto> getUserById(Integer userId) {

        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");

        ResponseEntity<GetUserDto> response = restTemplate.getForEntity("http://user-service" + ":" +
                serviceInstance.getPort() + "/user/get/" + userId, GetUserDto.class);

        return response;
    }
}
