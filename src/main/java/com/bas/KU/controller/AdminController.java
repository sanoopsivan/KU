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

/**
 * @author San
 *
 */

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/addArea", method = RequestMethod.GET)
	public String addUser() {
		return "addArea";
	}

	@RequestMapping(value = "/addArea", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "areaCode", required = false) String areaCode, ModelMap model) {

		if (StringUtils.isNotBlank(areaCode)) {
			Area area = new Area(areaCode);
			adminService.insertArea(area);
		}
		List<Area> areaList = adminService.getAreaList();
		if (areaList != null)
			model.addAttribute("areaList", areaList);

		return "addArea";
	}

}
