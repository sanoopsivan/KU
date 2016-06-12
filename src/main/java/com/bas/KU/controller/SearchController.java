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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.KU.models.Area;
import com.bas.KU.models.SearchParams;
import com.bas.KU.models.SearchResult;
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

	/*
	 * @RequestMapping(value = "/ajax/getUsers") public @ResponseBody List<User>
	 * Search(@RequestParam(value = "q", required = false) String q,
	 * 
	 * @RequestParam(value = "status", required = false) String status,
	 * 
	 * @RequestParam(value = "startDate", required = false) String startDate,
	 * 
	 * @RequestParam(value = "endDate", required = false) String endDate,
	 * 
	 * @RequestParam(value = "area", required = false) String area) {
	 * 
	 * List<User> searchResults = new ArrayList<>();
	 * 
	 * String query = MainUtils.getQuery(q, area, status, startDate, endDate);
	 * System.out.println("Eneterd search"); System.out.println("Query :" +
	 * query); searchResults = userService.getUserList(query);
	 * 
	 * return searchResults; }
	 */
	@RequestMapping(value = "/ajax/getAreas", method = RequestMethod.POST)
	public @ResponseBody List<Area> getAreaList() {
		List<Area> searchResults = new ArrayList<>();
		searchResults = adminService.getAreaList();
		// System.out.println(searchResults.size());
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getSearchHelp", method = RequestMethod.POST)
	public @ResponseBody List<String> getSearchHelp() {
		List<String> searchResults = new ArrayList<>();
		// searchResults = adminService.getAreaList();
		// System.out.println(searchResults.size());
		searchResults = MainUtils.getSearchHelpers();
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getUsers")
	public @ResponseBody SearchResult Search(@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "paginationHelper", defaultValue = "5") int paginationHelper) {

		SearchResult searchResult = new SearchResult();

		String query = MainUtils.getQuery(q, area, status, startDate, endDate, page ,paginationHelper);
		System.out.println("Eneterd search");
		System.out.println("Query :" + query);
		System.out.println("paginationHelper :" + paginationHelper);
		searchResult.setUserList(userService.getUserList(query));
		searchResult.setTotalPages(
				(int) Math.ceil(((float) userService.getUserList().size()) / ((float) paginationHelper)));
		searchResult.setCurrentPage(page);
		return searchResult;
	}

}
