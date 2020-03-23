package com.accesshq.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.ui.Planet;

public class PlanetsPage extends BasePage {
	
	private List<Planet> planets;

	public PlanetsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

		List<WebElement> planetElements = this.driver.findElements(By.className("planet"));
		this.planets = new ArrayList<Planet>();

		for (WebElement webElement : planetElements) {
			this.planets.add(new Planet(webElement));
		}
	}

	public void clickExploreButton(String planetName) {
		for (Planet planet : planets) {
			if(planet.getName().equals(planetName)) {
				planet.clickExploreButton();
			}
		}
	}

	public String getAlertMessage() {
		this.wait.until(ExpectedConditions.textMatches(By.className("popup-message"), Pattern.compile(".{1,}")));
		return this.driver.findElement(By.className("popup-message")).getText();
	}

}
