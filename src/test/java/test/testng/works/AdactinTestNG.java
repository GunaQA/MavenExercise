package test.testng.works;

import java.io.IOException;

import org.pom.example.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdactinTestNG extends BaseClass{
	
	
	@BeforeClass
	public static void browserConfLaunch()  {
		
		browserConfigChrome();
	}
	@AfterClass
	public static void closingBrowser() {
		closingAllWindow();
	}
	@BeforeMethod
	public void startTime() {
		getUrl("https://adactinhotelapp.com/");
	}
	@AfterMethod
	public void logOut() {
		findByLinkText("Logout").click();
	}
	@Test(invocationCount=1)
	public void loginTestCase() throws IOException {
		findByID("username")
		.sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx", "LogInPage",0,1));
		findByID("password").sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx"
				,"LogInPage",1,1));
		findByID("login").click();
	}
}
