package com.practice.expandtesting.environment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.practice.expandtesting.contants.endpoints.EndpointsConstants.TST;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Environment {
    public static String getEnvironment() {
        String environment = System.getenv("env");
        if (environment != null) {
            System.setProperty("env", environment);
        }
        return System.getProperty("env", TST);
    }
}