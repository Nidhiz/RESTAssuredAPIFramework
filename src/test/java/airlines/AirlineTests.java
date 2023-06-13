package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirlines() {

        /* From string parameters */
//        Map<String, Object> payload = Payloads.createAirlinePayloadFromMap("1247810002", "Sri Lankan Airways", "Sri Lanka",
//                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
//                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990 ");

        /* From data faker library */
       // Map<String, Object> payload = Payloads.createAirlinePayloadFromMap();

        /* From POJO class*/
        Airline payload = Payloads.createAirlinePayloadFromPojo();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
