package airlines;

import airlines.pojos.Airline;
import airlines.pojos.CreateAirline;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.Setup;
import restUtils.AssertionUtils;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.*;

public class AirlineTestsScenarios extends AirlineAPIs {


    @Test(dataProvider = "airlineData")
    public void createAirlinesForAssertions(CreateAirline airline) {

        ExtentTest test = Setup.extentReports.createTest("Test Name " + airline.getScenarioID(),
                airline.getScenarioDesc());
        Setup.extentTest.set(test);

        Response response = createAirline(airline);

        if (airline.getExpectedStatusCode() != 200) {
            if (airline.getScenarioID().equalsIgnoreCase("CreateAirline_DuplicateID"))
                response = createAirline(airline);
            Assert.assertEquals(response.getStatusCode(), airline.getExpectedStatusCode());
            Assert.assertEquals(response.jsonPath().getString("message"), airline.getExpectedErrorMessage());
        } else {
            Map<String, Object> expectedValuesMap = new HashMap<>();
            expectedValuesMap.put("id", airline.getId());
            expectedValuesMap.put("name", airline.getName());
            expectedValuesMap.put("country", airline.getCountry());
            expectedValuesMap.put("logo", airline.getLogo());
            expectedValuesMap.put("slogan", airline.getSlogan());
            expectedValuesMap.put("head_quaters", airline.getHead_quaters());
            expectedValuesMap.put("website", airline.getWebsite());
            expectedValuesMap.put("established", airline.getEstablished());


            if (airline.getScenarioID().equalsIgnoreCase("CreateAirline_WithoutID")) {
                expectedValuesMap.remove("id");
            }

            AssertionUtils.assertionExpectedValueFromJsonPath(response, expectedValuesMap);
        }
    }


    @DataProvider(name = "airlineData")
    public Iterator<CreateAirline> getCreateAirlinesData() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtils.getExcelDataAsListOfMap("CreateAirlineDataScenarios", "Sheet1");

        List<CreateAirline> airlineListData = new ArrayList<>();
        for (LinkedHashMap<String, String> data : excelDataAsListOfMap) {
            CreateAirline createAirline = getCustomizedAirlineData(data);
            airlineListData.add(createAirline);
        }
        return airlineListData.iterator();
    }

    private CreateAirline getCustomizedAirlineData(LinkedHashMap<String, String> data) {
        CreateAirline createAirline = new CreateAirline();
        createAirline.setScenarioID(data.get("ScenarioID"));
        createAirline.setScenarioDesc(data.get("ScenarioDesc"));
        createAirline.setExpectedStatusCode(Integer.parseInt(data.get("ExpectedStatusCode")));
        createAirline.setExpectedErrorMessage(data.get("ExpectedErrorMessage"));

        if (!data.get("ExpectedErrorMessage").equals("NO_DATA"))
            createAirline.setExpectedErrorMessage(data.get("ExpectedErrorMessage"));
        if (!data.get("Id").equals("NO_DATA"))
            createAirline.setId(Integer.parseInt(data.get("Id")));
        if (!data.get("Name").equals("NO_DATA"))
            createAirline.setName(data.get("Name"));
        if (!data.get("Country").equals("NO_DATA"))
            createAirline.setCountry(data.get("Country"));
        if (!data.get("Logo").equals("NO_DATA"))
            createAirline.setLogo(data.get("Logo"));
        if (!data.get("Slogan").equals("NO_DATA"))
            createAirline.setSlogan(data.get("Slogan"));
        if (!data.get("HeadQuarter").equals("NO_DATA"))
            createAirline.setHead_quaters(data.get("HeadQuarter"));
        if (!data.get("Website").equals("NO_DATA"))
            createAirline.setWebsite(data.get("Website"));
        if (!data.get("Established").equals("NO_DATA"))
            createAirline.setEstablished(data.get("Established"));
        return createAirline;


    }
}
