package de.sauriel.saroto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.sauriel.saroto.config.variables.RequestViewMapping;

@Controller
public class RulebookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulebookController.class);

	@RequestMapping(value = RequestViewMapping.RULEBOOK, method = RequestMethod.GET)
	public String showRulebook(Model model, @RequestParam String rulebook) {
		LOGGER.info("Rulebook: {} ", rulebook);

		model.addAttribute("rulebook", rulebook );

		return RequestViewMapping.RULEBOOK_VIEW;
	}

}
