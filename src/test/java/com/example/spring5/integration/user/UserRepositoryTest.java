package com.example.spring5.integration.user;

import com.example.spring5.jpa.user.User;
import com.example.spring5.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void tets1() {
        List<User> allBy = userRepository.findAllBy("%a%", "%ov%");
    }

    @Test
    @Transactional
    void checkUpdate() {
        User referenceById = userRepository.getReferenceById(1);
        int resultCount = userRepository.updateRole(referenceById.getRole(), 3);
        System.out.println(resultCount);
    }
}
