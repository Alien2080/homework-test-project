/**
 * 
 */
package com.accesshq.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Tom Aylen
 *
 */
abstract class  BaseTestSuite {

	protected static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://d1iw6mb9di5l9r.cloudfront.net/");
	}

}
