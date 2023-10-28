package com.example.a2j_test.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class UserEntity implements Serializable {

    private Integer id;
    private String  username;
    private String  password;
    private Integer age;
    private Integer gender;
    private String  email;
    private Date    createDate;
}
