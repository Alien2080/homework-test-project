package com.accesshq.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.accesshq.pages.HomePage;
import com.accesshq.ui.LoginDialog;

class LoginDiaglogTest extends BaseTestSuite {

	@Test
	void testManadatoryErrorMessages() throws Exception {
		
		// Arrange
		HomePage homePage = new HomePage(driver, wait);
		LoginDialog loginDialog = homePage.clickUsersMenuItem();
		
		// Act
		loginDialog.clickLoginButton();
		
		// Assert
		assertEquals("Invalid user and password", loginDialog.getUsernameErrorMessage());
		assertEquals("Invalid user and password", loginDialog.getPasswordErrorMessage());
	}

}
