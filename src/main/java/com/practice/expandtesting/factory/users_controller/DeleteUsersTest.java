package com.practice.expandtesting.factory.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;


public class DeleteUsersTest extends BaseInicial {
    @Test(description = "DELETE USER token")
    public void successDeleteToken() {
        deleteAccountUsersClient.deleteUsers("bdd537a15fb6460099b33c736c097dea53a31b6829f24b80ade358b04e92cb20")
                .statusCode(SC_OK);
    }
}