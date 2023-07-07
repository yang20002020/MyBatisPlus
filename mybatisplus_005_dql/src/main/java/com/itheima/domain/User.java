package com.itheima.domain;
import lombok.Data;

//lombok
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String age;
    private String tel;

}
