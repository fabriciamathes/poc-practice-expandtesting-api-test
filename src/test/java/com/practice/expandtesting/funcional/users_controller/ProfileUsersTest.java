package com.practice.expandtesting.funcional.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_CREAT_USERNAME;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_DELETE;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_PROFILE;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.buildAddLoginUserLulu;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.buildRegisterValidUserProfile;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;

public class ProfileUsersTest extends BaseInicial {
    private String token;

    @BeforeClass
    public void setRegisterUser() {
        registerUsersClient.postRegisterUsers(buildRegisterValidUserProfile())
                           .statusCode(SC_CREATED)
                           .body("message", is(SUCCESS_CREAT_USERNAME));
        Response response = loginUsersClient.postLoginUsers(buildAddLoginUserLulu())
                                            .statusCode(SC_OK)
                                            .extract()
                                            .response();
        token = response.path("data.token");
    }

    @Test(description = "should return profile information for the logged-in current user.")
    public void successProfileInformation() {
        profileUsersClient.getUserProfile(token)
                          .statusCode(SC_OK)
                          .body("message", is(SUCCESS_PROFILE),
                                "data.email", is("lulu@tas.com"));
    }

    @AfterClass
    public void deleteRegisterUser() {
        deleteAccountUsersClient.deleteUsers(token)
                                .statusCode(SC_OK)
                                .body("message", is(SUCCESS_DELETE));
    }
}