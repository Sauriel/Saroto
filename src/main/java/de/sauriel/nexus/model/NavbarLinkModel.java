package de.sauriel.nexus.model;

public class NavbarLinkModel {

	private String name;
	private String link;

	private NavbarLinkModel(String name, String link) {
		this.name = name;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public static NavbarLinkModel create(String name, String link) {
		return new NavbarLinkModel(name, link);
	}
}
