/**
 * 
 */
package com.bas.KU.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.bas.KU.models.Area;
import com.bas.KU.models.SearchParams;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */
@Service
public class MainUtils {
	private static final String DEFAULT_STATUS = "ALL";
	public static final int NUMBER_OF_RESULTS_PER_PAGE = 1;

	@Autowired
	public static UserService userService;
	@Autowired
	public static AdminService adminService;

	public static void setAdminService(AdminService adminService) {
		MainUtils.adminService = adminService;
	}

	public UserService getAdminService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private static final String QUERY = "select * from user";
	private static final String WHERE_CLAUSE = " where ";
	private static final String AND_CLAUSE = " AND ";
	private static final String LIMIT = " LIMIT %d,%d";

	// return the page names after checking the role
	public static String getPage(String role) {
		switch (role) {
		case "admin":
		case "superadmin":
			return "view";
		case "unauthorized":
		default:
			return "login";
		}
	}

	public static String getQuery(String q, String area, String status, String startDate, String endDate, int page) {
		page = page - 1;
		boolean isWhereClauseAdded = false;
		StringBuilder query = new StringBuilder(QUERY);
		if (StringUtils.isBlank(q) && StringUtils.isBlank(area)
				&& (StringUtils.isBlank(status) || status.equalsIgnoreCase("ALL")) && startDate == null
				&& endDate == null)
			return query.toString();
		if (StringUtils.isNotBlank(q)) {
			query.append(WHERE_CLAUSE).append("(").append("firstName like '").append(q).append("%' OR lastName like '")
					.append(q).append("%' OR name like '").append(q).append("%' OR address like '").append(q)
					.append("%' OR phoneNumber like '").append(q).append("%'").append(")");
			isWhereClauseAdded = true;
		}
		if (StringUtils.isNotBlank(area)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("areaCode like '").append(area).append("%')");
		}
		if (StringUtils.isNotBlank(status) && !StringUtils.equalsIgnoreCase(status, DEFAULT_STATUS)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("status like '").append(status).append("')");
		}

		if (StringUtils.isNotBlank(startDate)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("creationDate >").append(startDate).append(")");
		}
		if (StringUtils.isNotBlank(endDate)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("creationDate <").append(endDate).append(")");
		}
		int startPage = 0;
		if (page != 0)
			startPage = NUMBER_OF_RESULTS_PER_PAGE * page;
		// int endPage = startPage + NUMBER_OF_RESULTS_PER_PAGE;
		query.append(String.format(LIMIT, (startPage), NUMBER_OF_RESULTS_PER_PAGE));

		return query.toString();
	}

	public static List<String> getSearchHelpers() {

		List<String> searchHelpers = new ArrayList<>();
		for (User user : userService.getUserNameAndPhone()) {

			searchHelpers.add(user.getName());
			searchHelpers.add(user.getPhoneNumber());
		}
		return searchHelpers;
	}

	public static void setAreaList(ModelMap model) {
		model.addAttribute("areaList", adminService.getAreaList());
	}

}
