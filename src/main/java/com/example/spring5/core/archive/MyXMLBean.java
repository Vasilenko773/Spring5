package com.example.spring5.core.archive;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class MyXMLBean {

    private final String name;
    private final List<Object> args;
    private final Map<String, Object> properties;

}
