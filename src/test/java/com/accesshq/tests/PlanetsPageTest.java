package com.accesshq.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.accesshq.pages.HomePage;
import com.accesshq.pages.PlanetsPage;

class PlanetsPageTest extends BaseTestSuite {

	@Test
	void testExploreButton() {
		
		// Arrange
		HomePage homePage = new HomePage(driver, wait);
		PlanetsPage planetsPage = homePage.clickPlanetsMenuItem();
		String planetName = "Neptune";
		
		// Act
		planetsPage.clickExploreButton(planetName);
		
		// Assert
		assertEquals("Exploring " + planetName, planetsPage.getAlertMessage());
	}

}
