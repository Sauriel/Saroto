package de.sauriel.nexus.controller.usermanagement;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.sauriel.nexus.component.usermanagement.RegisterComponent;
import de.sauriel.nexus.config.variables.RequestViewMapping;
import de.sauriel.nexus.model.usermanagement.RegisterModel;

@Controller
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	public final static String REGISTER_MODEL_NAME = "registerModel";

	@Autowired
	private RegisterComponent registerComponent;

	@RequestMapping(value = RequestViewMapping.REGISTER, method = RequestMethod.GET)
	public String showRegister(@ModelAttribute(REGISTER_MODEL_NAME) RegisterModel registerModel) {
		return RequestViewMapping.REGISTER_VIEW;
	}

	@RequestMapping(value = RequestViewMapping.REGISTER, method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute(REGISTER_MODEL_NAME) RegisterModel registerModel,
			BindingResult result) {
		if (result.hasErrors()) {
			LOGGER.error(result.getAllErrors().toString());
			return RequestViewMapping.REGISTER_VIEW;
		}
		registerComponent.registerUser(registerModel);

		return RequestViewMapping.REGISTER_VIEW;
	}

}
