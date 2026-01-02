package PageClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	String parentWindow;
	 WebDriver driver;
	    WebDriverWait wait;

	    public ContactUsPage(WebDriver driver) {
	        this.driver = driver;
	       PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait up to 15 sec for popups
	    }
	    
	    
	    
	    //---------------------------- LOCATORS -------------------------------------------//
	    
	
	    @FindBy(xpath = "//footer//a[contains(text(),'Contact')]")
	    public WebElement contactUsLink;
	    
	    @FindBy(xpath = "//button[contains(., 'User')]")
	    public WebElement userIcon;
	    
	    @FindBy(xpath = "//input[@type='tel']")
	    public WebElement mobileNumberInput;

	    @FindBy(xpath = "//button[contains(.,'Get OTP')]")
	    public WebElement getOtpButton;

	    @FindBy(xpath = "//div[contains(text(),'Invalid phone number')]")
	    public WebElement invalidPhoneError;


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //---------------------------- METHODS -------------------------------------------//
	    public void clickContactUs() {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        js.executeScript("arguments[0].click();", contactUsLink);
	    }

	   
	    public void switchToNewWindow() {
	        String parentWindow = driver.getWindowHandle();

	        for (String window : driver.getWindowHandles()) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	    }
	    public void clickUserIcon() {
	        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
	    }

	    public void enterMobileNumber(String mobile) {
	        wait.until(ExpectedConditions.visibilityOf(mobileNumberInput));
	        mobileNumberInput.clear();
	        mobileNumberInput.sendKeys(mobile);
	        
	    }

	    
	    public void clickGetOTP() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", getOtpButton);
	        
	    }

	    
	    public String waitForErrorAndScreenshot() throws IOException {
	        wait.until(ExpectedConditions.visibilityOf(invalidPhoneError));
	        wait.until(ExpectedConditions.textToBePresentInElement(invalidPhoneError, "Invalid phone number"));
	        return takeScreenShot();  
	    }
	    
	    public String takeScreenShot() throws IOException {
	        
	        String filePath = System.getProperty("user.dir") + "\\ScreenShots\\" + generateFile();
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(filePath));
	        return filePath; 
	    }

		public String generateFile() {
			return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";
		}

	}