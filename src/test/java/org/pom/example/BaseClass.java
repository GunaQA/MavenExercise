package org.pom.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		static WebDriver driver;
	
	public static void browserConfigChrome() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	
	public static void browserConfigFirefox() {
		WebDriverManager.firefoxdriver();
		driver =new FirefoxDriver();
	}
	
	public static void browserConfigEdge() {
		WebDriverManager.edgedriver();
		driver =new EdgeDriver();
	}
	
	public static void browserConfigInternetExplorer() {
		WebDriverManager.iedriver();
		driver =new InternetExplorerDriver();
	}
	
	public static void browserConfigSafari() {
		WebDriverManager.safaridriver();
		driver = new SafariDriver();
	}
	
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static void closingWindow() {
		driver.close();
	}
	
	public static void closingAllWindow() {
		driver.quit();
	}
	
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public String title() {
		String title = driver.getTitle();
		return title;
	}
	
	public WebElement findByID(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	
	public WebElement findByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}
	
	public WebElement findByClassName(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;
	}
	
	public WebElement findByXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}
	
	public WebElement findByTagName(String tag) {
		WebElement findElement = driver.findElement(By.tagName(tag));
		return findElement;
	}
	
	public static WebElement findByLinkText(String linktxt) {
		WebElement findElement = driver.findElement(By.linkText(linktxt));
		return findElement;
	}	
	
	public WebElement findByPartLinkText(String partlinktxt) {
		WebElement findElement = driver.findElement(By.partialLinkText(partlinktxt));
		return findElement;
	}
	
	public WebElement findBycssSelector(String cssSelect) {
		WebElement findElement = driver.findElement(By.cssSelector(cssSelect));
		return findElement;
	}
	
	public void navigateURL(String url) {
		driver.navigate().to(url);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void minimizeWindow() {
		driver.manage().window().minimize();
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void sendingTxt(WebElement findElement,String value) {
		findElement.sendKeys(value);
	}

	public void sendAndSearch(WebElement findElement,String value) {
		findElement.sendKeys(value,Keys.ENTER);
	}
	
	public String gettingText(WebElement findElement) {
		String text = findElement.getText();
		return text;
	}
	
	public String attributeSent(WebElement findElement) {
		String text = findElement.getAttribute("value");
		return text;
	}
	
	public String elementStatus(WebElement findElement) {
		boolean enabled = findElement.isEnabled();
		String status;
		if (enabled==true) {
			status="Enabled";
		}else {
			status="Disabled";
		}
		return status;
	}
	//Wait methods
	public void staticWait(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	public static void impWait(long timeInSec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
	}
	
	public void expWait(int timeInSec, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//interactions Class Methods
	
	public void mouseOver(WebElement findElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement).perform();
	}
	
	public void mouseClick(WebElement findElement) {
		Actions actions = new Actions(driver);
		actions.click(findElement).perform();
	}
	
	public void rightClick(WebElement findElement) {
		Actions actions = new Actions(driver);
		actions.contextClick(findElement).perform();
	}
	
	public void doubleClicking(WebElement findElement) {
		Actions actions = new Actions(driver);
		actions.doubleClick(findElement).perform();
	}
	
	public void dragDropAction(WebElement sourceElement,WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	//Robot Class
	
/*	public void pressingKey(KeyEvent keycode) throws AWTException {
		robot=new Robot();
		robot.keyPress(KeyEvent.keycode);
	}*/
	
	
	//Alert
	
	public void acceptingAlert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissingAlert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void sendKeyinAlert(String keysToSend) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.accept();
	}

	public String gettingAlert() {
		Alert alert=driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}
	
	//Select Class
	
	public void dropDownbyText(WebElement findElement, String text) {
		Select select =new Select(findElement);
		select.selectByVisibleText(text);
	}
	
	public void dropDownbyValue(WebElement findElement, String value) {
		Select select =new Select(findElement);
		select.selectByValue(value);
	}
	
	public void dropDownbyIndex(WebElement findElement, int index) {
		Select select =new Select(findElement);
		select.selectByIndex(index);
	}
	
	public List<WebElement> dropDownSelectAll(WebElement findElement) {
		Select select =new Select(findElement);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	public List<WebElement> dropDownAllSelected(WebElement findElement) {
		Select select =new Select(findElement);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}
	
	public WebElement dropDownFirstSelected(WebElement findElement) {
		Select select =new Select(findElement);
		WebElement option = select.getFirstSelectedOption();
		return option;
	}
	
	public String checkAsMultiple(WebElement findElement) {
		Select select =new Select(findElement);
		boolean multiple = select.isMultiple();
		String status;
		if (multiple==true) {
			status="Multiple";
		}else {
			status="NotMultiple";
		}
		return status;
	}
	
	public void dropDownDeSelectbyVText(WebElement findElement, String text) {
		Select select =new Select(findElement);
		select.deselectByVisibleText(text);
	}
	
	public void dropDownDeSelectbyValue(WebElement findElement, String value) {
		Select select =new Select(findElement);
		select.deselectByValue(value);
	}
	
	public void dropDownDeSelectbyIndex(WebElement findElement, int index) {
		Select select =new Select(findElement);
		select.deselectByIndex(index);
	}
	
	public void dropDownDeSelectAll(WebElement findElement) {
		Select select =new Select(findElement);
		select.deselectAll();
	}
	
	//Frames
	
	public void switchFramebyID(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void switchFramebyElementRef(WebElement findElement) {
		driver.switchTo().frame(findElement);
	}
	
	public void switchFramebyIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void frameToDriver() {
		driver.switchTo().defaultContent();
	}
	
	public void childWindowSwitching() {
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String allHandles : windowHandles) {
			
		if (!parentWindow.equals(allHandles)) {
			driver.switchTo().window(allHandles);
		}
	}
	}
	//JavaScriptUsage
	public void jSClick(WebElement findElement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click", findElement);
	}
	
	public void jSSendKey(WebElement findElement,String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','text')", findElement);
	}
	
	public void jSScrollDown(WebElement findElement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", findElement);
	}
	
	public void jSScrollUp(WebElement findElement,String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", findElement);
	}
	//ScreenShot
	public void screenShot(String filename) throws IOException {
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File screenshotAs =screenshot.getScreenshotAs(OutputType.FILE);
		File file =new File("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\target\\ScreenShot\\"+filename+".JPEG");
		FileUtils.copyFile(screenshotAs, file);
	}
	//Authentication
	public void authentication(String userName,String Password,String urlforauth) {
		
		String[] split = urlforauth.split("https://");
		String url ="http://"+userName+":"+Password+"@"+split[1];
		System.out.println(url);
		driver.get(url);
		//return url;
	}
	
	public int excelRowCount(String location, String sheetName) throws IOException {
		File file=new File(location);
		FileInputStream fIn =new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fIn);
		Sheet sheet = workbook.getSheet(sheetName);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		return physicalNumberOfRows;
	}
	
	//Reading Excel
	public String excelReading(String location, String sheetName,int rowInd,int cellInd) throws IOException {
		String cellValue=null;
		
		File file=new File(location);
		FileInputStream fIn =new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fIn);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowInd);
		Cell cell = row.getCell(cellInd);
		if (cell.getCellType()==1) {
			 cellValue = cell.getStringCellValue();
			//System.out.print(stringCellValue+"\t");
		}else if (cell.getCellType()==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				 cellValue = simpleDateFormat.format(dateCellValue);
				//System.out.print(format+"\t");
			}
		 else {
			 double numericCellValue = cell.getNumericCellValue();
			 long l=(long)numericCellValue;
			  cellValue = String.valueOf(l);
			 //System.out.print(valueOf+"\t");
		}
	}
		return cellValue;
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


