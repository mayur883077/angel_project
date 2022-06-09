package pomClasess;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasess.utilClass;

public class LoginPage extends  utilClass{
	WebDriver driver;
	@FindBy(xpath ="(//a[@class='btn btn-color'])[2]")
	WebElement loginButton;
	@FindBy(xpath ="//input[@type='text']")
	WebElement EmailIdfiled;
	@FindBy(xpath ="//li[@class='tooltip-theme']")
	WebElement EmailId;
	@FindBy(xpath ="//input[@type='password']")
	WebElement passWord;
	@FindBy(xpath ="//a[@id='loginBtn']")
	WebElement signInButton;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	public void ClickOnnlogin() {
		loginButton.click();	
	}
	public void enterId() throws EncryptedDocumentException, IOException {
		EmailIdfiled.click();
		explicitwait(driver, EmailIdfiled).sendKeys("mayursraut97@gmail.com");		
	}
	
	public  void enterPassword() throws EncryptedDocumentException, IOException {
		passWord.sendKeys("Mayur@123");
	}
	public  void  clickSignIn() {
		signInButton.click();
	}
}
