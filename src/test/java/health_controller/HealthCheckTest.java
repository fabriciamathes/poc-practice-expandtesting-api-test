package health_controller;

import com.practice.expandtesting.client.health_controller.BaseInicial;
import org.testng.annotations.Test;

import static com.practice.expandtesting.contants.endpoints.MenssagesConstants.SERVER_RUNNING;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class HealthCheckTest extends BaseInicial {
    @Test(description = "verifica se o serviço está up")
    //@Ignore
    public void getHealthCheckTest() {
        contrato.getHealth()
                .statusCode(SC_OK)
                .body(
                        "status", is(200),
                        "message", is(SERVER_RUNNING));
    }
}
