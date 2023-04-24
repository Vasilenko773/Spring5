package com.example.spring5.jpa.user;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PostFilter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService /*implements UserDetailsService */{

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

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (userRepository.findByUsername(username).map(user ->
//                new org.springframework.security.core.userdetails.User(
//                        user.getUsername(),
//                        user.getPassword(),
//                        Collections.singleton(user.getRole()))).orElseThrow(() -> new UsernameNotFoundException("user not found")));
//    }
}
