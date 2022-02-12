package com.widya.user.service.service;

import com.widya.user.service.entity.User;

public interface UserService {
    User registerUser(User user);
    User detailUser(Long id);
}
