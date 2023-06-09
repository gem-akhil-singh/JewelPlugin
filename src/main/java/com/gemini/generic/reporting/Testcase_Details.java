package com.gemini.generic.reporting;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.*;

class Testcase_Details {
    private String base_user;
    private String invoke_user;
    private String tc_run_id;
    private long start_time;
    private long end_time;
    private String run_type;
    private String run_mode;
    private String name;
    private String category;
    private String log_file;
    private String status;
    private String user;
    private String machine;
    private String result_file;
    private boolean ignore;
    private final Map<String, String> meta_data = new HashMap<String, String>();

    public Testcase_Details(String testcaseName, String Category, String User, boolean ignore) {
        this.name = testcaseName;
        this.start_time = GemReportingUtility.getCurrentTimeInMilliSecond();
        this.tc_run_id = testcaseName + "_" + UUID.randomUUID() + "_" + this.start_time;
        this.category = Category;
        this.base_user = User;
        this.invoke_user = User;
        this.machine = GemReportingUtility.getMachineName();
        this.ignore = ignore;
        this.run_mode = System.getProperty("os.name");
        this.run_type = "ON DEMAND";
    }

    @Override
    public String toString() {
        return "testcase_details{" +
                "tc_run_id='" + tc_run_id + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", Name='" + name + '\'' +
                ", Category='" + category + '\'' +
                ", log_file='" + log_file + '\'' +
                ", status='" + status + '\'' +
                ", base_user='" + base_user + '\'' +
                ", invoke_user='" + invoke_user + '\'' +
                ", Machine='" + machine + '\'' +
                ", result_file='" + result_file + '\'' +
                ", ignore=" + ignore
                ;

    }

    public Testcase_Details(String testcaseName, String Category, String User, String productType) {
        this(testcaseName, Category, User, false);
    }

    public Testcase_Details(String testcaseName, String Category, boolean ignore) {
        this(testcaseName, Category, GemReportingUtility.getCurrentUserName(), false);
    }

    public Testcase_Details(String testcaseName, String Category) {
        this(testcaseName, Category, GemReportingUtility.getCurrentUserName(), false);
    }

    public void endTestCase() {
        this.end_time = GemReportingUtility.getCurrentTimeInMilliSecond();

    }

    public String getInvoke_user() {
        return invoke_user;
    }

    public void setInvoke_user(String invoke_user) {
        this.invoke_user = invoke_user;
    }

    public void setBase_user(String base_user) {
        this.base_user = base_user;
    }

    public String getBase_user() {
        return base_user;
    }

    public String getTc_run_id() {
        return tc_run_id;
    }

    public long getStart_time() {
        return start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;

    }

    public String getLog_file() {
        return log_file;
    }

    public String getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }

    public String getMachine() {
        return machine;
    }

    public String getResult_file() {
        return result_file;
    }

    public boolean getIgnore() {
        return ignore;
    }

    // Setter Methods
    public void setTc_run_id(String tc_run_id) {
        this.tc_run_id = tc_run_id;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setCategory(String Category) {
        this.category = Category;

    }

    public void setLog_file(String log_file) {
        this.log_file = log_file;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(JsonArray testCaseSteps) {
        Set<String> statusSet = new HashSet<String>();

        for (JsonElement testCaseStep : testCaseSteps) {
            String status = testCaseStep.getAsJsonObject().get("status").getAsString().toUpperCase();
            statusSet.add(status);
        }

        if(statusSet.contains("ERR")){
            this.status = "ERR";
        } else if (statusSet.size() == 0 || statusSet.contains("FAIL")) {
            this.status = "FAIL";
        } else if (statusSet.contains("WARN")) {
            this.status = "WARN";
        } else if (statusSet.contains("PASS")) {
            this.status = "PASS";
        } else if (statusSet.contains("INFO")) {
            this.status = "INFO";
        } else if (statusSet.contains("EXE")) {
            this.status = "EXE";
        } else {
            this.status = "PASS";
        }

    }

    public String getRun_type() {
        return run_type;
    }

    public String getRun_mode() {
        return run_mode;
    }

    public void setRun_type(String run_type) {
        this.run_type = run_type;
    }

    public void setRun_mode(String run_mode) {
        this.run_mode = run_mode;
    }

    public void setUser(String User) {
        this.user = User;
    }

    public void setMachine(String Machine) {
        this.machine = Machine;

    }

    public void setResult_file(String result_file) {
        this.result_file = result_file;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public void addMetaData(String key, String value) {
        meta_data.put(key, value);
    }
}
