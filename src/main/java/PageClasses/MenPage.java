package PageClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenPage {
	String parentWindow;
	
	 WebDriver driver;
	    WebDriverWait wait;

	    public MenPage(WebDriver driver) {
	        this.driver = driver;
	      PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(25)); 
	    }
	    
	    
	    
	    //---------------------------- LOCATORS -------------------------------------------//
	    @FindBy(xpath = "//li[contains(@class,'MegaDropdownHeadingbox')]/a[text()='men']")
	    private WebElement menMenuLink;


//	    @FindBy(id = "category_navigation")
//	    private WebElement navHeaderAnchor;
	    
	    @FindBy(xpath = "//span[text()='Health & Nutrition']")
	    private WebElement healthAndNutritionIcon;
	    
	    @FindBy(xpath = "//div[@id='filter-sort']//span[text()='Sort By' or @class='sort-name']")
	    private WebElement sortByButton;

	    
	    @FindBy(xpath = "//label[@for='radio_new arrivals_undefined']//span[text()='new arrivals']")
	    private WebElement newArrivalsOption;
	    
//	    @FindBy(xpath = "//div[@id='first-filter']//span[@class='title active' or text()='Brand']")
//	    private WebElement brandButton;
//	    
//	    @FindBy(xpath = "//span[text()='Beautywise']")
//	    private WebElement amocareBrand;
	    
	    @FindBy(xpath = "//div[@id='title']/span")
	    private WebElement wellnessTotalCount;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //---------------------------- METHODS -------------------------------------------//
	    public void clickMenMenuAndSwitch() {

	        parentWindow = driver.getWindowHandle(); // ✅ STORE parent

	        wait.until(ExpectedConditions.elementToBeClickable(menMenuLink));
	        menMenuLink.click();

	        wait.until(driver -> driver.getWindowHandles().size() > 1);

	        for (String win : driver.getWindowHandles()) {
	            if (!win.equals(parentWindow)) {
	                driver.switchTo().window(win);
	                break;
	            }
	        }
	    }


	    public void selectHealthAndNutrition() {

	     
	        wait.until(ExpectedConditions.visibilityOf(healthAndNutritionIcon));

	       // JavascriptExecutor js = (JavascriptExecutor) driver;
	        //js.executeScript("arguments[0].scrollIntoView({block:'center'});", healthAndNutritionIcon);

	        wait.until(ExpectedConditions.elementToBeClickable(healthAndNutritionIcon));
	        healthAndNutritionIcon.click();
	    }

	    
	    public void sortByNewArrivals() {
	        wait.until(ExpectedConditions.elementToBeClickable(sortByButton)).click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(newArrivalsOption)).click();
	        
	    }
	    
//	    public void selectBrandBeautywise() {
//	        wait.until(ExpectedConditions.elementToBeClickable(brandButton)).click();
//	        
//	        wait.until(ExpectedConditions.elementToBeClickable(amocareBrand)).click();  
//	    }
	    
	    public void printTotalCount() {
	        wait.until(ExpectedConditions.visibilityOf(wellnessTotalCount));
	        
	        String count = wellnessTotalCount.getText();
	        System.out.println("Total product count: " + count);
	    }
	    
	    public HairPage closeWellnessWindow() {
	        driver.close(); 
	        driver.switchTo().window(parentWindow); 
	        return PageFactory.initElements(driver, HairPage.class);
	    }
}
