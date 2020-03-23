package com.accesshq.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDialog {

	private WebElement element;
	private WebDriverWait wait;

	public LoginDialog(WebElement element, WebDriverWait wait) {
		this.element = element;
		this.wait = wait;
	}

	public void clickLoginButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.id("loginButton")))).click();
		;
	}

	public String getUsernameErrorMessage() throws Exception {
		return getErrorMessageHelper("Username");
	}

	public Object getPasswordErrorMessage() throws Exception {
		return getErrorMessageHelper("Password");
	}

	private String getErrorMessageHelper(String fieldText) throws Exception {
		List<WebElement> inputFields = this.element.findElements(By.className("v-input__control"));

		for (WebElement webElement : inputFields) {
			if (webElement.getText().contains(fieldText)) {
				return webElement.findElement(By.className("v-messages__message")).getText();
			}
		}

		throw new Exception("Could not find 'Username' element");
	}

}
