package PageClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
	String parentWindow;

	 WebDriver driver;
	    WebDriverWait wait;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	    }
	    
	    
	    //---------------------------- LOCATORS -------------------------------------------//
	    
	    @FindBy(xpath = "//input[@placeholder='Search on Nykaa']")
	    public WebElement searchInput;
	    
	    @FindBy(xpath = "//span[text()='Brand']")
	    public WebElement brandCategoryDropdown;
	    
	    @FindBy(xpath = "//span[text()='BLUR']")
	    public WebElement blurOption;
	    
	    @FindBy(xpath = "//span[text()='Huda Beauty']")
	    public WebElement hudaBeautyOption;
	    
	    @FindBy(xpath = "//span[text()='Price']")
	    public WebElement priceCategoryDropdown;

	
	    @FindBy(xpath = "//span[text()='Rs. 500 - Rs. 999']")
	    public WebElement priceRangeOption;
	    
	    @FindBy(xpath = "//span[text()='Discount']")
	    public WebElement discountCategoryDropdown;

	    @FindBy(xpath = "//span[text()='All discounted products']")
	    public WebElement discountRangeOption;
	    
	    @FindBy(xpath = "//span[text()='Color']")
	    public WebElement colorCategoryDropdown;

	    @FindBy(xpath = "//span[text()='Brown']")
	    public WebElement brownColorOption;
	    
	    @FindBy(xpath = "//div[@class ='product-listing']//div[@id='product-list-wrap']//div[contains(@class,'productWrapper')]//div[2]//div[text()='BLUR INDIA Call Me Daddy Nude Matte Liquid Lipstick - Nude B...']")
	    public WebElement firstLipstickProduct;
	    
	    @FindBy(xpath = "//button[@type='button']//div[@class='lazy-load-wrap']//span//img[@alt='Cherry Red-shade']")
	    public WebElement cherryRedShade;
	    
	    @FindBy(xpath = "//h1[contains(text(),'BLUR INDIA')]")
	    public WebElement productName;

	    @FindBy(xpath = "//div[contains(text(),'4.')]")
	    public WebElement productRating;

	    @FindBy(xpath = "(//span[contains(text(),'₹')])[last()]")
	    public WebElement productPrice;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   // ---------------------------- METHODS -------------------------------------------//
	    public void searchProduct(String productName) {
	        wait.until(ExpectedConditions.visibilityOf(searchInput));
	        searchInput.clear(); 
	        searchInput.sendKeys(productName);
	        searchInput.sendKeys(Keys.ENTER);
	        
	    }
	    public void clickBrandDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(brandCategoryDropdown)).click();
	    }
	    public void selectBlurBrand() {
	        wait.until(ExpectedConditions.elementToBeClickable(blurOption)).click();  
	        
	    }
	   
	    public void selectHudaBeautyBrand() {
	        wait.until(ExpectedConditions.elementToBeClickable(hudaBeautyOption)).click();  
	       
	    }
	    
	   
	    public void closeBrandDropdown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", brandCategoryDropdown);
	    }
	    
	    public void clickPriceDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(priceCategoryDropdown)).click();
	    }

	    public void selectPriceRange() {
	        wait.until(ExpectedConditions.elementToBeClickable(priceRangeOption)).click();
	    }
	    
	    
	    public void closePriceDropdown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", priceCategoryDropdown);
	    }
	    
	    public void clickDiscountDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(discountCategoryDropdown)).click();
	    }

	  
	    public void selectDiscountRange() {
	        wait.until(ExpectedConditions.elementToBeClickable(discountRangeOption)).click();
	    }


	    public void closeDiscountDropdown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", discountCategoryDropdown);
	    }
	    
	    public void clickColorDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(colorCategoryDropdown)).click();
	    }

	    
	    public void selectBrownColor() {
	        wait.until(ExpectedConditions.elementToBeClickable(brownColorOption)).click();
	    }

	    
	    public void closeColorDropdown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", colorCategoryDropdown);
	    }
	    public void clickFirstLipstickProduct() {
	        wait.until(ExpectedConditions.elementToBeClickable(firstLipstickProduct)).click();
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
	    
	    public void scrollDown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	        js.executeScript("window.scrollBy(0,300)", "");
	    }
	    public void selectCherryRedShade() {
	        wait.until(ExpectedConditions.elementToBeClickable(cherryRedShade)).click();
	    }
	    
	    public void displayFirstProductInfo() {

	        wait.until(ExpectedConditions.visibilityOf(productName));

	        String name = productName.getText();
	        String rating = productRating.getText();
	        String price = productPrice.getText();

	        System.out.println("----- FIRST PRODUCT DETAILS -----");
	        System.out.println("Product Name  : " + name);
	        System.out.println("Product Rating: " + rating);
	        System.out.println("Product Price : " + price);
	    }
	    
	    public void closeChildWindowAndReturn() {

	        driver.close(); 
	        driver.switchTo().window(parentWindow);
	    }
	    public SkinPage scrollToTop() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0,0)");
	        return PageFactory.initElements(driver, SkinPage.class);
	    }
	    
}
