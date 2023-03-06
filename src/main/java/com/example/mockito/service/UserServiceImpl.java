package com.example.mockito.service;

import com.example.mockito.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean checkUserExist(User user) {
        User u = userDao.getByName(user.getName());
        return u != null;
    }
}
