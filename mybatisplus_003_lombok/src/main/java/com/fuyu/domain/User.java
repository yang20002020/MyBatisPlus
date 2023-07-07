package com.fuyu.domain;


import lombok.*;

//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String age;
    private String tel;

}
