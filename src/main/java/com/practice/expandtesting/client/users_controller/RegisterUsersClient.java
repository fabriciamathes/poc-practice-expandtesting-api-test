package com.practice.expandtesting.client.users_controller;

import com.practice.expandtesting.dto.users_controller.RegisterUsersDTO;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_REGISTER;
import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_USERS;
import static io.restassured.RestAssured.given;

public class RegisterUsersClient {
    private final RequestSpecification requestSpecification;

    public RegisterUsersClient(RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public ValidatableResponse postRegisterUsers(RegisterUsersDTO registerUsersDTO) {
        return given()
                .spec(requestSpecification)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(registerUsersDTO)
                .when()
                .post(ENDPOINT_USERS + ENDPOINT_REGISTER)
                .then();
    }
}