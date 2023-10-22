package com.practice.expandtesting.contract.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static com.practice.expandtesting.constants.SchemasConstants.CONTRACT_REGISTER_USER;
import static com.practice.expandtesting.constants.SchemasConstants.SCHEMA;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_DELETE;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.buildAddLoginUserTesteContract;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.buildRegisterValidUserContract;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;

@Feature("Contract | POST /users/register")
public class RegisterUsersContractTest extends BaseInicial {
    @Test(description = "should return 200 to contract schema")
    public void sucessContractSchema() {
        registerUsersClient.postRegisterUsers(buildRegisterValidUserContract())
                           .statusCode(SC_CREATED)
                           .body(matchesJsonSchema(new File(SCHEMA + CONTRACT_REGISTER_USER)));
        Response response = loginUsersClient.postLoginUsers(buildAddLoginUserTesteContract())
                                            .statusCode(SC_OK)
                                            .extract()
                                            .response();
        String token = response.path("data.token");
        deleteAccountUsersClient.deleteUsers(token)
                                .statusCode(SC_OK)
                                .body("message", is(SUCCESS_DELETE));
    }
}
