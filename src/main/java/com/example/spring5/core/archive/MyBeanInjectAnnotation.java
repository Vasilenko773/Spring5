package com.example.spring5.core.archive;

import com.example.spring5.core.annotation.InjectBean;
import com.example.spring5.jpa.company.ConnectionPool;
import lombok.Data;

@Data
public class MyBeanInjectAnnotation {

    @InjectBean
    private ConnectionPool connectionPool;
}
