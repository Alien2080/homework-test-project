package com.accesshq.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.accesshq.pages.HomePage;

class HomePageTest extends BaseTestSuite {

	@Test
	void testHelloGreetingPopupMessage() {
		
		// Arrange
		HomePage homePage = new HomePage(driver, wait);
		String name = "Dan";
		
		// Act
		homePage.setForename(name);
		homePage.clickSubmitButton();
		
		// Assert
		Assertions.assertEquals("Hello " + name, homePage.getPopupMessage());
	}
	
	@Test
	void testStateTransition() {
		
		// Arrange
		HomePage homePage = new HomePage(driver, wait);
		
		// Act
		homePage.clickUpDownButton();
		
		// Assert
		assertEquals("CLICK ME UP!", homePage.getUpDownButtonText());
		
		// Act
		homePage.clickUpDownButton();
		
		// Assert
		assertEquals("CLICK ME DOWN!", homePage.getUpDownButtonText());
	}

}
