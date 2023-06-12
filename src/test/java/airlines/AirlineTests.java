package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests {

    @Test
    public void createAirlines(){
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String, Object> payload = Payloads.createAirlinePayloadFromMap("124781023", "Sri Lankan Airways", "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990 ");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
