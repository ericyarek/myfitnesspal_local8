package com.cbt.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.cbt.pages.ExercisesPageDamira;
import com.cbt.pages.HomePage;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class ExercisesTestDamira extends TestBase {

	public void login() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		HomePage home = new HomePage();

		home.login.click();
		home.username.sendKeys(ConfigurationReader.getProperty("username"));
		home.password.sendKeys(ConfigurationReader.getProperty("password"));
		home.loginBtn.click();
	}

	@Test(priority = 1)
	public void exercisesPageTest() throws InterruptedException {
		String searchFor = "Running";
		this.login();
	
		ExercisesPageDamira exercise = new ExercisesPageDamira();
	
		exercise.exerciseBtn.click();
		Assert.assertTrue(Driver.getDriver().getTitle().contains("Exercise Diary"));
		exercise.addExerciseBtn.click();
		assertTrue(exercise.secondAddExercise.getText().contains("Add Exercise"));
		String actual = "Search our exercise database by name:";
		String expected = exercise.verifyingBtn.getText();
		assertEquals(actual, expected, " verifying 2nd test step ");
		
		exercise.searchField.sendKeys(searchFor + Keys.ENTER);
		
		exercise.matchingResult12.click();
		Thread.sleep(3000);
		assertTrue(exercise.anotherVerification.isDisplayed());
		assertTrue(exercise.anotherVerification.getText().equals("Running (jogging), 5 mph (12 min mile)"));
		
		Random rand = new Random();
		int runlong = rand.nextInt(60);
		String run = runlong+"";
		int calories = (int)(runlong*12.1);
		exercise.howLongInput.sendKeys(run);
		BrowserUtils.waitForVisibility(exercise.caloriesBurned, 2);
//		System.out.println(exercise.caloriesBurned.);
		System.out.println(calories+""+ Integer.parseInt(exercise.caloriesBurned.getAttribute("value")));
		assertTrue(calories>=Integer.parseInt(exercise.caloriesBurned.getAttribute("value")));
		// exercise.caloriesBurned.getAttribute("value");
		exercise.thirdAddExercise.click();
		
	}
}
