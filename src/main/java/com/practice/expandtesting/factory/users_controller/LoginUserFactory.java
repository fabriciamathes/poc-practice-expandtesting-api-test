package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.dto.users_controller.LoginUsersDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.practice.expandtesting.constants.auth.LoginConstants.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUserFactory {
    public static LoginUsersDTO buildLoginUsers(String email, String password) {
        return LoginUsersDTO
                .builder()
                .email(email)
                .password(password)
                .build();
    }
    public static LoginUsersDTO buildAddLoginUser() {

        return buildLoginUsers(EMAIL_TAS, PASSWORD);
    }
    public static LoginUsersDTO buildAddLoginUserTeste() {
        return buildLoginUsers(EMAIL_TESTE, PASSWORD);
    }
    public static LoginUsersDTO buildAddLoginUserLulu() {
        return buildLoginUsers(EMAIL_LULU, PASSWORD);
    }

    public static LoginUsersDTO buildAddLoginUserTesteContract() {
        return buildLoginUsers(EMAIL_MESTRE, PASSWORD);
    }
}