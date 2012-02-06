package com.abmash.core.browser.htmlquery.selector;


import org.openqa.selenium.By;

import com.abmash.api.Browser;
import com.abmash.api.HtmlElement;
import com.abmash.api.HtmlElements;



public class XpathSelector extends Selector {

	public XpathSelector(String expression) {
		super(expression);
	}

	@Override
	public HtmlElements find(Browser browser) {
		return new HtmlElements(browser, browser.getWebDriver().findElements(By.xpath(expression)));
	}

	@Override
	public HtmlElements find(Browser browser, HtmlElement rootElement) {
		return new HtmlElements(browser, rootElement.getSeleniumElement().findElements(By.xpath(expression)));
	}
	
}
