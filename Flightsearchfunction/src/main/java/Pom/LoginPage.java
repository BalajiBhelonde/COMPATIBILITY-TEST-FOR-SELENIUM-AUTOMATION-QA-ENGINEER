package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="(//span[@tabindex='-1'])[2]") 
	private WebElement dropdown;
	
	@FindBy (xpath="//a[@ui-sref='SignUp']")
	private WebElement signup;
	
   public LoginPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public boolean Handledropdown() {
	   boolean result = dropdown.isDisplayed();
	  dropdown.click();
	return result;
   }
   
   public void clickonsignup() {
	   signup.click();
   }
	
	

}
