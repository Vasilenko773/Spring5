package com.example.spring5.core.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConnectionPool {

    private final  String url;
    private final  String username;
    private final  String password;

    public ConnectionPool(@Value("${my.connection.pool.url}") String url,
                          @Value("${my.connection.pool.username}") String username,
                          @Value("${my.connection.pool.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }



    @PostConstruct
    private void init() {
        System.out.println("#########");
        System.out.println("ConnectionPool init() method");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("--------");
        System.out.println("ConnectionPool destroy() method");
    }
}
