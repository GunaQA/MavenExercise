package org.pom.example;

public class AuthExample extends BaseClass{
	
	public static void main(String[] args) {
		
		BaseClass b=new BaseClass();
		BaseClass.browserConfigChrome();
		b.authentication("admin", "admin", "https://the-internet.herokuapp.com/basic_auth");
	}

}
