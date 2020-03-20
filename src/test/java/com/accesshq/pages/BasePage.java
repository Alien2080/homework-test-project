/**
 * 
 */
package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Tom Aylen
 *
 */
public abstract class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public FormsPage clickFormsMenuItem() {
		driver.findElement(By.cssSelector(".v-toolbar__items [aria-label='forms']")).click();
		return new FormsPage(driver);
	}
	
}
