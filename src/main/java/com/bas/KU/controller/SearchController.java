/**
 * 
 */
package com.bas.KU.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.KU.models.Area;
import com.bas.KU.models.SearchHelper;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;
import com.bas.KU.utils.MainUtils;

/**
 * @author San
 *
 */

@Controller
public class SearchController {

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@RequestMapping("/ajax/getUsers")
	public @ResponseBody List<User> Search(@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "searchByArea", required = false) String area,
			@RequestParam(value = "fromDate", required = false) Date startDate,
			@RequestParam(value = "tillDate", required = false) Date endDate,
			@RequestParam(value = "searchCustomerByStatus", required = false) String status) {

		List<User> searchResults = new ArrayList<>();

		String query = MainUtils.getQuery(q, area, status, startDate, endDate);
		System.out.println("Eneterd search");
		searchResults = userService.getUserList(query);
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getAreas", method = RequestMethod.POST)
	public @ResponseBody List<Area> getAreaList() {
		System.out.println("Eneterd getAreas");
		List<Area> searchResults = new ArrayList<>();
		searchResults = adminService.getAreaList();
		System.out.println(searchResults.size());
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getSearchHelp", method = RequestMethod.POST)
	public @ResponseBody List<SearchHelper> getSearchHelp() {
		System.out.println("Eneterd getAreas");
		List<SearchHelper> searchResults = new ArrayList<>();
		// searchResults = adminService.getAreaList();
		// System.out.println(searchResults.size());
		MainUtils.getSearchHelp();
		return searchResults;
	}

}
