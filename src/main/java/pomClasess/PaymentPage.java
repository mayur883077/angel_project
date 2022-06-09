package pomClasess;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasess.utilClass;

public class PaymentPage extends utilClass {
	
	WebDriver driver;
	@FindBy(xpath ="//b[contains(text(),'Welcome to Central Bank')]")
	WebElement bankText;
	@FindBy(xpath="//input[@id ='uid']")
	private WebElement userID;
	@FindBy(xpath="//input[@type='password']")
	private WebElement Password;
	
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void switchToPaymentPage() {
		List<String> webPage = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(webPage);
		driver.switchTo().window(webPage.get(0));
	}
	public boolean visiblePaymentPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(1);
		try {
			explicitwait(driver, bankText);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	public void enterCredential() {
		
		
		
		
		
		
		
		userID.sendKeys("8253030710");
		Password.sendKeys("Sharda@9922");
	}
	
}
