package com.example.spring5.domain;

import lombok.Data;

@Data
public class MyBeanInjectAnnotation {

    @InjectBean
    private Driver driver;
}
