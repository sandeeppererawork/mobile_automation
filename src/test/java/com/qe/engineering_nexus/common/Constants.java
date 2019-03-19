package com.qe.engineering_nexus.common;

public class Constants {

    public static final String TEST_ENV = System.getProperty("test.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("test.release", "Sygma_UI_v1.0");
    public static final String TEST_PROJECT = System.getProperty("test.project", "Sygma");
    public static final boolean RUN_WINDOWS = Boolean.parseBoolean(System.getProperty("run.windows", "false"));

    public static final String APP_URL = System.getProperty("app.url", "http://ms084webqa/routetracker");

    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));
    public static final boolean UPDATE_QMETRY = Boolean.parseBoolean(System.getProperty("update.qmetry", "false"));

    public static final String QMETRY_API_KEY_QE_TEST_SL = System.getProperty("api.key", "0bd9a3fd7d6cac4b60a1c3339de8f9e14b8709a10e401436e754154ddbdd8e53");
    public static final boolean IS_TEST_RUN_PROVIDED = Boolean.parseBoolean(System.getProperty("is.test.run.provided", "true"));
    public static final String TEST_RUN_PROVIDED = System.getProperty("test.run.id", "QTSL-71");
}
