package com.example.mockito.service;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final User existUser = new User("Sereja");
    private final User notExistUser = new User("324323");

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrue() {
        Assertions.assertTrue(out.checkUserExist(existUser));
    }

    @Test
    void shouldReturnFalse() {
        Assertions.assertFalse(out.checkUserExist(notExistUser));
    }
}