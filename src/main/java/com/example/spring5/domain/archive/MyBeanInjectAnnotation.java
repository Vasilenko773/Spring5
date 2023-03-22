package com.example.spring5.domain.archive;

import com.example.spring5.annotation.InjectBean;
import com.example.spring5.domain.repository.ConnectionPool;
import lombok.Data;

@Data
public class MyBeanInjectAnnotation {

    @InjectBean
    private ConnectionPool connectionPool;
}
