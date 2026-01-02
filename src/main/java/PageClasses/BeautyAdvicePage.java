package PageClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeautyAdvicePage {

	 WebDriver driver;
	    WebDriverWait wait;

	    public BeautyAdvicePage(WebDriver driver) {
	        this.driver = driver;
	       PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	    }
	    
	    
	    //---------------------------- LOCATORS -------------------------------------------//
	    @FindBy(xpath = "//div[@id='headerMenu']//ul[5]//li[@id='beauty_advice']")
	    public WebElement beautyAdviceMenu;

	    @FindBy(xpath = "//section[@class='BeautyAdviceboxWrapper']//div[@class='beautyadviceHeading' and contains(text(),'BUYING')]")
	    public WebElement beautyBuyingGuides;
	    
	    @FindBy(xpath = "//h2[text()='Haircare Heroes']")
	    public WebElement haircareHeroesHeading;

	    
	    @FindBy(xpath = "//a[contains(@href,'haircare-under-599')]")
	    public WebElement haircareHeroFirst;
	    
	    @FindBy(xpath = "//a[text()='3']")
	    public WebElement pageThreeLink;

	    @FindBy(xpath = "//div[@id='product-list-wrap']//a")
	    public WebElement firstProduct;

	    
	    @FindBy(xpath = "//span[text()='Add to Bag']")
	    public WebElement addToBagButton;
	    
	    @FindBy(xpath = "//button[@id='header-bag-icon']")
	    public WebElement headerCartButton;
	    
	 
	    @FindBy(xpath = "//div[@data-test-id='header-back']")
	    public WebElement closeCartButton;

	 
	    @FindBy(xpath = "//a[@title='logo']")
	    public WebElement nykaaLogo;
	   


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //---------------------------- METHODS -------------------------------------------//
	    public void hoverOnBeautyAdvice() {
	        Actions actions = new Actions(driver);
	        wait.until(ExpectedConditions.visibilityOf(beautyAdviceMenu));
	        actions.moveToElement(beautyAdviceMenu).build().perform();
	    }
	    
	    public void clickBeautyBuyingGuides() {
	        wait.until(ExpectedConditions.elementToBeClickable(beautyBuyingGuides)).click();
	    }
	    
	    public void switchToBeautyBuyingGuidesWindow() {

	        String parentWindow = driver.getWindowHandle();

	        for (String window : driver.getWindowHandles()) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	    }
	    
	    public void scrollToHaircareHeroes() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        wait.until(ExpectedConditions.visibilityOf(haircareHeroesHeading));
	        js.executeScript("arguments[0].scrollIntoView(true);", haircareHeroesHeading);
	    }

	    
	    public void clickHaircareHeroFirst() {
	        wait.until(ExpectedConditions.elementToBeClickable(haircareHeroFirst));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", haircareHeroFirst);
	    }
	    
	    public void scrollDownPage() {
	    	wait.until(ExpectedConditions.visibilityOf(pageThreeLink));

	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", pageThreeLink);

	    	pageThreeLink.click();
	    }
	    
  
	    public void clickFirstProduct() {
	       
	        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
	    }

	    public void addToCartAndCloseTab() {
	        String listPage = driver.getWindowHandle();

	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(listPage)) {
	                driver.switchTo().window(handle);
	            }
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton)).click();
	        
	        driver.close();
	        driver.switchTo().window(listPage);
	    }
	    
	    public void openCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(headerCartButton)).click();
	        
	    }
	    
	    public void closeCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(closeCartButton)).click();
	       
	    }
	    
	    public void closeHaircareWindow() {
	        driver.close();
	        
	        
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	            break; 
	        }
	    }
	    
	    public MenPage clickLogoToReturnHome() {
	        
	        wait.until(ExpectedConditions.elementToBeClickable(nykaaLogo));
	        nykaaLogo.click();
	        return PageFactory.initElements(driver, MenPage.class);
	    }




	    
	    
	    
}
