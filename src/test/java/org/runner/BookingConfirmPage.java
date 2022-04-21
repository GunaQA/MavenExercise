package org.runner;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.pom.example.BaseClass;

public class BookingConfirmPage extends BaseClass {
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
	@AfterClass
	public static void closingBrowser() {
		closingAllWindow();
	}
	@Test
	public void detailsEntering() throws IOException {
		for (int i = 0; i <1 ; i++) {	
			for (int j = 8; j < 13; j++) {
				findByID(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i))
				.sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i+1));
			}}
		for (int i = 0; i <1 ; i++) {
			for (int j = 13; j < 16; j++) {
				dropDownbyText(findByID(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)),excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
								"BookingPage",j,i+1));
			}}
		screenShot("Booking Confirmation");
		findByID("book_now").click();
		System.out.println(attributeSent(findByID("order_no")));
		jSScrollDown(findByXpath("//td[contains(text(),'Order')]"));
		screenShot("Order Confirmation");
	}	

}
