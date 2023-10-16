package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.dto.users_controller.RegisterUsersDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterUsersFactory {
    public static RegisterUsersDTO builRegisterUsers(String name, String email, String password) {
        return RegisterUsersDTO
                .builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public static RegisterUsersDTO registerValidUser() {
        return builRegisterUsers("Lindinha Testes", "teste@tas.com", "teste123");
    }

    public static RegisterUsersDTO registerValidUserProfile() {
        return builRegisterUsers("Luluzinha Testes", "lulu@tas.com", "teste123");
    }

    public static RegisterUsersDTO invalidUser() {
        return builRegisterUsers("Tes", "tas@teste.com", "teste123");
    }
}