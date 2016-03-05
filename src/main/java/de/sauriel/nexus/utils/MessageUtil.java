package de.sauriel.nexus.utils;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageUtil {

	public static String getMessage(String key) {
		return getMessage(key, null, getLocale());
	}

	public static String getMessage(String key, String[] args) {
		return getMessage(key, args, getLocale());
	}

	public static String getMessage(String key, Locale locale) {
		return getMessage(key, null, locale);
	}

	public static String getMessage(String key, String[] args, Locale locale) {
		ApplicationContext context = new ClassPathXmlApplicationContext("messages/messageContext.xml");
		return context.getMessage(key, args, locale);
	}

	private static Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}
}
