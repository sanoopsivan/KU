/**
 * 
 */
package com.bas.KU.controller;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bas.KU.enums.AdminStatus;
import com.bas.KU.functions.MainFunctions;
import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;
import com.bas.KU.services.AdminService;

/**
 * @author San This controller handles are the services for admin
 *
 */

@Controller
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	// public static MainFunctions mainFunctions = new MainFunctions();

	// Controller which handle addArea Get request
	@RequestMapping(value = "/addArea", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect : /login";
		}
		MainFunctions.setAreaList(model);
		return "addArea";
	}

	// Controller which handle addArea POST request
	@RequestMapping(value = "/addArea", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "areaCode", required = false) String areaCode, ModelMap model) {
		if (StringUtils.isNotBlank(areaCode)) {
			Area area = new Area(areaCode);
			adminService.insertArea(area);
		}
		MainFunctions.setAreaList(model);
		return "addArea";
	}

	// Controller which handle addUniqueID POST request
	@RequestMapping(value = "/addUniqueID", method = RequestMethod.POST)
	public String addUniqueID(@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "value", required = false) String value, ModelMap model) {
		if (StringUtils.isNotBlank(format) || StringUtils.isNotBlank(value)) {
			KUid kuid = new KUid();
			kuid.setFormat(format);
			kuid.setValue(value);
			kuid.setKUid(format, value);
			adminService.insertKUid(kuid);
		}
		model.addAttribute("KUid", adminService.getLastKuid());
		return "addUniqueID";
	}

	// Controller which handle addUniqueID GET request
	@RequestMapping(value = "/addUniqueID", method = RequestMethod.GET)
	public String addUniqueID(ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect : login";
		}
		model.addAttribute("KUid", adminService.getLastKuid());
		return "addUniqueID";
	}

	// Controller which handle addUniqueID GET request
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect : login";
		}

		return "adminHome";
	}

}
