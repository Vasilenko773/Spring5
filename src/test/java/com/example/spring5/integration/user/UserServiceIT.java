package com.example.spring5.integration.user;

import com.example.spring5.jpa.user.UserService;
import com.example.spring5.integration.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@IT
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIT {

    @Autowired
    private UserService userService;


    @Test
    void test2() {

    }

    @Test
    void test1() {

    }
}
