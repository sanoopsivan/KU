/**
 * 
 */
package com.bas.KU.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bas.KU.constants.KUConstants;
import com.bas.KU.enums.AdminStatus;
import com.bas.KU.enums.UserStatus;
import com.bas.KU.functions.MainFunctions;
import com.bas.KU.models.Admin;
import com.bas.KU.models.Status;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */

@Controller
@SessionAttributes(KUConstants.ADMIN)
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class.getName());

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	// for POST Request
	// FIXME
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password, ModelMap model)
			throws UnsupportedEncodingException {

		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			Admin admin = adminService.getAdmin(username, password);
			if (admin == null) {
				// redirectAttributes.addFlashAttribute("errorMessage", "Please
				// provide valid credentials!");
				return "redirect:/" + KUConstants.LOGIN_PAGE + "?error="
						+ URLEncoder.encode("Please provide valid credentials!", "UTF-8");
			}
			MainFunctions.setModel(model, admin);
			MainFunctions.runSheduler();
			return "redirect:/" + KUConstants.VIEW_PAGE;

		}
		// redirectAttributes.addFlashAttribute("errorMessage", "Please provide
		// valid credentials!");
		return "redirect:/" + KUConstants.LOGIN_PAGE;

	}

	// for GET Request
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLogin(ModelMap model, SessionStatus status, RedirectAttributes redirectAttributes) {
		if (model.containsAttribute(KUConstants.ADMIN))
			return "redirect:/" + KUConstants.VIEW_PAGE;
		/*if (model.containsAttribute("errorMessage"))
			redirectAttributes.addFlashAttribute("errorMessage", "Please provide valid credentials!");*/
		return KUConstants.LOGIN_PAGE;
	}

	// remove session variable on logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout(ModelMap model, SessionStatus status) {
		status.setComplete();
		return "redirect:/" + KUConstants.LOGIN_PAGE;
	}

	// show view page after successful login
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String adminView(ModelMap model) {
		if (!model.containsAttribute(KUConstants.ADMIN))
			return "redirect:/" + KUConstants.LOGIN_PAGE;
		List<Status> statusList = new ArrayList<>();
		for (UserStatus status : UserStatus.values()) {
			statusList.add(MainFunctions.getStatusOf(status));
		}
		model.addAttribute("statusList", statusList);
		return KUConstants.VIEW_PAGE;
	}

}
