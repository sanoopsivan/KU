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

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		
		String role = AdminStatus.UNAUTHORISED.getStatus();

		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			// get admin by provided username and password
			Admin admin = adminService.getAdmin(username, password);
			// get the role of the admin
			if (admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.ADMIN.getStatus()))
				role = AdminStatus.ADMIN.getStatus();
			else if (admin != null && admin.getStatus().equalsIgnoreCase(AdminStatus.SUPERADMIN.getStatus()))
				role = AdminStatus.SUPERADMIN.getStatus();

		}
		return new ModelAndView(MainUtils.getPage(role),"role",role);

	}

}
