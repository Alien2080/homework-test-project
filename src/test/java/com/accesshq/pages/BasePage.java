/**
 * 
 */
package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.ui.LoginDialog;

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
	
	public LoginDialog clickUsersMenuItem() {
		this.driver.findElement(By.cssSelector("[aria-label='users']")).click();
		return new LoginDialog(this.driver.findElement(By.className("v-dialog--active")), this.wait);
	}
	

	public PlanetsPage clickPlanetsMenuItem() {
		this.driver.findElement(By.cssSelector(".v-toolbar__items [aria-label='planets']")).click();
		return new PlanetsPage(this.driver, this.wait);
	}

	
}
