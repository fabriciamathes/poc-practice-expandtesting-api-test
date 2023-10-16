package com.practice.expandtesting.client.users_controller;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_PROFILE;
import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_USERS;
import static io.restassured.RestAssured.given;

public class ProfileUsersClient {
    private final RequestSpecification requestSpecification;

    public ProfileUsersClient(RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public ValidatableResponse getUserProfile(String token) {
        return given()
                .spec(requestSpecification)
                .header("x-auth-token", token)
                .relaxedHTTPSValidation()
                .when()
                .get(ENDPOINT_USERS + ENDPOINT_PROFILE)
                .then();
    }
}
