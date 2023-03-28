package com.gemini.generic.utils;

public interface GemJarConstants {

    ////////////////////GEMJAR PROJECT DATA//////////////////////

    /**
     * Constant <code>GEMJAR_CONFIG_JSON="GEMJAR_CONFIG_JSON"</code>.
     */
    String GEMJAR_CONFIG_JSON = "gemjar-config.json";

    /**
     * Constant <code> PROJECTNAME = "projectName"</code>
     */
    String PROJECT_NAME = "project_name";

    /**
     * Constant <code> ENVIRONMENT = "environment"</code>
     */
    String ENVIRONMENT = "environment";


    /**
     * Constant <code> REPORT_NAME = "report_name"</code>
     */
    String REPORT_NAME = "report_name";

    /**
     * Constant <code> REPORT_LOCATION = "reportLocation"</code>
     */
    String REPORT_LOCATION = "report_location";

    String LOCAL_REPORT = "localReport";


    String GEMJAR_USER_NAME = "jewel_user";
    String GEMJAR_REPORTING_TOKEN = "jewel_bridge_token";
    String GEMJAR_SUBSCRIPTION_ID = "s_id";
    String GEM_REPORT_TEMPLATE = "GemjarReport.html";

    String REPORT_FILE_DATE_FORMAT = "dd-MMM-yyyy";

    String REPORT_FILE_TIME_FORMAT = "HH-mm-ss";

    String EXPECTED_TESTCASES = "expected_testcases";


    /////////////////////Testng Constants//////////////////////

    /**
     * Constant TESTCASE_FILE_NAME = "testCaseFileName"
     */
    String TESTCASE_FILE_NAME = "testCaseFileName";

    String TESTCASES_TO_RUN = "testCasesToRun";

    String DEFAULT_TESTCASE_JSONFILE_NAME = "testcase.json";

    String TESTCASE_DATAJSON_PATH = "testCaseDataJsonPath";

    String TESTCASE_JSON_INPUT_TAG = "inputData";

    //////////////////////// Cucumber Constants /////////////////////

    String GLUE_CODE = "glueCode";

    String CUCUMBER_TAGS_NAME = "tags";
    String Scenario = "scenario";
    String FEATURE_FILE_PATH = "feature";

    String SAMPLE_JSON_EXTENSION = "_samplejson";
    ////////////////////////Cucumber Property Keys ////////////

    String CUCUMBER_GLUE = "cucumber.glue";

    String CUCUMBER_FEATURE = "cucumber.features";

    String CUCUMBER_TAGS = "cucumber.filter.tags";

    String CUCUMBER_SCENARIO_NAME = "cucumber.filter.name";
    /////////////////////////////SELENIUM CONSTANTS///////////////

    String REMOTE_WEBDRIVER_URL = "remoteDriverUrl";
    String DEFAULT_REMOTE_WEBDRIVER_URL = "https://selenium-hub.geminisolutions.com/wd/hub";

    /**
     * Constant <code>LAUNCH_URL = launchUrl</code>
     */
    String LAUNCH_URL = "launchUrl";

    /**
     * Constant <code>BROWSER_TIMEOUT = browserTimeout</code>
     */
    String BROWSER_TIMEOUT = "browserTimeout";

    /**
     * Constant <code>BROWSER_NAME = browserName</code>
     */

    String BROWSER_NAME = "browserName";

    ///////////////////API Constants/////////////////////////////

    String BASE_URL = "base_url";

    String GET = "GET";
    /**
     * Constant <code>PUT="PUT"</code>.
     */
    String PUT = "PUT";

    String ACCEPT = "accept";

    /**
     * Constant <code>DELETE="DELETE"</code>.
     */
    String DELETE = "DELETE";

    /**
     * Constant <code>POST="POST"</code>.
     */
    String POST = "POST";

    /**
     * Constant <code>PATCH="PATCH"</code>.
     */
    String PATCH = "PATCH";

    int readTimeOut = 100000;
    //////////////////////////////Reporting URL////////////////

    String JEWEL_ENTRY_URL = "enter_point";

    String ChromeOptions = "chromeOptions";

    String S_RUN_ID = "s_run_id";

    String STEP_NAME = "step name";
    String STEP_DESCRIPTION = "step description";

    String IMPLICIT_TIMEOUT = "implicitTimeout";
    String SCRIPT_TIMEOUT = "scriptTimeout";
    String PAGE_TIMEOUT = "pageTimeout";

    ///////////////////////////////////////////LAMBDA Constants///////////////////

    String FEATURE_JSON = "feature_json";
    String LAMBDA_FOLDER_LOCATION = "/tmp";

    String JEWEL_REPORT_EMAIL_FLAG = "email_report";
    String JEWEL_REPORT_EMAIL_TO = "email_to";
    String JEWEL_REPORT_EMAIL_CC = "email_cc";

    String JEWEL_REPORT_EMAIL_BCC = "email_bcc";


    /////////////////////////////////JIRA////////////////////////////////////////

    String JIRA_EMAIL="jira_email";

    String JIRA_ACCESS_TOKEN="jira_access_token";

    String JIRA_TITLE="jira_title";

    String JIRA_PROJECT_ID="jira_project_id";

    String JIRA_WORKFLOW="jira_workflow";


}
