package com.example.spring5.web.mapper;

public interface Mapper <F, T>{

    T map(F object);
}
