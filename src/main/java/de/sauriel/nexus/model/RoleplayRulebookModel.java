package de.sauriel.nexus.model;

public class RoleplayRulebookModel {

	private String title;
	private String description;
	private String cover;
	private String link;

	private RoleplayRulebookModel(String title, String description, String cover, String link) {
		this.title = title;
		this.description = description;
		this.cover = cover;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public static RoleplayRulebookModel create(String title, String description, String cover, String link) {
		return new RoleplayRulebookModel(title, description, cover, link);
	}

	public static RoleplayRulebookModel create(String title, String description, String cover) {
		String link = title.replaceAll("[^a-zA-Z0-9]+", "");
		return new RoleplayRulebookModel(title, description, cover, link);
	}
}
