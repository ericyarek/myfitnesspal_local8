package com.cbt.tests.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.cbt.pages.HomePageTarik;
import com.cbt.pages.LoginPageTarik;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class NegativeLoginFunctionalityTarik extends TestBase{

	String username = ConfigurationReader.getProperty("username");
	String password = ConfigurationReader.getProperty("password");

	@Test
	public void invalid_password_testing() {
	HomePageTarik homepage = new HomePageTarik();
	LoginPageTarik loginpage = new LoginPageTarik();
	Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	homepage.signInButton.click();
	homepage.userName.sendKeys(username);
	homepage.password.sendKeys(password);
	homepage.loginbutton.click();
	
	String actual= loginpage.errorMsg.getText();
	System.out.println(actual);
	String expected = "Incorrect username or password";
	
	assertTrue(actual.contains(expected), "you passed valid credentials");
	}

}
