package com.example.mockito.service;

import com.example.mockito.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private final List<User> list;

    public UserDaoImpl() {
        list = new ArrayList<>();
        list.add(new User("Sereja"));
        list.add(new User("Volodya"));
        list.add(new User("Denis"));
        list.add(new User("Anton"));
        list.add(new User("Katya"));
    }

    @Override
    public User getByName(String name) {
        for (User user : list) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return list;
    }
}
