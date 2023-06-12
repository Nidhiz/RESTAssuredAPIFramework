package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String fileName = ExtendReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtendReportManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        ExtendReportManager.logFailDetails(result.getThrowable().getMessage());

        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedTrace = "<details>\n" +
                "<summary> Click here to see Exception</summary>\n" +
                "" + stackTrace + "\n" +
                "</details>\n";

        ExtendReportManager.logExceptionDetails(formattedTrace);
    }
}
