package com.accesshq.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.accesshq.pages.FormsPage;
import com.accesshq.pages.HomePage;

class FormsPageTest extends BaseTestSuite {

	@Test
	void testMandatoryErrorMessagesArePresentWhenFieldsAreInvalid() throws Exception {
		
		// Arrange
		FormsPage formsPage = FormsPageTest.getFormsPage();
		
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
		FormsPage formsPage = FormsPageTest.getFormsPage();
		
		// Act
		formsPage.setName("Dan");
		formsPage.setEmail("dan@abc.com");
		formsPage.clickAgree();
		
		// Assert
		Assertions.assertEquals("", formsPage.getNameErrorMessage());
		Assertions.assertEquals("", formsPage.getEmailErrorMessage());
		Assertions.assertEquals("", formsPage.getAgreeErrorMessage());
	}

	@Test
	void testSuccessfulSubmission() throws Exception {
		
		// Arrange
		FormsPage formsPage = FormsPageTest.getFormsPage();
		
		// Act
		String name = "Dan";
		formsPage.setName(name);
		formsPage.setEmail("dan@abc.com");
		formsPage.clickAgree();
		formsPage.clickSubmitButton();
		
		// Assert
		Assertions.assertEquals("Thanks for your feedback " + name, formsPage.getPopupMessage());
	}
	
	private static FormsPage getFormsPage() {
		HomePage homePage = new HomePage(driver, wait); // , wait);
		return homePage.clickFormsMenuItem();
	}
	
}
