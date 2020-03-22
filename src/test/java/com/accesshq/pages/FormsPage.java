package com.accesshq.pages;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPage extends BasePage {

	public FormsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void clickSubmitButton() throws Exception {

		List<WebElement> buttons = this.driver.findElements(By.tagName("button"));

		for (WebElement button : buttons) {
			if (button.getText().equals("SUBMIT")) {
				button.click();
				return;
			}
		}

		throw new Exception("Could not find the 'SUBMIT' button");
	}

	public String getNameErrorMessage() {
		return getErrorMessageHelper("name");
	}

	public String getEmailErrorMessage() {
		return getErrorMessageHelper("email");
	}

	public String getAgreeErrorMessage() {
		return getErrorMessageHelper("agree");
	}

	public void setName(String name) {
		this.driver.findElement(By.id("name")).sendKeys(name);
	}

	public void setEmail(String email) {
		this.driver.findElement(By.id("email")).sendKeys(email);
	}

	public void clickAgree() {
		this.driver.findElement(By.cssSelector("[for='agree']")).click();
	}

	public String getPopupMessage() {
		this.wait.until(ExpectedConditions.textMatches(
				By.className("popup-message"),
				// Matches non-empty string
				Pattern.compile(".{1,}")));
		
		return driver.findElement(By.className("popup-message")).getText();
	}

	private String getErrorMessageHelper(String idPrefix) {

		List<WebElement> nameErrMessage = this.driver.findElements(By.id(idPrefix + "-err"));

		if (nameErrMessage.size() > 0) {
			return nameErrMessage.get(0).getText();
		} else {
			return "";
		}
	}

}
