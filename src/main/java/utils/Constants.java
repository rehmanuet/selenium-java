package utils;

public class Constants {

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final Integer TIMEOUT = 10;

    /**
     * Constants for Test Data
     */
    // TODO: 07/11/2021 Data is too short to make it Data Driven, Apache POI library will be integrated once data grows
    public static final String VALID_USERNAME = "standard_user";
    public static final String VALID_PASSWORD = "secret_sauce";
    public static final String INVALID_USERNAME = "non_standard_user";
    public static final String INVALID_PASSWORD = "ultra_secret_sauce";
    public static final String LOGIN_ERROR_MESSAGE = "message.test.login.error";

    /**
     * Constants for Test Listeners
     */
    public static final String ON_START_MESSAGE = "message.test.listener.onstart";
    public static final String ON_FINISH_MESSAGE = "message.test.listener.onfinish";
    public static final String ON_TEST_START_MESSAGE = "message.test.listener.onteststart";
    public static final String ON_TEST_SUCCESS_MESSAGE = "message.test.listener.ontestsuccess";
    public static final String ON_TEST_FAILURE_MESSAGE = "message.test.listener.ontestfailure";
    public static final String ON_TEST_SKIPPED_MESSAGE = "message.test.listener.ontestskipped";

    /**
     * Constants for file paths
     */
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    public static final String MESSAGES_PROPERTIES_PATH = WORKING_DIRECTORY + "/src/test/resources/messages.properties";
    public static final String EXTENT_REPORT_PATH = WORKING_DIRECTORY + "/extentreport/ExtentReportResults.html";

}
