package com.practice.expandtesting.client.health_controller;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.constants.endpoints.EndpointsConstants.ENDPOINT_HEALTH;
import static io.restassured.RestAssured.given;

public class HealthClient {
    private final RequestSpecification requestSpecification;

    public HealthClient(RequestSpecification specification) {
        this.requestSpecification = specification;
    }

    public ValidatableResponse getHealth() {
        return given()
                .spec(requestSpecification)
                .when()
                .get(ENDPOINT_HEALTH)
                .then();
    }
}