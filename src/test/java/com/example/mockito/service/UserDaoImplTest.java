package com.example.mockito.service;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {
    private final User existUser = new User("Sereja");

    private final User notExistUser = new User("324323");

    private final UserDaoImpl userDao;

    UserDaoImplTest() {
        this.userDao = new UserDaoImpl();
    }

    @Test
    public void shouldReturnUserByName() {
        Assertions.assertEquals(existUser, userDao.getByName(existUser.getName()));
    }

    @Test
    public void shouldReturnNullByName() {
        Assertions.assertNull(userDao.getByName(notExistUser.getName()));
    }
}