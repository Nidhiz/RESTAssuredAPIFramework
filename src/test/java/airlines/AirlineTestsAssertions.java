package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restUtils.AssertionUtils;

import java.util.*;

public class AirlineTestsAssertions extends AirlineAPIs {
    @Test
    public void createAirlinesForAssertions() {
        Airline request = Payloads.createAirlinePayloadFromPojo();
        Response response = createAirline(request);
        Map<String, Object> expectedValuesMap = new HashMap<>();
        expectedValuesMap.put("id", request.getId());
        expectedValuesMap.put("name", request.getName());
        expectedValuesMap.put("country", request.getCountry());
        expectedValuesMap.put("logo", request.getLogo());
        expectedValuesMap.put("slogan", request.getSlogan());
        expectedValuesMap.put("head_quaters", request.getHead_quaters());
        expectedValuesMap.put("website", request.getWebsite());
        expectedValuesMap.put("established", request.getEstablished());

        AssertionUtils.assertionExpectedValueFromJsonPath(response, expectedValuesMap);

    }
}
