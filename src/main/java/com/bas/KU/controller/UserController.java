/**
 * 
 */
package com.bas.KU.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bas.KU.models.KUid;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.ThirdPartyService;
import com.bas.KU.services.UserService;

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
		user.setCreationDate(new Date());
		userService.insertData(user);
		thirdPartyService.sendMail();
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

	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	@ResponseBody
	public List<User> getUsers(ModelMap model) {
		System.out.println("Ajax worked");
		return userService.getUserList();
	}
}
