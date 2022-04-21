package org.pom.example;

import java.io.IOException;

public class Login extends LoginPO{
	int[] a= {1,2,3};
	private void arrayExample() {
		System.out.println(a[1]);

	}

	public static void main(String[] args) throws IOException {
		Login l=new Login();
		l.arrayExample();
		
//		browserConfigChrome();
//		maximizeWindow();
//		getUrl("https://adactinhotelapp.com/");
//		impWait(10);
//		LoginPO log=new LoginPO();
//		log.sendingTxt(log.getUserName(),log.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
//				"LogInPage", 0, 1));
//		log.sendingTxt(log.getPassword(), log.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
//				"LogInPage", 1, 1));
//		log.refreshPage();
//		log.sendingTxt(log.getUserName(),log.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
//				"LogInPage", 0, 1));
//		log.sendingTxt(log.getPassword(), log.excelReading("C:\\Users\\Lenovo\\eclipse-workspace\\MavenFirst\\src\\test\\TestDataAdactin.xlsx",
//				"LogInPage", 1, 1));
//		log.mouseClick(log.getLoginBtn());
}
}