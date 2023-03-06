package com.example.mockito.service;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final User existUser = new User("Sereja");
    private final User notExistUser = new User("324323");
    private final User user = new User("Sereja");

    private final List<User> users = List.of(
        new User("Sereja"),
        new User("Volodya"),
        new User("Denis"),
        new User("Anton"),
        new User("Katya")
    );

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrue() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertTrue(out.checkUserExist(existUser));
        verify(userDaoMock, times(1)).findAllUsers();
    }

    @Test
    void shouldReturnFalse() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertFalse(out.checkUserExist(notExistUser));
        verify(userDaoMock, times(1)).findAllUsers();

    }
}