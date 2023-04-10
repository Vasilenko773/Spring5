package com.example.spring5.jpa.user;

import com.example.spring5.jpa.user.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter userFilter);
}
