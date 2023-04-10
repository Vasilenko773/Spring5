package com.example.spring5.integration.user;

import com.example.spring5.jpa.user.User;
import com.example.spring5.jpa.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Test
    void testFirst() {
        Optional<User> first = userRepository.findFirstByOrderByIdDesc();
        Assertions.assertTrue(first.isPresent());
        List<User> firstList = userRepository.findFirst3ByBirthDateBefore(LocalDate.now(),
                Sort.by("birthDate"));
        Assertions.assertEquals(3, firstList.size());
    }

    @Test
    @Transactional
    void testPageable() {
        PageRequest id = PageRequest.of(0, 1, Sort.by("id"));
        var slice = userRepository.findAllBy(id);
        System.out.println("------");
        System.out.println(slice.getTotalPages());
        System.out.println("------");
        slice.forEach(System.out::println);
      while (slice.hasNext()) {
          slice = userRepository.findAllBy(slice.nextPageable());
          slice.forEach(System.out::println);
      }

    }
}
