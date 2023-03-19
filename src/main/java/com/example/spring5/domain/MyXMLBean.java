package com.example.spring5.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Data
public class MyXMLBean {

    private final String name;
    private final List<Object> args;
    private final Map<String, Object> properties;


}
