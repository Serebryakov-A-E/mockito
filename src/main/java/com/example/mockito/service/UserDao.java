package com.example.mockito.service;

import com.example.mockito.model.User;

import java.util.List;

public interface UserDao {
    User getByName(String name);

    List<User> findAllUsers();
}
