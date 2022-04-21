package test.testng.works;

import java.io.IOException;

import org.pom.example.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactinTestNGPriority extends BaseClass{
	
	@BeforeClass
	public static void browserConfLaunch()  {
		
		browserConfigChrome();
		getUrl("https://adactinhotelapp.com/");
	}
	@AfterClass
	public static void closingBrowser() {
		findByLinkText("Logout").click();
		closingAllWindow();
	}
	@Test(priority=0)
	public void username() throws IOException {
		findByID("username")
		.sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx", "LogInPage",0,1));

	}	
	@Test(priority=1)
	public void password() throws IOException {
		findByID("password").sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx"
				,"LogInPage",1,1));
	}	
	@Test(priority=2)
	public void login() {
		findByID("login").click();
	}	
	
	

}
