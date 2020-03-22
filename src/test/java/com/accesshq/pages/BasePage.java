/**
 * 
 */
package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Tom Aylen
 *
 */
public abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public FormsPage clickFormsMenuItem() {
		this.driver.findElement(By.cssSelector(".v-toolbar__items [aria-label='forms']")).click();
		return new FormsPage(this.driver, this.wait);
	}
	
}
