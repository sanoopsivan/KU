/**
 * 
 */
package com.bas.KU.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bas.KU.enums.AdminStatus;
import com.bas.KU.models.Admin;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;
import com.bas.KU.utils.MainUtils;

/**
 * @author San
 *
 */

@Controller
@SessionAttributes("admin")

public class LoginController {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	// for POST Request
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password, ModelMap model) {

		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			Admin admin = adminService.getAdmin(username, password);
			String role = admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.SUPERADMIN.getStatus())
					? AdminStatus.SUPERADMIN.getStatus()
					: admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.ADMIN.getStatus())
							? AdminStatus.ADMIN.getStatus() : AdminStatus.UNAUTHORISED.getStatus();
			setModel(model, admin);

			return "redirect:" + MainUtils.getPage(role);

		}
		return "redirect:" + (MainUtils.getPage(AdminStatus.UNAUTHORISED.getStatus()));

	}

	// for GET Request
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLogin() {
		return MainUtils.getPage(AdminStatus.UNAUTHORISED.getStatus());
	}

	// set the model
	private ModelMap setModel(ModelMap model, Admin admin) {
		if (admin != null) {
			model.addAttribute("admin", admin);
		}
		return model;
	}

	// remove session variable on logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout(ModelMap model) {
		model.remove("admin");
		return MainUtils.getPage(AdminStatus.UNAUTHORISED.getStatus());
	}
	
	//show view page after successfull login
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public String adminView() {
		
		return "view";
	}

}
