package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.dto.users_controller.RegisterUsersDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.practice.expandtesting.constants.auth.LoginConstants.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterUsersFactory {
    public static RegisterUsersDTO buildRegisterUsers(String name, String email, String password) {
        return RegisterUsersDTO
                .builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public static RegisterUsersDTO buildRegisterValidUser() {
        return buildRegisterUsers("Lindinha Testes", EMAIL_TESTE, PASSWORD);
    }

    public static RegisterUsersDTO buildRegisterValidUserProfile() {
        return buildRegisterUsers("Luluzinha Testes", EMAIL_LULU, PASSWORD);
    }

    public static RegisterUsersDTO buildInvalidUser() {
        return buildRegisterUsers(INCORRECT_NAME, EMAIL_TAS, PASSWORD);
    }
}