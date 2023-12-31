package com.practice.expandtesting.funcional.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.practice.expandtesting.constants.message.MenssagesConstants.INVALID_USERNAME;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_CREAT_USERNAME;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_DELETE;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.buildAddLoginUserTeste;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.buildInvalidUser;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.buildRegisterValidUser;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;


public class RegisterUsersTest extends BaseInicial {

    @Test(description = "should add a user successfully")
    public void successRegisterUser() {
        registerUsersClient.postRegisterUsers(buildRegisterValidUser())
                           .statusCode(SC_CREATED)
                           .body("message", is(SUCCESS_CREAT_USERNAME));
    }

    @AfterClass
    public void deleteRegisterUser() {
        Response response = loginUsersClient.postLoginUsers(buildAddLoginUserTeste())
                                            .statusCode(SC_OK)
                                            .extract()
                                            .response();
        String token = response.path("data.token");
        deleteAccountUsersClient.deleteUsers(token)
                                .statusCode(SC_OK)
                                .body("message", is(SUCCESS_DELETE));
    }

    @Test(description = "should return invalid user name")
    public void failureInvalidUserName() {
        registerUsersClient.postRegisterUsers(buildInvalidUser())
                           .statusCode(SC_BAD_REQUEST)
                           .body("message", is(INVALID_USERNAME));
    }
}