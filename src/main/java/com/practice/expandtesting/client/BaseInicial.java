package com.practice.expandtesting.client;

import com.practice.expandtesting.client.health_controller.HealthClient;
import com.practice.expandtesting.client.users_controller.DeleteAccountUsersClient;
import com.practice.expandtesting.client.users_controller.LoginUsersClient;
import com.practice.expandtesting.client.users_controller.RegisterUsersClient;
import io.restassured.specification.RequestSpecification;

import static com.practice.expandtesting.spec.ServerSpecification.getRequestSpecification;

public class BaseInicial {

    protected static final RequestSpecification spec = getRequestSpecification();
    protected static HealthClient contrato = new HealthClient(spec);
    protected static RegisterUsersClient registerUsersClient = new RegisterUsersClient(spec);
    protected static LoginUsersClient loginUsersClient = new LoginUsersClient(spec);
    protected static DeleteAccountUsersClient deleteAccountUsersClient = new DeleteAccountUsersClient(spec);
}