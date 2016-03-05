package de.sauriel.nexus.controller.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.sauriel.nexus.component.usermanagement.LoginComponent;
import de.sauriel.nexus.config.variables.RequestViewMapping;
import de.sauriel.nexus.model.usermanagement.LoginModel;

@Controller
public class LoginController {

	public final static String LOGIN_MODEL_NAME = "loginModel";

	@Autowired
	private LoginComponent loginComponent;

	@RequestMapping(value = RequestViewMapping.LOGIN, method = RequestMethod.POST)
	public String login(@ModelAttribute(LOGIN_MODEL_NAME) LoginModel loginModel, BindingResult result) {
		if (!loginComponent.login(loginModel)) {
			// TODO: Add Error Message
			System.out.println("Can't log in.");
		} else {
			System.out.println("Successfully logged in.");
		}

		return loginModel.getView() != null ? loginModel.getViewName() : RequestViewMapping.HOME_VIEW;
	}
}
