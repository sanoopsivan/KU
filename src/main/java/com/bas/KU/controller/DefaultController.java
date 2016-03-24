/**
 * 
 */
package com.bas.KU.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author San
 *
 */
@Controller
public class DefaultController {

	@RequestMapping("/")
	public ModelAndView login(Locale locale) {
		// for study purpose
		// System.out.println(locale.getCountry());
		return new ModelAndView("login");
	}
}
