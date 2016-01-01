package de.sauriel.saroto.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import de.sauriel.saroto.model.NavbarLinkModel;
import de.sauriel.saroto.model.RoleplayRulebookModel;

@Service
public class GlobalModelAttributes {

	private HashMap<String, Object> attributes = new HashMap<>();
	private static final String HOME_URL = "http://localhost:8080/saroto";

	private GlobalModelAttributes() {
		attributes.put("site", "geek:roleplay");
		attributes.put("imageFolder", HOME_URL + "/resources/images/");
		attributes.put("jsFolder", HOME_URL + "/resources/js/");
		attributes.put("cssFolder", HOME_URL + "/resources/css/");
		ArrayList<NavbarLinkModel> navbarLinks = new ArrayList<>();
		navbarLinks.add(NavbarLinkModel.create("geek:home", "http://sauriel.de"));
		navbarLinks.add(NavbarLinkModel.create("geek:roleplay", HOME_URL));
		attributes.put("navbarLinks", navbarLinks);
		ArrayList<RoleplayRulebookModel> rulebooks = new ArrayList<>();
		rulebooks.add(
				RoleplayRulebookModel.create("Endland v2", "Version zwei des Endland Regelwerkes.", "endlandv2.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dungeons & Dragons Next",
				"Die nächste Version des Dungeons & Dragons Regelwerkes.", "dndnext.png", "DnDNext"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		rulebooks.add(RoleplayRulebookModel.create("Dummy Regelwerk", "Lorem Ipsum set dolor et unam.", "temp.png"));
		attributes.put("rulebooks", rulebooks);
	}

	public HashMap<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void putAttribute(String key, String value) {
		attributes.put(key, value);
	}

}
