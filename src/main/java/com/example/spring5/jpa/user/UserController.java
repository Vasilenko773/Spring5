package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User user(@PathVariable Integer id) {
       return userService.userById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<User> user() {
        return userService.users();
    }
}