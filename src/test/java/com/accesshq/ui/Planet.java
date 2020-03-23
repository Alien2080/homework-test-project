package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planet {
	
	private WebElement exploreButton;
	private long distanceFromSun;
	private double radius;
	private String name;
	
	public Planet(WebElement planet) {
		this.exploreButton = planet.findElement(By.tagName("button"));
		this.distanceFromSun = Long.parseLong(removeNotNumbers(planet.findElement(
				By.className("distance")).getText()));
		this.radius = Double.parseDouble(removeNotNumbers(planet.findElement(
				By.className("radius")).getText()));
		this.name = planet.findElement(By.className("name")).getText();
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public long getdistanceFromSun() {
		return this.distanceFromSun;
	}

	public String getName() {
		return this.name;
	}

	public void clickExploreButton() {
		this.exploreButton.click();
	}
	
	private String removeNotNumbers(String input) {
		return input.replace(",", "").replace(" km", "");
	}
}
