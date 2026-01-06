package BaseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import PageClasses.HomePage;
import Utilities.ExtentReportManager;

public class BasePageClass {
	public static WebDriver driver;
    public ExtentReports report = ExtentReportManager.getReportInstance(); // Use manager
    public ExtentTest logger;

    public void invokeBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Edge")) {
            	System.setProperty("webdriver.edge.driver",
            	        System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
            	System.setProperty("webdriver.chrome.driver",
            	        System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Browser initialization failed: " + e.getMessage());
        }
    }

    public HomePage OpenApplication() {
        driver.get("https://www.nykaa.com/");
        return PageFactory.initElements(driver, HomePage.class);
    }
}