package com.example.spring5.domain;

import lombok.Data;

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


    private void init() {
        System.out.println("Инициализация MyXMLBean: method init()");
    }

    private void destroy() {
        System.out.println("Вызов destroy() method при закрытии application context");
    }
}
