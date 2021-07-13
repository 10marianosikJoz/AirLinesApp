package com.example.airlines.service;

import com.example.airlines.dto.UserDTO;
import com.example.airlines.model.User;
import com.example.airlines.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    private final String email = "marcinjozwiak1997@gmail.com";
    private final String token = "cf6c52e3-b6d7-4145-bab5-4143fd06ccf1";
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;


    @Test
    void find_by_email_then_user_should_be_user_with_email() {
        User user = new User();
        user.setId(1L);
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
    }

    @Test
    void should_pass_test_when_user_is_found_by_token() {
        User user = new User();
        user.setFirstName("Marcin");
        user.setLastName("Jóźwiak");
        user.setResetPasswordToken(token);
        when(userService.getUserByToken(token)).thenReturn(user);
    }

    @Test
    void should_throw_exception_when_token_is_invalid() {
        User user = new User();
        user.setFirstName("Marcin");
        user.setLastName("Jóźwiak");
        user.setResetPasswordToken(token);
        when(userService.getUserByToken("cf632222e3-b6ss-4125-bab5-4143fd0611ccf1")).thenThrow(new UsernameNotFoundException("User with given token doesn't exist"));
    }

    @Test
    void should_update_reset_password_token_field_in_user_object() {
        User user = new User();
        user.setEmail(email);
        user.setResetPasswordToken("cf632222e3-b6ss-4125-bab5-4143fd0611ccf1");
        String tokenBeforeChange = user.getResetPasswordToken();
        userService.updateResetPasswordToken(token, user.getEmail());
        String tokenAfterChange = user.getResetPasswordToken();
        Assert.assertNotEquals(tokenBeforeChange, tokenAfterChange);
    }

    @Test
    void updatePassword() {
        User user = new User();
        user.setPassword("password");
        String currentPassword = user.getPassword();
        userService.updatePassword(user,"new_password");
        String newPassword = user.getPassword();
        Assert.assertNotEquals(currentPassword,newPassword);
    }



}