/**
 * 
 */
package com.bas.KU.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bas.KU.constants.KUConstants;
import com.bas.KU.enums.AdminStatus;
import com.bas.KU.functions.MainFunctions;

/**
 * @author San This controller will override the spring default controller and
 *         show login page on start up
 *
 */
@Controller
@SessionAttributes(KUConstants.ADMIN)
public class DefaultController {

	// will load the login page on start up
	@RequestMapping("/")
	public String login(ModelMap model) {
		if (model.containsAttribute(KUConstants.ADMIN))
			return "redirect:/" + KUConstants.VIEW_PAGE;
		return KUConstants.LOGIN_PAGE;
	}

}
