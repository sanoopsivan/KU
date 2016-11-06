/**
 * 
 */
package com.bas.KU.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bas.KU.constants.KUConstants;
import com.bas.KU.functions.MainFunctions;
import com.bas.KU.models.Area;
import com.bas.KU.models.SearchResult;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */

@Controller
@SessionAttributes(KUConstants.ADMIN)
public class SearchController {

	private static Logger loger = Logger.getLogger(SearchController.class.getName());

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/ajax/getAreas", method = RequestMethod.POST)
	public @ResponseBody List<Area> getAreaList() {
		List<Area> searchResults = new ArrayList<>();
		searchResults = adminService.getAreaList();
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getSearchHelp", method = RequestMethod.POST)
	public @ResponseBody List<String> getSearchHelp() {
		List<String> searchResults = new ArrayList<>();
		searchResults = MainFunctions.getSearchHelpers();
		return searchResults;
	}

	@RequestMapping(value = "/ajax/getUsers", method = RequestMethod.POST)
	public @ResponseBody SearchResult Search(@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "paginationHelper", defaultValue = "5") int paginationHelper, ModelMap model) {

		SearchResult searchResult = new SearchResult();

		String query = MainFunctions.getQuery(q, area, status, startDate, endDate);
		String queryWithPagination = MainFunctions.getQueryWithPagination(query, page, paginationHelper);
		loger.info("Query :" + query);
		loger.info("Query with paginaton :" + queryWithPagination);
		searchResult.setUserList(userService.getUserList(queryWithPagination));
		int totalPages = 0;
		try {
			totalPages = (int) Math.ceil(((float) userService.getUserList(query).size()) / ((float) paginationHelper));
		} catch (Exception e) {

		}
		if (model.containsAttribute(KUConstants.ADMIN))
			searchResult.setShowAdditionalOptions(MainFunctions.isSuperAdmin(model));
		searchResult.setTotalPages(totalPages);
		searchResult.setCurrentPage(page);
		return searchResult;
	}

}
