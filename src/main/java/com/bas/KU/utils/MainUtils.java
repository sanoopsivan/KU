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
import com.bas.KU.models.SearchHelper;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */
public class MainUtils {

	@Autowired
	public AdminService adminService;

	@Autowired
	public UserService userService;

	private static final String QUERY = "select * from user";
	private static final String WHERE_CLAUSE = " where ";
	private static final String AND_CLAUSE = " AND ";

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

	public static String getQuery(String q, String area, String status, Date startDate, Date endDate) {
		boolean isWhereClauseAdded = false;
		StringBuilder query = new StringBuilder(QUERY);
		if (StringUtils.isBlank(q) && StringUtils.isBlank(area)
				&& (StringUtils.isBlank(status) || status.equalsIgnoreCase("ALL")) && startDate == null
				&& endDate == null)
			return query.toString();
		if (StringUtils.isNotBlank(q)) {
			query.append(WHERE_CLAUSE).append("firstName like '%").append(q).append("%' OR lastName like '%").append(q)
					.append("%' OR address like '%").append(q).append("%' OR phoneNumber like '%").append(q)
					.append("%'");
			isWhereClauseAdded = true;
		}
		if (StringUtils.isNotBlank(area)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("area like %").append(area).append("%");
		}
		if (StringUtils.isNotBlank(status)) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("status like %").append(status).append("%");
		}

		if (startDate != null && endDate != null) {
			if (isWhereClauseAdded)
				query.append(AND_CLAUSE);
			else {
				query.append(WHERE_CLAUSE);
				isWhereClauseAdded = true;
			}
			query.append("");
		}

		return query.toString();
	}

}
