/**
 * 
 */
package com.bas.KU.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bas.KU.enums.UserStatus;
import com.bas.KU.models.KUid;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.ThirdPartyService;
import com.bas.KU.services.UserService;
import com.bas.KU.utils.MainUtils;

/**
 * @author San
 *
 */

@Controller
public class UserController {

	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@Autowired
	ThirdPartyService thirdPartyService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam(value = "id", required = false) String id) {
		return "edit";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		model.addAttribute("areaList", adminService.getAreaList());
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "landLineNumber", required = false) String landLineNumber,
			@RequestParam(value = "pincode", required = false) String pincode,
			@RequestParam(value = "email", required = false) String email) {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		user.setAreaCode(areaCode);
		user.setLandLineNumber(landLineNumber);
		user.setPincode(pincode);
		user.setEmail(email);
		setUserKUID(user);
		user.setStatus(UserStatus.PENDING_FOR_ACTIVATION.getStatus());
		user.setCreationDate(new Date());
		user.setName(firstName, lastName);
		userService.insertData(user);
		// thirdPartyService.sendMail();
		// thirdPartyService.sendSMS();
		return new ModelAndView("view");
	}

	private void setUserKUID(User user) {
		KUid kuid = adminService.getLastKuid();
		user.setKUId(kuid.getKUid());
		kuid.setValue(setNextKUID(kuid.getValue()));
		kuid.setKUid(kuid.getFormat(), kuid.getValue());
		adminService.insertKUid(kuid);
	}

	private String setNextKUID(String currentIDValue) {
		int value = Integer.parseInt(currentIDValue) + 1;
		return Integer.toString(value);
	}

	/*
	 * @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public List<User> getUsers(ModelMap
	 * model, @RequestParam(value = "q", required = false) String q,
	 * 
	 * @RequestParam(value = "datetimepicker_1", required = false) String
	 * datetimepicker_1,
	 * 
	 * @RequestParam(value = "datetimepicker_2", required = false) String
	 * datetimepicker_2,
	 * 
	 * @RequestParam(value = "searchCustomerByStatus", required = false) String
	 * searchCustomerByStatus) { System.out.println("Ajax worked");
	 * System.out.println(q); System.out.println(datetimepicker_1);
	 * System.out.println(datetimepicker_2);
	 * System.out.println(searchCustomerByStatus); return
	 * userService.getUserList(); }
	 */
	@RequestMapping("/view/{id}/editUser")
	public String getUserIdFromURL(@PathVariable(value = "id") String id, ModelMap model) {
		System.out.println(id);
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		MainUtils.setAreaList(model);
		return "editUser";
	}

	@RequestMapping("/view/{id}/updateUser")
	public String updateUser(@PathVariable(value = "id") String id, ModelMap model,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "landLineNumber", required = false) String landLineNumber,
			@RequestParam(value = "pincode", required = false) String pincode,
			@RequestParam(value = "email", required = false) String email) {
		User user = userService.getUser(id);
		if (StringUtils.isNotBlank(firstName))
			user.setFirstName(firstName);
		if (StringUtils.isNotBlank(lastName))
			user.setLastName(lastName);
		if (StringUtils.isNotBlank(landLineNumber))
			user.setLandLineNumber(landLineNumber);
		if (StringUtils.isNotBlank(gender))
			user.setGender(gender);
		if (StringUtils.isNotBlank(address))
			user.setAddress(address);
		if (StringUtils.isNotBlank(pincode))
			user.setPincode(pincode);
		if (StringUtils.isNotBlank(email))
			user.setEmail(email);
		userService.updateData(user);
		return "redirect:/view/" + user.getUserId() + "/editUser";
	}
}
