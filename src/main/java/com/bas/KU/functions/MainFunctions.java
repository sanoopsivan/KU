/**
 * 
 */
package com.bas.KU.functions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.bas.KU.constants.KUConstants;
import com.bas.KU.enums.AdminStatus;
import com.bas.KU.enums.UserStatus;
import com.bas.KU.models.Admin;
import com.bas.KU.models.KUid;
import com.bas.KU.models.Status;
import com.bas.KU.models.User;
import com.bas.KU.scheduler.Scheduler;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */
@Service
public class MainFunctions {
	
	private static final String QUERY 			= "select * from user";
	private static final String WHERE_CLAUSE 	= " where ";
	private static final String AND_CLAUSE		= " AND ";
	private static final String LIMIT 			= " LIMIT %d,%d";
	private static final String ORDER_BY_CLAUSE = " order by creationDate DESC";


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

	//FIXME
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
		if (StringUtils.isNotBlank(status) && !StringUtils.equalsIgnoreCase(status, KUConstants.DEFAULT_STATUS)) {
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
			query.append("(").append("creationDate >= '").append(MYSQLDateFormatter(startDate)).append("')");
		}
		if (StringUtils.isNotBlank(endDate)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("(").append("creationDate <= '").append(MYSQLDateFormatter(endDate)).append("')");
		}

		return query.toString();
	}

	//FIXME
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

	//FIXME
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

	public static boolean isSuperAdmin(ModelMap model) {
		if (model.containsAttribute("admin")) {
			Admin admin = (Admin) model.get("admin");
			if (StringUtils.equalsIgnoreCase(admin.getStatus(), AdminStatus.SUPERADMIN.getStatus()))
				return true;
		}
		return false;

	}

	private static String MYSQLDateFormatter(String date) {
		String[] splittedDate = date.split("-");
		String formattedDate = splittedDate[2] + "-" + splittedDate[1] + "-" + splittedDate[0];
		return formattedDate;
	}

	public static String MYSQLDateFormatter(Date date) {
		if (date != null)
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		return null;

	}

	public static String KUDateFormatter(String date) {
		if (StringUtils.isNotBlank(date)) {
			String[] splittedDate = date.split(" ");
			return MYSQLDateFormatter(splittedDate[0]);
		}
		return null;
	}

	public static List<User> filterData(List<User> userList) {
		List<User> filteredUserList = new ArrayList<>();
		for (User user : userList) {
			user.setCreationDate(KUDateFormatter(user.getCreationDate()));
			user.setActivationDate(KUDateFormatter(user.getActivationDate()));
			user.setDeactivationDate(KUDateFormatter(user.getDeactivationDate()));
			filteredUserList.add(user);
		}
		return filteredUserList;
	}

	public static void runSheduler() {
		if (!Scheduler.initialized) {
			Scheduler.doValidateExpiryDates();
		}
	}

}
