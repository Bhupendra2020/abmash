package com.abmash.api.query.predicate;

import com.abmash.core.jquery.JQueryFactory;

public class TagPredicate extends Predicate {

	private String name;
	
	public TagPredicate(String name) {
		this.name = name;
	}

	@Override
	public void buildCommands() {
		jQueryList.add(JQueryFactory.select("'" + name + "'"));
	}
}