package com.zjl.dto.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GetUserDto extends AddUserDto{

    private Integer id;

    private Date ct;

    private Date ut;


}
