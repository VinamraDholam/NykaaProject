package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkinPage {
	String parentWindow;


	 WebDriver driver;
	    WebDriverWait wait;

	    public SkinPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	    
	    
	    //---------------------------- LOCATORS -------------------------------------------//
	    @FindBy(xpath = "//div[@id='category_navigation']//a[text()='skin']")
	    public WebElement skinMenu;
	    
	    @FindBy(xpath = "//a[normalize-space()='Face Wash']")
	    public WebElement faceWashOption;
	    
	    @FindBy(xpath = "//span[text()='Formulation']")
	    public WebElement formulationFilterDropdown;

	    @FindBy(xpath = "//span[text()='Oil-based']")
	    public WebElement oilBasedCheckbox;
	    
	    @FindBy(xpath = "//span[text()='Concern']")
	    public WebElement concernFilterDropdown;

	    @FindBy(xpath = "//span[text()='Pore Care']")
	    public WebElement poreCareCheckbox;
	    
	    @FindBy(xpath = "//span[text()='Skin type']")
	    public WebElement skinTypeFilterDropdown;

	    @FindBy(xpath = "//span[text()='Oily']")
	    public WebElement oilySkinCheckbox;
	    
//	    @FindBy(xpath = "//div[@id='product-list-wrap']//a/div[2]/div[1]")
//	    public List<WebElement> productNames;
//
//	    @FindBy(xpath = "//div[@id='product-list-wrap']//a/div[2]/div[2]/span[last()]")
//	    public List<WebElement> productPrices;
//
//	    @FindBy(xpath = "//div[@id='product-list-wrap']//a/div[2]/div[3]/span[last()]")
//	    public List<WebElement> productRatings;
	    
	    
	    
	    @FindBy(xpath = "//div[@class='css-xrzmfa']")
	    public List<WebElement> productNames;
	    
	    @FindBy(xpath = "//span[@class='css-111z9ua']")
	    public List<WebElement> productPrices;

	    
	    @FindBy(xpath = "//span[@class='css-1qbvrhp']")
	    public List<WebElement> productReviewCounts;

	    @FindBy(xpath = "//span[@class='star-wrap']")
	    public List<WebElement> productStars;


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //---------------------------- METHODS -------------------------------------------//
	    public void hoverOnSkinMenu() {
	        Actions actions = new Actions(driver);
	   
	        wait.until(ExpectedConditions.visibilityOf(skinMenu));
	        actions.moveToElement(skinMenu).build().perform();
	    }
	    public void clickFaceWash() {
	        wait.until(ExpectedConditions.visibilityOf(faceWashOption));
	        wait.until(ExpectedConditions.elementToBeClickable(faceWashOption)).click();
	    }
	    
	    public void switchToNewWindow() {

	        parentWindow = driver.getWindowHandle();

	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(parentWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	    }
	    
	    public void clickFormulationFilter() {
	        wait.until(ExpectedConditions.elementToBeClickable(formulationFilterDropdown)).click();
	    }

	    public void selectOilBasedFormulation() {
	        wait.until(ExpectedConditions.elementToBeClickable(oilBasedCheckbox)).click();
	    }

	    public void closeFormulationFilter() {
	   
	        wait.until(ExpectedConditions.elementToBeClickable(formulationFilterDropdown)).click();
	    }
	    public void clickConcernFilter() {
	        wait.until(ExpectedConditions.elementToBeClickable(concernFilterDropdown)).click();
	    }

	    public void selectPoreCare() {
	        wait.until(ExpectedConditions.elementToBeClickable(poreCareCheckbox)).click();
	    }

	    public void closeConcernFilter() {
	        wait.until(ExpectedConditions.elementToBeClickable(concernFilterDropdown)).click();
	    }
	   
	    
	    public void clickSkinTypeFilter() {
	        wait.until(ExpectedConditions.elementToBeClickable(skinTypeFilterDropdown)).click();
	    }

	    public void selectOilyFilter() {
	        wait.until(ExpectedConditions.elementToBeClickable(oilySkinCheckbox)).click();
	    }
	    public void closeSkinTypeFilter() {
	      
	        wait.until(ExpectedConditions.elementToBeClickable(skinTypeFilterDropdown)).click();
	    }
	    
	    public void printFirstProduct() {

	    	System.out.println("------- FACEWASH PRODUCT DETAILS -------");
	        for (int i = 0; i < 5; i++) {
	        	
	            System.out.println("----- PRODUCT " + (i + 1) + " -----");

	            System.out.println("Name    : " + productNames.get(i).getText());
	            System.out.println("Price   : " + productPrices.get(i).getText());

	            if (i < productReviewCounts.size()) {
	                System.out.println("Reviews : " + productReviewCounts.get(i).getText());
	            } else {
	                System.out.println("Reviews : N/A");
	            }
	        }
	    }

	    
	    public BeautyAdvicePage closeChildWindowAndReturn() {

	        driver.close(); 
	        driver.switchTo().window(parentWindow);
	        return PageFactory.initElements(driver, BeautyAdvicePage.class);
	    }

}

