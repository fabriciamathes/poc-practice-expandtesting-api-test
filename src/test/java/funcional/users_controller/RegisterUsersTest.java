package funcional.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.practice.expandtesting.constants.message.MenssagesConstants.INVALID_USERNAME;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_CREAT_USERNAME;
import static com.practice.expandtesting.constants.message.MenssagesConstants.SUCCESS_DELETE;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.addLoginUser;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.invalidUser;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.registerValidUser;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;


public class RegisterUsersTest extends BaseInicial {
    @Test(description = "should add a user successfully")
    public void successRegisterUser() {
        registerUsersClient.postRegisterUsers(registerValidUser())
                           .statusCode(SC_CREATED)
                           .body("message", is(SUCCESS_CREAT_USERNAME));
        Response response = loginUsersClient.postLoginUsers(addLoginUser())
                                            .statusCode(SC_OK)
                                            .extract()
                                            .response();
        String token = response.path("data.token");
        deleteAccountUsersClient.deleteUsers(token)
                                .statusCode(SC_OK)
                                .body("message", is(SUCCESS_DELETE));
    }

    @Test(description = "should return invalid user name")
    public void failureInvalidUserName() {
        registerUsersClient.postRegisterUsers(invalidUser())
                           .statusCode(SC_BAD_REQUEST)
                           .body("message", is(INVALID_USERNAME));
    }
}