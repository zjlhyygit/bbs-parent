package com.zjl.subject.adapter.impl;

import com.zjl.dto.user.dto.AddUserDto;
import com.zjl.dto.user.dto.GetUserDto;
import com.zjl.subject.adapter.UserAdapter;
import com.zjl.subject.adapter.UserFeignAdapter;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
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
    private UserFeignAdapter userFeignAdapter;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Override
    public ResponseEntity<GetUserDto> getUserById(Integer userId) {

        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");

        ResponseEntity<GetUserDto> response = restTemplate.getForEntity("http://user-service" + ":" +
                serviceInstance.getPort() + "/user/get/" + userId, GetUserDto.class);

        return response;
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public ResponseEntity<Integer> addUser(AddUserDto addUserDto) {
        ResponseEntity<Integer> response = userFeignAdapter.addOneUser(addUserDto);
        System.out.println("========"+ RootContext.getXID());
        int a = 1/0;
        return response;
    }
}
