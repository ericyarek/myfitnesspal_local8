package com.cbt.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cbt.pages.ExercisesPageDamira;
import com.cbt.pages.HomePage;
import com.cbt.pages.LogOutDamira;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public class ExercisesTestDamira extends TestBase {
	HomePage home = new HomePage();
	ExercisesPageDamira exercise = new ExercisesPageDamira();
	LogOutDamira logOut=new LogOutDamira();

        //SPA-419 MATHCING EXERCISE TEST
//	@Test(priority = 1)
	public void exercisesPageTest() throws InterruptedException {
		home.logIn();
        //TestStep 1
		exercise.exerciseBtn.click();
		Assert.assertTrue(Driver.getDriver().getTitle().contains("Exercise Diary"));
		//TestStep2
		exercise.addExerciseBtn.click();
		assertTrue(exercise.secondAddExercise.getText().contains("Add Exercise"));
		String actual = "Search our exercise database by name:";
		String expected = exercise.verifyingBtn.getText();
		assertEquals(actual, expected, " verifying 2nd test step ");

		exercise.searchField.sendKeys(ConfigurationReader.getProperty("searchTermin") + Keys.ENTER);
         //TestStep3
		exercise.matchingResult12.click();
		Thread.sleep(3000);
		assertTrue(exercise.anotherVerification.isDisplayed());
		assertTrue(exercise.anotherVerification.getText().equals("Running (jogging), 5 mph (12 min mile)"));
       //TestStep4 
		Random rand = new Random();
		int runlong = rand.nextInt(60);
		String run = runlong + "";
		int calories = (int) (runlong * 12.1);
		exercise.howLongInput.sendKeys(run);
		BrowserUtils.waitForVisibility(exercise.caloriesBurned, 2);
	
		System.out.println(calories + "" + Integer.parseInt(exercise.caloriesBurned.getAttribute("value")));
		assertTrue(calories >= Integer.parseInt(exercise.caloriesBurned.getAttribute("value")));
	    //TestStep5
		exercise.thirdAddExercise.click();
		assertTrue(exercise.cardioBtn.isDisplayed());
		assertEquals(exercise.exerciseDescription.getText().trim(), "Running (jogging), 5 mph (12 min mile)");


	}
	//SPA-405 LOG OUT FUNCTIONALITY TEST
	@Test(priority=2)
	public void logOutTest() {
		home.logIn();
		logOut.logOutBtn.click();
		assertTrue(logOut.memberLogInWindow.isDisplayed());
		
	}
}
