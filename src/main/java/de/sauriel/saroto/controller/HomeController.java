package de.sauriel.saroto.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.sauriel.saroto.config.variables.RequestViewMapping;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = RequestViewMapping.HOME, method = RequestMethod.GET)
	public String showHome(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		LOGGER.info("Locale: {} - {}", locale, formattedDate);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"messages/messageContext.xml");
		String englishMsg = context.getMessage("menu.rules.title",null, Locale.ENGLISH);
		String germanMsg = context.getMessage("menu.rules.title",null, Locale.GERMAN);
		String frenchMsg = context.getMessage("menu.rules.title",null, Locale.FRENCH);
		LOGGER.info("i18n Message:: EN: {}, DE: {}, FR: {}", englishMsg, germanMsg, frenchMsg);

		model.addAttribute("serverTime", formattedDate );

		return RequestViewMapping.HOME_VIEW;
	}

}
