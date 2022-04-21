package org.runner;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pom.example.BaseClass;

public class HotelSelectionPage extends BaseClass {

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
	public void detailsEntering() throws IOException {
		for (int i = 0; i <1 ; i++) {
			for (int j = 0; j < 6; j++) {
				dropDownbyText(findByID(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)),excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
								"BookingPage",j,i+1));
			}}
		for (int i = 0; i <1 ; i++) {	
			for (int j =6; j < 8; j++) {
				findByID(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)).clear();
				findByID(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i))
				.sendKeys(excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i+1));
			}}
		screenShot("Entering Details");
		findByID("Submit").click();
		findByID("radiobutton_0").click();
		screenShot("Checking Details");
		findByID("continue").click();
	}	
	

}
