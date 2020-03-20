package com.accesshq.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPage extends BasePage {

	public FormsPage(WebDriver driver) {
		super(driver);
	}

	public void clickSubmitButton() throws Exception {

		List<WebElement> buttons = driver.findElements(By.tagName("button"));

		for (WebElement button : buttons) {
			if (button.getText().equals("SUBMIT")) {
				button.click();
				return;
			}
		}

		throw new Exception("Could not find the 'SUBMIT' button");
	}

	public String getNameErrorMessage() {

		try {
			return driver.findElement(By.id("name-err")).getText();
		} catch (NoSuchElementException e) {
			// If the element is removed, return an empty string
			return "";
		}

	}

	public String getEmailErrorMessage() {

		try {
			return driver.findElement(By.id("email-err")).getText();
		} catch (NoSuchElementException e) {
			// If the element is removed, return an empty string
			return "";
		}
		
	}

	public String getAgreeErrorMessage() {
		
		try {
			return driver.findElement(By.id("agree-err")).getText();
		} catch (NoSuchElementException e) {
			// If the element is removed, return an empty string
			return "";
		}
		
	}

	public void setName(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
	}

	public void setEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}

	public void clickAgree() {
		driver.findElement(By.cssSelector("[for='agree']")).click();
	}

	public String getPopupMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("popup-message")));
		
		return driver.findElement(By.className("popup-message")).getText();
	}
}
