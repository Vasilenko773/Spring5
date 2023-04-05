package com.example.spring5.jpa;

import java.io.Serializable;

public interface BaseEntity <T extends Serializable> {

    T getId();
}
