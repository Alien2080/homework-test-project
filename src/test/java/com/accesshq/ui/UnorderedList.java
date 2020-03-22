package com.accesshq.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UnorderedList {
	
	private WebElement element;

	public UnorderedList(WebElement listElement) {
		this.element = listElement;
	}

	public void clickHeart(String itemText) throws Exception {
		
		List<WebElement> elements = element.findElements(By.className("list-item"));
		
		for (WebElement webElement : elements) {
			if (webElement.getText().contains(itemText)) {
				webElement.findElement(By.tagName("i")).click();
				return;
			}
		}
		
		throw new Exception("Could not find list item with value " + itemText);
	}
	
}
