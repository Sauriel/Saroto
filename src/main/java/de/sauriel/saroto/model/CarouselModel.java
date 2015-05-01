package de.sauriel.saroto.model;

public class CarouselModel {

	private String titel;
	private String text;
	private String link;
	private String image;

	private CarouselModel(String titel, String text, String link, String image) {
		this.titel = titel;
		this.text = text;
		this.link = link;
		this.image = image;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static CarouselModel create(String titel, String text, String link, String image) {
		return new CarouselModel(titel, text, link, image);
	}
}
