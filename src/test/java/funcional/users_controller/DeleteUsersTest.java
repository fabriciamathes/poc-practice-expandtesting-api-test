package funcional.users_controller;

import com.practice.expandtesting.client.BaseInicial;
import org.testng.annotations.Test;

import static com.practice.expandtesting.contants.endpoints.MenssagesConstants.INVALID_ACCESS_TOKEN;
import static com.practice.expandtesting.contants.endpoints.TokenConstants.INCORRECT_TOKEN;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.is;

public class DeleteUsersTest extends BaseInicial {
    @Test(description = "should return incorrect email address or password")
    public void failureIncorrectEmailPassword() {
        deleteAccountUsersClient.deleteUsers(INCORRECT_TOKEN)
                .statusCode(SC_UNAUTHORIZED)
                .body("message", is(INVALID_ACCESS_TOKEN));
    }
}