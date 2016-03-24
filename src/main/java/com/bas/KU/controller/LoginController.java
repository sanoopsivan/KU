/**
 * 
 */
package com.bas.KU.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bas.KU.functions.KUFunctions;
import com.bas.KU.models.Admin;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;
import com.bas.KU.utils.MainUtils;
import com.bas.KU.enums.*;

/**
 * @author San
 *
 */

@RequestMapping(value = "/login")
@Controller
public class LoginController {

	@Autowired
	AdminService adminService;

	// for POST Request
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,ModelMap model) {

		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			Admin admin = adminService.getAdmin(username, password);
			String role = admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.SUPERADMIN.getStatus())
					? AdminStatus.SUPERADMIN.getStatus()
					: admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.ADMIN.getStatus())
							? AdminStatus.ADMIN.getStatus() : AdminStatus.UNAUTHORISED.getStatus();
			model.addAttribute("user", admin);

			return new ModelAndView(MainUtils.getPage(role));

		}
		return new ModelAndView(MainUtils.getPage(AdminStatus.UNAUTHORISED.getStatus()));

	}

	// for GET Request
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminLogin() {
		return new ModelAndView(MainUtils.getPage(AdminStatus.UNAUTHORISED.getStatus()));
	}

}
