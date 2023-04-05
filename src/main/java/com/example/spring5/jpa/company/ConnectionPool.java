package com.example.spring5.jpa.company;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ConnectionPool {

    private final String url;

    private final String username;

    private final String password;

    public ConnectionPool(@Value("${my.connection.pool.url}") String url, @Value("${my.connection.pool.username}") String username, @Value("${my.connection.pool.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
