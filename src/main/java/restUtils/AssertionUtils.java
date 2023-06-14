package restUtils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reporting.ExtendReportManager;
import reporting.Setup;

import java.util.*;

public class AssertionUtils {
    public static void assertionExpectedValueFromJsonPath(Response response, Map<String, Object> expectedValuesMap) {
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON_PATH","EXPECTED_VALUE","ACTUAL_VALUE","RESULT"));
        boolean allMatched = true;

        Set<String> jsonPaths = expectedValuesMap.keySet();
        for (String jsonPath : jsonPaths) {
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if (actualValue.isPresent()) {
                Object value = actualValue.get();
                if (value.equals(expectedValuesMap.get(jsonPath))) {
                    actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "MATCHED"));
                } else {
                    allMatched = false;
                    actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "NOT_MATCHED"));
                }
            } else {
                allMatched = false;
                actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), "VALUE_NOTFOUND", "MATCHED"));
            }
        }
        if (allMatched)
            ExtendReportManager.logPassDetails("All Assertions are Passed..");
        else
            ExtendReportManager.logFailDetails("All Assertions are NOT Passed..");


        String[][] arrayHeaders = actualValuesMap.stream().map(assertions -> new String[]{assertions.getJsonPath()
                        , String.valueOf(assertions.getExpectedValues())
                        , String.valueOf(assertions.getActualValue())
                        , assertions.getResult()})
                .toArray(String[][]::new);
        Setup.extentTest.get().pass(MarkupHelper.createTable(arrayHeaders));
    }
}
