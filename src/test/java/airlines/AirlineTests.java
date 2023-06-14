package airlines;

import airlines.pojos.Airline;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AirlineTests extends AirlineAPIs {

//    @Test
//    public void createAirlines() {

    /* From string parameters */
//        Map<String, Object> payload = Payloads.createAirlinePayloadFromMap("1247810002", "Sri Lankan Airways", "Sri Lanka",
//                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
//                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990 ");

    /* From data faker library */
    // Map<String, Object> payload = Payloads.createAirlinePayloadFromMap();

    /* From POJO class*/
    // Airline payload = Payloads.createAirlinePayloadFromPojo();

    /* From Pojo class default values */

//        Airline payload = new Airline();
//        Response response = createAirline(payload);
//        Assert.assertEquals(response.statusCode(), 200);
//    }

    @Test
    public void createAirlinesAndVerifyResponse() throws JsonProcessingException {
        Airline payload = new Airline();
        Response response = createAirline(payload);

        //First Way - Json Path
        Assert.assertEquals(response.jsonPath().getString("name"), payload.getName());

        //Second way - objectmapper class
        ObjectMapper objectMapper = new ObjectMapper();
        Airline createAirlineResponse = objectMapper.readValue(response.getBody().asString(),Airline.class);
        Assert.assertEquals(createAirlineResponse, payload);
    }
}
