package utils;

public class UserInput {
    public static String stagingUrl = "https://www.paysera.bg/v2/en-LT/fees/currency-conversion-calculator";
    public static String productionUrl = "https://www.paysera.bg/v2/en-LT/fees/currency-conversion-calculator";
    public static String excelPath = System.getProperty("user.dir") +"\\excel_file\\Input.xlsx";
    public static String resultFolderPath = System.getProperty("user.dir") +"\\extent_report\\";
    public static String allureReportDestination = System.getProperty("user.dir") +"\\allure_report\\";
    public static String allureReportSource = System.getProperty("user.dir") +"\\allure-results\\";
    public static String autVersion = "v1.0.0";
}
