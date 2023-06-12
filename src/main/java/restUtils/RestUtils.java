package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtendReportManager;

import java.util.Map;

public class RestUtils {
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReports(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtendReportManager.logInfoDetails("End Point: " + queryableRequestSpecification.getBaseUri());
        ExtendReportManager.logInfoDetails("Methods: " + queryableRequestSpecification.getMethod());
        ExtendReportManager.logInfoDetails("Headers: ");
        ExtendReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtendReportManager.logInfoDetails("Request Body: ");
        ExtendReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReports(Response response) {
        ExtendReportManager.logInfoDetails("Response Status: " + response.getStatusCode());
        ExtendReportManager.logInfoDetails("Response Headers: ");
        ExtendReportManager.logHeaders(response.getHeaders().asList());
        ExtendReportManager.logInfoDetails("Response Body: ");
        ExtendReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReports(requestSpecification);
        printResponseLogInReports(response);
        return response;

    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReports(requestSpecification);
        printResponseLogInReports(response);
        return response;

    }
}
