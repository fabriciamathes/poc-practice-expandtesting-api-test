package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.dto.users_controller.LoginUsersDTO;

public class LoginUserFactory {
    public static LoginUsersDTO buildLoginUsers(String email, String password) {
        return LoginUsersDTO
                .builder()
                .email(email)
                .password(password)
                .build();
    }

    public static LoginUsersDTO addLoginUser() {
        return buildLoginUsers("teste@tas.com", "teste123");
    }
}