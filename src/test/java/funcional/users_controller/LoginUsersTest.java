package funcional.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import org.testng.annotations.Test;

import static com.practice.expandtesting.contants.endpoints.MenssagesConstants.INCORRECT_EMAIL_PASSWORD;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.addLoginUser;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.is;

public class LoginUsersTest extends BaseInicial {
    @Test(description = "should return incorrect email address or password")
    public void failureIncorrectEmailPassword() {
        loginUsersClient.postLoginUsers(addLoginUser())
                .statusCode(SC_UNAUTHORIZED)
                .body("message", is(INCORRECT_EMAIL_PASSWORD));
    }
}