package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restUtils.AssertionUtils;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.*;

public class AirlineTestsAssertions extends AirlineAPIs {
//    @Test
//    public void createAirlinesForAssertions() {
//        Airline request = Payloads.createAirlinePayloadFromPojo();
//        Response response = createAirline(request);
//        Map<String, Object> expectedValuesMap = new HashMap<>();
//        expectedValuesMap.put("id", request.getId());
//        expectedValuesMap.put("name", request.getName());
//        expectedValuesMap.put("country", request.getCountry());
//        expectedValuesMap.put("logo", request.getLogo());
//        expectedValuesMap.put("slogan", request.getSlogan());
//        expectedValuesMap.put("head_quaters", request.getHead_quaters());
//        expectedValuesMap.put("website", request.getWebsite());
//        expectedValuesMap.put("established", request.getEstablished());
//
//        AssertionUtils.assertionExpectedValueFromJsonPath(response, expectedValuesMap);
//
//    }

    @Test(dataProvider = "airlineData")
    public void createAirlinesForAssertions(Airline airline) {
        Response response = createAirline(airline);
        Map<String, Object> expectedValuesMap = new HashMap<>();
        expectedValuesMap.put("id", airline.getId());
        expectedValuesMap.put("name", airline.getName());
        expectedValuesMap.put("country", airline.getCountry());
        expectedValuesMap.put("logo", airline.getLogo());
        expectedValuesMap.put("slogan", airline.getSlogan());
        expectedValuesMap.put("head_quaters", airline.getHead_quaters());
        expectedValuesMap.put("website", airline.getWebsite());
        expectedValuesMap.put("established", airline.getEstablished());

        AssertionUtils.assertionExpectedValueFromJsonPath(response, expectedValuesMap);

    }

    @DataProvider(name = "airlineData")
    public Iterator<Airline> getCreateAirlinesData() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtils.getExcelDataAsListOfMap("createAirlineData", "Sheet1");

        List<Airline> airlineListData = new ArrayList<>();
        for (LinkedHashMap<String, String> data : excelDataAsListOfMap) {
            Airline airline = Airline.builder()
                    .id(Integer.parseInt(data.get("Id")))
                    .name(data.get("Name"))
                    .country(data.get("Country"))
                    .logo(data.get("Logo"))
                    .slogan(data.get("Slogan"))
                    .head_quaters(data.get("HeadQuarter"))
                    .website(data.get("Website"))
                    .established(data.get("Established"))
                    .build();
            airlineListData.add(airline);
        }
        return airlineListData.iterator();
    }

}
