package com.practice.expandtesting.client.users_controller;

import com.practice.expandtesting.dto.users_controller.LoginUsersDTO;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_LOGIN;
import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_USERS;
import static io.restassured.RestAssured.given;

public class LoginUsersClient {
    private final RequestSpecification requestSpecification;

    public LoginUsersClient(RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public ValidatableResponse postLoginUsers(LoginUsersDTO loginUsersDTO) {
        return given()
                .spec(requestSpecification)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .body(loginUsersDTO)
                .when()
                .post(ENDPOINT_USERS + ENDPOINT_LOGIN)
                .then();
    }
}