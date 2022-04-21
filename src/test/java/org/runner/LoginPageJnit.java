package org.runner;

import java.io.IOException;
import java.util.Date;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pom.example.BaseClass;

public class LoginPageJnit extends BaseClass {

	@BeforeClass
	public static void browserConfig() {
		browserConfigChrome();
		impWait(30);
		maximizeWindow();
		getUrl("https://adactinhotelapp.com/");
	}
//	@AfterClass
//	public static void closingBrowser() {
//		closingAllWindow();
//	}
	@Before
	public void testStartTime() {
		Date d1 = new Date();
		System.out.println(d1);
	}
	@After
	public void testEndTime() {
		Date d2 = new Date();
		System.out.println(d2);
	}
	@Test
	public void loginTest() throws IOException {
		findByID("username").sendKeys(
				excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"LogInPage", 0, 1));
		findByID("password").sendKeys(
				excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"LogInPage", 1, 1));
		WebElement findByID = findByID("login");
		findByID.click();
		
		WebElement txtWelcome = findByID("username_show");
		String txtVerify = txtWelcome.getAttribute("value");
		Assert.assertEquals(txtVerify,"Hello gunasuresh!");
	}
}
