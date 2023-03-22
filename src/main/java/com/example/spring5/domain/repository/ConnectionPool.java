package com.example.spring5.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionPool {

    private String url;
    private String username;
    private String password;
}
