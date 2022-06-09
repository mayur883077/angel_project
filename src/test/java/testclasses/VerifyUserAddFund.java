package testclasses;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasess.BaseClass1;
import listenerClasess.listenerClass;
import pomClasess.FundsPage;
import pomClasess.HomePage;
import pomClasess.LoginPage;
import pomClasess.PaymentPage;

@Listeners(listenerClass.class)
public class VerifyUserAddFund {
	WebDriver  driver;
	LoginPage lp;
	HomePage hp;
	FundsPage fp;
	PaymentPage pp;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void BeforeClass() {
		htmlReporter = new ExtentHtmlReporter("VerifyUserAddFunds.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("VerifyUserAddFund");
		
		driver = BaseClass1.getDriver("edge")  ;
		}
	
	@BeforeMethod
	public void BeforeMethod() {
		lp= new LoginPage(driver);
		hp =new HomePage(driver);
		fp = new FundsPage(driver);
		pp = new PaymentPage(driver);
		
	}
    

	@Test(priority =1)
	public void verifyUserLogin() throws EncryptedDocumentException, IOException {
		lp.ClickOnnlogin();
		lp.enterId();
		lp.enterPassword();
		lp.clickSignIn();
		Assert.assertTrue(hp.visiableUserId());	
	}
	
	@Test(priority =2)
	
	public  void verifyUserMoveToFundPage() {
		hp.clickOnFund();
		Assert.assertTrue(fp.OnFundPage());	
	}
	@Test(priority =3)
	public void verifyAddAmountAndMoveToBankingPage() {
		fp.enterAmount();
		fp.SelectPaymentmode();
	}
	@Test(priority =4)
	public void verifyUserOnPaymentPage() {
		pp.switchToPaymentPage();
		
		pp.enterCredential();
		Assert.assertTrue(pp.visiblePaymentPage());	

	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+"test passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String path = pp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else {
			test.log(Status.SKIP, result.getName()+"test skipped");
		}
		
	}
	
	@AfterClass
	public void AfterClass() {
		report.flush();
		driver.quit();
	}
	
}
