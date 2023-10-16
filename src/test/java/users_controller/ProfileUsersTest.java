package users_controller;

import com.practice.expandtesting.client.BaseInicial;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.practice.expandtesting.contants.endpoints.MenssagesConstants.*;
import static com.practice.expandtesting.factory.users_controller.LoginUserFactory.addLoginUser;
import static com.practice.expandtesting.factory.users_controller.RegisterUsersFactory.registerValidUserProfile;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;

public class ProfileUsersTest extends BaseInicial {
    @Test(description = "should return profile information for the logged-in current user.")
    public void successProfileInformation() {
        registerUsersClient.postRegisterUsers(registerValidUserProfile())
                .statusCode(SC_CREATED)
                .body("message", is(SUCCESS_CREAT_USERNAME));
        Response response = loginUsersClient.postLoginUsers(addLoginUser())
                .statusCode(SC_OK)
                .extract().response();
        String token = response.path("data.token");
        profileUsersClient.getUserProfile(token)
                .statusCode(SC_OK)
                .body("message", is(SUCCESS_PROFILE),
                        "data.email", is("lulu@tas.com"));
        deleteAccountUsersClient.deleteUsers(token)
                .statusCode(SC_OK)
                .body("message", is(SUCCESS_DELETE));
    }
}