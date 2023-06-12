package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests {

    @Test
    public void createAirlines() throws IOException {
        Map<String, String>  data = JsonUtils.getJsonDataAsMap("airlines/qa/airlinesAPIData.json");
        String endPoint = data.get("createAirlinesEndpoints");
        Map<String, Object> payload = Payloads.createAirlinePayloadFromMap("124781023", "Sri Lankan Airways", "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990 ");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
