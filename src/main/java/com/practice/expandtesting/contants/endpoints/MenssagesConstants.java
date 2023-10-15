package com.practice.expandtesting.contants.endpoints;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenssagesConstants {
    public static final String INVALID_USERNAME = "User name must be between 4 and 30 characters";
    public static final String INVALID_ACCESS_TOKEN = "Access token is not valid or has expired, you will need to login";
    public static final String INCORRECT_EMAIL_PASSWORD = "Incorrect email address or password";
    public static final String SUCCESS_CREAT_USERNAME = "User account created successfully";
    public static final String SUCCESS_DELETE = "Account successfully deleted";

    public static final String SERVER_RUNNING = "Notes API is Running";
}