package com.cbt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.utilities.Driver;

public class ExercisesPageDamira {


	public ExercisesPageDamira() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath="(//div[@class='ember-view']//a[@class='ember-view'])[2]")
	public WebElement exerciseBtn;
	@FindBy(xpath="(//a[@class='add_exercise'])[1]")
	public WebElement addExerciseBtn;
	@FindBy(xpath="//h2[.='Add Exercise']")
	public WebElement secondAddExercise;
	@FindBy(xpath="//h3[.='Search our exercise database by name:']")
	public WebElement verifyingBtn;
	@FindBy(xpath=" //p[@class='fields']//input[@id='search']")
	public WebElement searchField;
	@FindBy(xpath="(//a[@class='search'])[3]")
	public WebElement matchingResult12;
	@FindBy(xpath="//p[@class='exercise-description']")
	public WebElement anotherVerification;
	@FindBy(xpath="//input[@id='exercise_entry_quantity']")
	public WebElement howLongInput;
	@FindBy(xpath="//input[@id='exercise_entry_calories']")
	public WebElement caloriesBurned;
	@FindBy(xpath="//input[@id='update_exercise']")
	public WebElement thirdAddExercise;
}
