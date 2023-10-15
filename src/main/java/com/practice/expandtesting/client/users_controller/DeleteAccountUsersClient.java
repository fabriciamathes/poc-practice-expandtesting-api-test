package com.practice.expandtesting.client.users_controller;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_DELETE;
import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.ENDPOINT_USERS;
import static io.restassured.RestAssured.given;

public class DeleteAccountUsersClient {
    private final RequestSpecification requestSpecification;

    public DeleteAccountUsersClient(RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public ValidatableResponse deleteUsers(String token) {
        return given()
                .spec(requestSpecification)
                .header("x-auth-token", token)
                .relaxedHTTPSValidation()
                .when()
                .delete(ENDPOINT_USERS + ENDPOINT_DELETE)
                .then();
    }
}