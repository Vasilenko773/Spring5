package com.example.spring5.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
@Data
public class MyXMLBean {

    private  String name;
    private List<Object> args;
    private Map<String, Object> properties;

    public MyXMLBean(String name, List<Object> args, Map<String, Object> properties) {
        this.name = name;
        this.args = args;
        this.properties = properties;
    }

    public static MyXMLBean of(String name, List<Object> args, Map<String, Object> properties) {
        return new MyXMLBean(name, args, properties);
    }


}
