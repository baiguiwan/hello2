package com.example.demo2.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avataUrl;//fastjson可以自动把下划线转为驼峰风格
}
