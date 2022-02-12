package com.widya.user.service.service;

import com.widya.user.service.entity.User;
import com.widya.user.service.repository.UserRepository;
import com.widya.user.service.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User payload) {
        PasswordEncoder passwordEnc = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(payload.getName());
        user.setAddress(payload.getAddress());
        user.setEmail(payload.getEmail());
        user.setPassword(passwordEnc.encode(payload.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public User detailUser(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found with id :" + id));

        return userById;
    }
}
