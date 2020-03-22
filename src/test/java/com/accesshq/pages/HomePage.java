package com.accesshq.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void setForename(String name) {
		this.driver.findElement(By.id("forename")).sendKeys(name);
	}

	public void clickSubmitButton() {
		this.driver.findElement(By.id("submit")).click();
	}

	public String getPopupMessage() {
		this.wait.until(ExpectedConditions.textMatches(
				By.className("popup-message"),
				// Matches non-empty string
				Pattern.compile(".{1,}")));

		return this.driver.findElement(By.className("popup-message")).getText();
	}

	public void clickUpDownButton() {
		this.driver.findElement(By.cssSelector("[role='button']")).click();
	}

	public String getUpDownButtonText() {
		/*
		this.wait.until(ExpectedConditions.not(
				ExpectedConditions.attributeToBe(By.cssSelector("[role='button']"), "class", "animating")));
		*/
		
		while (driver.findElements(By.className("animating")).size() > 0) {
			// Intentionally blank
		}

		return this.driver.findElement(By.cssSelector("[role='button']")).getText();
	}

}
