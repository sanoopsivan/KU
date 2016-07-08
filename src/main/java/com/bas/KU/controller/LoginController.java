/**
 * 
 */
package com.bas.KU.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
			String role = (admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.SUPERADMIN.getStatus()))
					? AdminStatus.SUPERADMIN.getStatus()
					: admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.ADMIN.getStatus())
							? AdminStatus.ADMIN.getStatus() : AdminStatus.UNAUTHORISED.getStatus();
			MainFunctions.setModel(model, admin);
			return "redirect:" + MainFunctions.getPage(role);

		}
		return "redirect:/login";

	}

	// for GET Request
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLogin(ModelMap model, SessionStatus status) {
		if (model.containsAttribute("admin"))
			return "redirect:/view";

		return MainFunctions.getPage(AdminStatus.UNAUTHORISED.getStatus());
	}

	// remove session variable on logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout(ModelMap model, SessionStatus status) {
		// MainFunctions.removeAdminSessionAttributeFromModel(model);
		status.setComplete();
		return "redirect:/login";
	}

	// show view page after successful login
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String adminView(ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect:/login";
		}
		List<Status> statusList = new ArrayList<>();
		for (UserStatus status : UserStatus.values()) {
			statusList.add(MainFunctions.getStatusOf(status));
		}
		model.addAttribute("statusList", statusList);
		return "view";
	}

}
