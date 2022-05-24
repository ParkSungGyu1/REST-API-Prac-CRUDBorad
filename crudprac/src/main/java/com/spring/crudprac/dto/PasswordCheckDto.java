package com.spring.crudprac.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PasswordCheckDto {
    private Long id;
    private String password;
    private int result;


}
