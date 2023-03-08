package com.example.mockito.service;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final User existUser = new User("Sereja");
    private final User notExistUser = new User("324323");
    private final User user = new User("Sereja");

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrue() {
        when(userDaoMock.getByName(existUser.getName())).thenReturn(user);
        assertTrue(out.checkUserExist(existUser));
        verify(userDaoMock, times(1)).getByName(existUser.getName());
    }

    @Test
    void shouldReturnFalse() {
        when(userDaoMock.getByName(notExistUser.getName())).thenReturn(null);
        assertFalse(out.checkUserExist(notExistUser));
        verify(userDaoMock, times(1)).getByName(notExistUser.getName());
    }
}