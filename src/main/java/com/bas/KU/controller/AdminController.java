/**
 * 
 */
package com.bas.KU.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bas.KU.models.Area;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;
import com.bas.KU.utils.MainUtils;

/**
 * @author San
 *
 */

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	public static MainUtils mainUtils = new MainUtils();

	@RequestMapping(value = "/addArea", method = RequestMethod.GET)
	public String addUser(ModelMap model) {

		setAreaList(model);
		return "addArea";
	}

	@RequestMapping(value = "/addArea", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "areaCode", required = false) String areaCode, ModelMap model) {

		if (StringUtils.isNotBlank(areaCode)) {
			Area area = new Area(areaCode);
			adminService.insertArea(area);
		}
		setAreaList(model);

		return "addArea";
	}

	@RequestMapping(value = "/addUniqueID", method = RequestMethod.POST)
	public String addUniqueID(@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "value", required = false) String value, ModelMap model) {
		
		return "addUniqueID";
	}

	@RequestMapping(value = "/addUniqueID", method = RequestMethod.GET)
	public String addUniqueID(ModelMap model) {
		return "addUniqueID";
	}

	private void setAreaList(ModelMap model) {
		model.addAttribute("areaList", adminService.getAreaList());
	}

}
