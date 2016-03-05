package de.sauriel.nexus.model.usermanagement;

import de.sauriel.nexus.config.variables.Page;

public class LoginModel {

	private String loginName;
	private String password;
	private boolean rememberMe = false;

	private Page view;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public Page getView() {
		return view;
	}

	public String getViewName() {
		return view.getViewName();
	}

	public void setView(Page view) {
		this.view = view;
	}
}
