package task.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
//Creating Main method//for git
	public static void main(String[] args) {
//Browser Configure:
		WebDriverManager.chromedriver().setup();
//Launch Browser		
		WebDriver driver=new ChromeDriver();
//Opening URL		
		driver.get("https://google.co.in/");
		driver.manage().window().maximize();
	}

}
