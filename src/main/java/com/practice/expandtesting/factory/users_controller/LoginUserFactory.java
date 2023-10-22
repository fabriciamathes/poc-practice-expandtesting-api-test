package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.dto.users_controller.LoginUsersDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUserFactory {
    public static LoginUsersDTO buildLoginUsers(String email, String password) {
        return LoginUsersDTO
                .builder()
                .email(email)
                .password(password)
                .build();
    }

    public static LoginUsersDTO addLoginUser() {
        return buildLoginUsers("lulu@tas.com", "teste123");
    }
}