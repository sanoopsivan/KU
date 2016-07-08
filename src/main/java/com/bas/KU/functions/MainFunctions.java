/**
 * 
 */
package com.bas.KU.functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bas.KU.enums.AdminStatus;
import com.bas.KU.enums.UserStatus;
import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;
import com.bas.KU.models.SearchParams;
import com.bas.KU.models.Status;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */
@Service

public class MainFunctions {
	private static final String DEFAULT_STATUS = "ALL";
	public static final String SHOW_ALL_RESULTS = "ALL";
	public static final int NUMBER_OF_RESULTS_PER_PAGE = 3;
	private static final String DATE_FORMAT = "YYYY-MM-DD";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Autowired
	public static UserService userService;
	@Autowired
	public static AdminService adminService;

	public static void setAdminService(AdminService adminService) {
		MainFunctions.adminService = adminService;
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
	private static final String ORDER_BY_CLAUSE = " order by creationDate DESC";

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

	public static String getQuery(String q, String area, String status, String startDate, String endDate) {
		boolean isWhereClauseAdded = false;
		StringBuilder query = new StringBuilder(QUERY);
		if (StringUtils.isBlank(q) && StringUtils.isBlank(area)
				&& (StringUtils.isBlank(status) || status.equalsIgnoreCase("ALL")) && startDate == null
				&& endDate == null)
			return query.toString();
		if (StringUtils.isNotBlank(q)) {
			query.append(WHERE_CLAUSE).append("(").append("firstName like '").append(q).append("%' OR lastName like '")
					.append(q).append("%' OR name like '").append(q).append("%' OR phoneNumber like '").append(q)
					.append("%'").append(")");
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
			query.append("(").append("creationDate > '").append(startDate).append("')");
		}
		if (StringUtils.isNotBlank(endDate)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("creationDate < '").append(endDate).append("')");
		}

		return query.toString();
	}

	public static String getQueryWithPagination(String query, int page, int paginationHelper) {
		page = page - 1;
		StringBuilder queryWithPagination = new StringBuilder(query);
		int startPage = 0;
		if (page != 0)
			startPage = paginationHelper * page;
		// int endPage = startPage + NUMBER_OF_RESULTS_PER_PAGE;
		queryWithPagination.append(ORDER_BY_CLAUSE);
		queryWithPagination.append(String.format(LIMIT, (startPage), paginationHelper));

		return queryWithPagination.toString();
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

	public static void setUserKUID(User user) {
		KUid kuid = adminService.getLastKuid();
		user.setKUId(kuid.getKUid());
		kuid.setValue(setNextKUID(kuid.getValue()));
		kuid.setKUid(kuid.getFormat(), kuid.getValue());
		adminService.insertKUid(kuid);
	}

	public static String setNextKUID(String currentIDValue) {
		int value = Integer.parseInt(currentIDValue) + 1;
		return Integer.toString(value);
	}

	public static Status getStatusOf(UserStatus userStatus) {
		Status status = new Status();
		status.setLabel(userStatus.getLabel());
		status.setValue(userStatus.getStatus());
		return status;
	}

	// set the model
	public static ModelMap setModel(ModelMap model, Admin admin) {
		if (admin != null) {
			model.addAttribute("admin", admin);
		}
		return model;
	}

	public static void removeAdminSessionAttributeFromModel(ModelMap model) {
		if (model.containsAttribute("admin"))
			model.remove("admin");
	}

	public static boolean checkSessionExists(ModelMap model) {
		if (model.containsAttribute("admin"))
			MainFunctions.getPage(AdminStatus.UNAUTHORISED.getStatus());
		return true;

	}

	public static boolean isSuperAdmin(ModelMap model) {
		if (model.containsAttribute("admin")) {
			Admin admin = (Admin) model.get("admin");
			if (StringUtils.equalsIgnoreCase(admin.getStatus(), AdminStatus.SUPERADMIN.getStatus()))
				return true;
		}
		return false;

	}

}
