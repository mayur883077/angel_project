package pomClasess;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasess.utilClass;

public class HomePage extends utilClass {
	WebDriver driver;
	@FindBy(xpath="//a[text()='M269743 ']")
	WebElement  userId;
	@FindBy(xpath="	//a[@id='mnFunds']")
	WebElement  fundButton;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public boolean visiableUserId() {
		try {
			explicitwait(driver, userId);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickOnFund() {
		fundButton.click();
	}
	
}

