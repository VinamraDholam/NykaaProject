package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseClasses.BasePageClass;
import PageClasses.BeautyAdvicePage;
import PageClasses.ContactUsPage;
import PageClasses.HairPage;
import PageClasses.HomePage;
import PageClasses.MenPage;
import PageClasses.SkinPage;

public class TestData  extends BasePageClass{
	HomePage homePage;
	HairPage hairPage;
	SkinPage skinPage;
	BeautyAdvicePage beautyAdvicePage;
	MenPage menPage;
	ContactUsPage contactUsPage;
   

 
	@BeforeMethod
	public void setup() {
	    invokeBrowser("Chrome");
	    homePage = OpenApplication();

	    hairPage = new HairPage(driver);
	    skinPage = new SkinPage(driver);
	    beautyAdvicePage = new BeautyAdvicePage(driver);
	    menPage = new MenPage(driver);
	    contactUsPage = new ContactUsPage(driver);
	}

	@Test
	public void runCompleteFlow() throws IOException {
	    logger = report.createTest("Nykaa Automation Report");
    

     // --- HOMEPAGE SECTION ---
     logger.log(Status.INFO, "Starting Search Flow on Homepage");
     homePage.searchProduct("Lipstick");
     
     logger.log(Status.INFO, "Applying Brand,Price,Discount,Shades Filters");
     homePage.clickBrandDropdown();
     homePage.selectBlurBrand();
     homePage.selectHudaBeautyBrand();
     homePage.closeBrandDropdown();
     
     homePage.clickPriceDropdown();
     homePage.selectPriceRange();
     homePage.closePriceDropdown();
     
     homePage.clickDiscountDropdown();
     	homePage.selectDiscountRange();
     	homePage.closeDiscountDropdown();
     	homePage.clickColorDropdown();
     	homePage.selectBrownColor();
     	homePage.closeColorDropdown();
     
     logger.log(Status.INFO, "Selecting Shade and Capturing Product Info");
     homePage.clickFirstLipstickProduct();
     homePage.switchToNewWindow();
     //homePage.scrollDown();
     homePage.selectCherryRedShade();
     homePage.displayFirstProductInfo();
     
     
	     homePage.closeChildWindowAndReturn();
	     homePage.scrollToTop();
	     
	     
	    
     
     
     //--------------------------------- SKINPAGE----------------------------//
     logger.log(Status.INFO, "Navigating to Skin Page and Filtering Face Wash");
     skinPage.hoverOnSkinMenu();
     skinPage.clickFaceWash();
     skinPage.switchToNewWindow();
     skinPage.clickFormulationFilter();
     skinPage.selectOilBasedFormulation();
     skinPage.closeFormulationFilter();
     
     skinPage.clickConcernFilter();
     skinPage.selectPoreCare();
     skinPage.closeConcernFilter();
     
     skinPage.clickSkinTypeFilter();
     skinPage.selectOilyFilter();
     skinPage.closeSkinTypeFilter();
     skinPage.printFirstProduct();
     skinPage.closeChildWindowAndReturn();
    
    
    
    
    //----------------------------- BEAUTY ADVICE PAGE ----------------------------//
    
     logger.log(Status.INFO, "Testing Beauty Advice and Cart Functionality");
     beautyAdvicePage.hoverOnBeautyAdvice();
     beautyAdvicePage.clickBeautyBuyingGuides();
     beautyAdvicePage.switchToBeautyBuyingGuidesWindow();
     beautyAdvicePage.scrollToHaircareHeroes();
     beautyAdvicePage.clickHaircareHeroFirst();
     beautyAdvicePage.scrollDownPage();
     beautyAdvicePage.clickFirstProduct();
     beautyAdvicePage.addToCartAndCloseTab();
     beautyAdvicePage.openCart();
     beautyAdvicePage.closeCart();
     beautyAdvicePage.closeHaircareWindow();
     beautyAdvicePage.clickLogoToReturnHome();
     
     
     //-------------------------------------- MenPage --------------------------------//
     logger.log(Status.INFO, "Testing Men's Section Wellness Products");
     menPage.clickMenMenu();
     menPage.switchToMenWindow();
     menPage.selectHealthAndNutrition();
     menPage.sortByNewArrivals();
     menPage.printTotalCount();
     menPage.closeWellnessWindow();

     
  
//menPage.selectBrandBeautywise();
     
     //------------------------------- HAIRPAGE ---------------------------//
	    hairPage.printAllHairOptions();
  
  //------------------------------------------- Contact Us Page -------------------------------//
  
     logger.log(Status.INFO, "Validating Mobile Number Error in Contact Us");
     contactUsPage.clickContactUs();
     contactUsPage.switchToNewWindow();
     contactUsPage.clickUserIcon();
     contactUsPage.enterMobileNumber("123456");
     contactUsPage.clickGetOTP();
     
     // Final Status
     String screenshotPath = contactUsPage.waitForErrorAndScreenshot(); 
     logger.log(Status.FAIL, "Validation error captured successfully",
             MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
 }
 @AfterMethod
 public void flushReport() {
     report.flush();
     driver.quit(); 
 }
     
}


