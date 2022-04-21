package org.adactin;
import java.io.IOException;

import org.pom.example.BaseClass;
public class AdactinHotelBooking {
	public static void main(String[] args) throws IOException {
		BaseClass b=new BaseClass();
		BaseClass.browserConfigChrome();
		BaseClass.impWait(30);
		BaseClass.maximizeWindow();
		BaseClass.getUrl("https://adactinhotelapp.com/");
		b.refreshPage();
		b.screenShot("Home Page");
		b.findByID("username")
		.sendKeys(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx", "LogInPage",0,1));
		b.findByID("password").sendKeys(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx"
				,"LogInPage",1,1));
		b.screenShot("Enter Credential");
		b.findByID("login").click();
		for (int i = 0; i <1 ; i++) {
			for (int j = 0; j < 6; j++) {
				b.dropDownbyText(b.findByID(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)),b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
								"BookingPage",j,i+1));
			}}
		for (int i = 0; i <1 ; i++) {	
			for (int j =6; j < 8; j++) {
				b.findByID(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)).clear();
				b.findByID(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i))
				.sendKeys(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i+1));
			}}
		b.screenShot("Entering Details");
		b.findByID("Submit").click();
		b.findByID("radiobutton_0").click();
		b.screenShot("Checking Details");
		b.findByID("continue").click();
		for (int i = 0; i <1 ; i++) {	
			for (int j = 8; j < 13; j++) {
				b.findByID(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i))
				.sendKeys(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx","BookingPage",j,i+1));
			}}
		for (int i = 0; i <1 ; i++) {
			for (int j = 13; j < 16; j++) {
				b.dropDownbyText(b.findByID(b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
						"BookingPage",j,i)),b.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
								"BookingPage",j,i+1));
			}}
		b.screenShot("Booking Confirmation");
		b.findByID("book_now").click();
		System.out.println(b.attributeSent(b.findByID("order_no")));
		b.jSScrollDown(b.findByXpath("//td[contains(text(),'Order')]"));
		b.screenShot("Order Confirmation");
		BaseClass.closingAllWindow();
	}
}

