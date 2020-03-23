package com.accesshq.pages;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.ui.UnorderedList;

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
		return getMessageHelper("popup-message");
	}

	public String getAlertMessage() {
		return getMessageHelper("alert-message");
	}

	public void clickUpDownButton() {
		this.driver.findElement(By.cssSelector("[role='button']")).click();
	}

	public String getUpDownButtonText() {
		this.wait.until(ExpectedConditions.numberOfElementsToBe(By.className("animating"), 0));
		return this.driver.findElement(By.cssSelector("[role='button']")).getText();
	}

	public UnorderedList getUnorderedList() throws Exception {

		List<WebElement> elements = this.driver.findElements(By.className("v-card__text"));

		for (WebElement webElement : elements) {
			if (webElement.getText().contains("Unordered List")) {
				return new UnorderedList(webElement);
			}
		}

		throw new Exception("Could not find Unordered List");
	}

	public void clickLoginButton() {
		clickButtonHelper("loginButton");
	}

	public void clickCancelButton() {
		clickButtonHelper("cancelButton");
	}

	public void clickHomeButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cancelButton"))));
		this.driver.findElement(By.cssSelector("[aria-label='home'][type='button']")).click();
	}

	public void clickLinkButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cancelButton"))));
		this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='link-button']"))).click();
	}

	public void clickUploadButton() throws Exception {
		List<WebElement> elements = driver.findElements(By.cssSelector("[type='button']"));

		for (WebElement webElement : elements) {
			if (webElement.getText().contains("UPLOAD")) {
				this.wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
				return;
			}
		}

		throw new Exception("Could not find upload button");
	}

	private void clickButtonHelper(String idValue) {
		this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(idValue)))).click();
	}

	private String getMessageHelper(String classValue) {
		this.wait.until(ExpectedConditions.textMatches(By.className(classValue), Pattern.compile(".{1,}")));
		return driver.findElement(By.className(classValue)).getText();
	}

}
