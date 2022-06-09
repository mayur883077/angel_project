package pomClasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasess.utilClass;

public class FundsPage extends utilClass {
	WebDriver driver;
	@FindBy(xpath="//a[@id='Addfunds-tabs']")
	WebElement  addfund;
	@FindBy(xpath="//input[@id='txtAmount']")
	WebElement  amount;	
	@FindBy(xpath="//input[@id='rdbNetBanking']")
	WebElement  netbanking;	
	@FindBy(xpath="//button[@id='btnFundTransfer']")
	WebElement  addFundButton;	
	
	public FundsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public boolean OnFundPage() {
		try {
			explicitwait(driver, addfund);
			return true;	
		}catch(Exception e) {
			return false;
		}
	}
	public void enterAmount() {
		explicitwait(driver, amount).sendKeys("50");	
	}
	public void SelectPaymentmode() {
		//netbanking.click();
		addFundButton.click();
		
	}
	
	

}
