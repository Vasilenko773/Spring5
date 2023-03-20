package com.example.spring5.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
@Data
public class MyXMLBean {

    private final String name;
    private final List<Object> args;
    private final Map<String, Object> properties;

    private MyXMLBean(String name, List<Object> args, Map<String, Object> properties) {
        this.name = name;
        this.args = args;
        this.properties = properties;
    }

    public static MyXMLBean of(String name, List<Object> args, Map<String, Object> properties) {
        return new MyXMLBean(name, args, properties);
    }
}
