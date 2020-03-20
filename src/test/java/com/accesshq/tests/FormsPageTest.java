package com.accesshq.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.accesshq.pages.FormsPage;
import com.accesshq.pages.HomePage;

class FormsPageTest extends BaseTestSuite {

	@Test
	void testMandatoryErrorMessagesArePresentWhenFieldsAreInvalid() throws Exception {
		
		// Arrange
		HomePage homePage = new HomePage(driver);
		FormsPage formsPage = homePage.clickFormsMenuItem();
		
		// Act
		formsPage.clickSubmitButton();
		
		// Assert
		Assertions.assertEquals("Your name is required", formsPage.getNameErrorMessage());
		Assertions.assertEquals("Your email is required", formsPage.getEmailErrorMessage());
		Assertions.assertEquals("You must agree to continue", formsPage.getAgreeErrorMessage());
	}
	
	@Test
	void testMandatoryErrorMessagesAreRemovedWhenFieldsAreValid() throws Exception {
		
		// Arrange
		HomePage homePage = new HomePage(driver);
		FormsPage formsPage = homePage.clickFormsMenuItem();
		
		// Act
		formsPage.setName("Dan");
		formsPage.setEmail("dan@abc.com");
		formsPage.clickAgree();
		
		// Assert
		Assertions.assertEquals("", formsPage.getNameErrorMessage());
		Assertions.assertEquals("", formsPage.getEmailErrorMessage());
		Assertions.assertEquals("", formsPage.getAgreeErrorMessage());
	}

}
