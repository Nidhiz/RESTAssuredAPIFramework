package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirlines() {

        Map<String, Object> payload = Payloads.createAirlinePayloadFromMap("1247810002", "Sri Lankan Airways", "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990 ");
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
