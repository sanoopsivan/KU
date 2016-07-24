/**
 * 
 */
package com.bas.KU.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bas.KU.enums.AdminStatus;
import com.bas.KU.enums.UserStatus;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */
@Service
public class Scheduler {

	@Autowired
	public static UserService userService;

	public static UserService getUserService() {
		return userService;
	}

	public static void setUserService(UserService userService) {
		Scheduler.userService = userService;
	}

	public static AdminService getAdminService() {
		return adminService;
	}

	public static void setAdminService(AdminService adminService) {
		Scheduler.adminService = adminService;
	}

	@Autowired
	public static AdminService adminService;

	public static boolean initialized = false;

	public static void doValidateExpiryDates() {
		initialized = true;
		List<User> userList = userService.getUsersForStatusUpdation();
		for (User user : userList) {

			user.setStatus(UserStatus.EXPIRED.getStatus());
			userService.updateData(user);

		}
	}

}
