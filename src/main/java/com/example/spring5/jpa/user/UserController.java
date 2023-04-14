package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public User user(@PathVariable Integer id) {
       return userService.userById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody User user) {
        userService.save(user);
    }
}
