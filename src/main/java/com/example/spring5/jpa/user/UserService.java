package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userById(Integer id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> users() {
        return userRepository.findAll();
    }
}
