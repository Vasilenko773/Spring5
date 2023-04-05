package com.example.spring5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@SpringBootTest
@PropertySource("classpath:application-test.yml")
class Spring5ApplicationTests {

    @Test
    void contextLoads() {
    }

}
