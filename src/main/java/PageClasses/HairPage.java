package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HairPage {
	
	WebDriver driver;
    WebDriverWait wait;

    public HairPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
    }
    
  //---------------------------- LOCATORS -------------------------------------------//
    @FindBy(xpath = "//div[@id='category_navigation']//a[text()='hair']")
    public WebElement hairMenu;
    
    @FindBy(xpath = "//li[a[text()='hair']]//ul//li//a")
    public List<WebElement> allHairOptions;
    
    
    
    
    
    //---------------------------- METHODS -------------------------------------------//

    public ContactUsPage printAllHairOptions() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(hairMenu));
        actions.moveToElement(hairMenu).build().perform();

        System.out.println("----- ALL HAIR DROPDOWN OPTIONS -----");
        for (WebElement option : allHairOptions) {
            System.out.println(option.getText());
        }
        return PageFactory.initElements(driver, ContactUsPage.class); 
    }
}
