package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<User> user() {
        return userService.users();
    }
}
