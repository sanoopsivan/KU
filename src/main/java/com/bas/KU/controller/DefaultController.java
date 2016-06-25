/**
 * 
 */
package com.bas.KU.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author San 
 * This controller will override the spring default controller and
 *         show login page on start up
 *
 */
@Controller
public class DefaultController {

	// will load the login page on start up
	@RequestMapping("/")
	public String login(Locale locale) {
		// for study purpose
		// System.out.println(locale.getCountry());
		return "login";
	}

}
