package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	@FindBy (xpath="//input[@id='name']")
	private WebElement name;
	
	@FindBy (xpath="//input[@id='orgName']")
	private WebElement orgnizationname;
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy (xpath="//span[text()='I agree to the']")
	private WebElement checkbox;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement getstarted;
	
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Entername() {
		name.sendKeys("Balaji Rajendra Bhelonde");
	}
	
	public void Enterorganizationame() {
		orgnizationname.sendKeys("Balaji");
	}
	
	public void Enteremail() {
		email.sendKeys("balajibhelonde1996@gmail.com");
	}
	
	public void clickcheckbox() {
		checkbox.click();
	}
	
	public void getstarted() {
		getstarted.click();
	}
}