package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userById(Integer id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
