package com.accesshq.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.accesshq.pages.HomePage;
import com.accesshq.ui.UnorderedList;

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

	@Test
	void testLoveList() throws Exception {

		// Arrange
		HomePage homePage = new HomePage(driver, wait);
		UnorderedList unorderedList = homePage.getUnorderedList();
		String listItemText = "List Item 2";

		// Act
		unorderedList.clickHeart(listItemText);

		// Assert
		assertEquals("You loved " + listItemText, homePage.getPopupMessage());
	}

	@Test
	void testButtons() throws Exception {

		// Arrange
		HomePage homePage = new HomePage(driver, wait);

		// Act
		homePage.clickLoginButton();

		// Assert
		assertEquals("You clicked the login button", homePage.getAlertMessage());

		// Act
		homePage.clickCancelButton();

		// Assert
		assertEquals("You clicked the cancel button", homePage.getAlertMessage());

		// Act
		homePage.clickHomeButton();

		// Assert
		assertEquals("You clicked the home button", homePage.getAlertMessage());

		// Act
		homePage.clickLinkButton();

		// Assert
		assertEquals("You clicked the link button", homePage.getAlertMessage());

		// Act
		homePage.clickUploadButton();

		// Assert
		assertEquals("You clicked the upload button", homePage.getAlertMessage());
	}

}
