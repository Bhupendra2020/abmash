package com.abmash.core.browser.htmlquery.condition;

import com.abmash.core.browser.htmlquery.selector.CssSelector;
import com.abmash.core.browser.htmlquery.selector.JQuerySelector;
import com.abmash.core.browser.htmlquery.selector.Selector;
import com.abmash.core.browser.htmlquery.selector.SelectorGroup;
import com.abmash.core.browser.htmlquery.selector.XpathSelector;

public class SelectorCondition extends Condition {
	
	/**
	 * Query type of specific selectors
	 */
	public enum QueryType {
		CSS, XPATH, JQUERY,
	}
	
	private String query;
	private QueryType queryType;
	
	// constructors
	
	public SelectorCondition(String query, QueryType queryType) {
		this.query = query;
		this.queryType = queryType;
	}
	
	// condition
	
	@Override
	protected void buildSelectors() {
		Selector selector;
		switch (queryType) {
		case XPATH:
			selector = new XpathSelector(query);
			break;
		case JQUERY:
			selector = new JQuerySelector(query);
			break;
		case CSS:
		default:
			selector = new CssSelector(query);
			break;
		}
		selectors.add(new SelectorGroup(selector));
	}

	public String toString() {
		return super.toString() + " with type \"" + queryType + "\" and query \"" + query + "\"";
	}

}
