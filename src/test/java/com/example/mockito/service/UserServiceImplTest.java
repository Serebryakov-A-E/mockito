package com.example.mockito.service;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final User existUser = new User("Sereja");
    private final User notExistUser = new User("324323");
    private User user = new User("Sereja");

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrue() {
        when(userDaoMock.getByName(existUser.getName())).thenReturn(user);
        Assertions.assertEquals(user, userDaoMock.getByName(existUser.getName()));
        Assertions.assertTrue(out.checkUserExist(existUser));
    }

    @Test
    void shouldReturnFalse() {
        when(userDaoMock.getByName(notExistUser.getName())).thenReturn(null);
        Assertions.assertNull(userDaoMock.getByName(notExistUser.getName()));
        Assertions.assertFalse(out.checkUserExist(notExistUser));
    }
}