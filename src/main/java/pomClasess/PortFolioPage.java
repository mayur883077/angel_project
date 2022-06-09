package pomClasess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasess.utilClass;

public class PortFolioPage extends utilClass{
	
	WebDriver driver;
	@FindBy(xpath="//a[@id='mnPort']")
	WebElement portfolio;
	@FindBy(xpath="//a[@id='mnPort_EQ']")
	WebElement equity;
	@FindBy(xpath="//a[text()='Equity portfolio']")
	WebElement EquityPortfolio;
	@FindBy(xpath="(//span[@class='value'])[1]")
	WebElement portValue;
	
	
	public PortFolioPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	public void ClickOnPortfolio() {
		portfolio.click();
	}
	public boolean VisiableOfPortfolio() {
		try{
			explicitwait(driver, equity);
			return true;
		}catch(Exception e) {
			return false;	
			}}
	public void ClickOnEquity() {
		equity.click();
		}
	public boolean viciableOfEquity() {
		try {
			explicitwait(driver, EquityPortfolio);
			return true;
	}catch(Exception e) {
		return false;
	}}
		
	public WebElement valueOfPortfolio() {
		
		return portValue;
	}
		
	}

