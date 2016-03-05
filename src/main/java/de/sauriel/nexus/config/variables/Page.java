package de.sauriel.nexus.config.variables;

public enum Page {
	HOME(RequestViewMapping.HOME_VIEW);

	private String viewName;

	Page(String view) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}
}
