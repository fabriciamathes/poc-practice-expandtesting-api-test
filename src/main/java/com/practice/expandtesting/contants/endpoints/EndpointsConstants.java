package com.practice.expandtesting.contants.endpoints;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndpointsConstants {
    public static final String BASE_URL = "base_url";
    public static final String ENDPOINT = "/health-check";
    public static final String ENDPOINT_USERS = "/users";
    public static final String ENDPOINT_REGISTER = "/register";
    public static final String ENDPOINT_LOGIN = "/login";
    public static final String ENDPOINT_DELETE = "/delete-account";
    public static final String ENDPOINT_PROFILE = "/profile";
    public static final String TST = "tst";
}