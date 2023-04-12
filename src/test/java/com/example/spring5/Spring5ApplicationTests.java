package com.example.spring5;

import com.example.spring5.integration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

class Spring5ApplicationTests extends IntegrationTestBase {

    @Test
    void contextLoads() {
    }

}
