/**
 * 
 */
package com.bas.KU.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bas.KU.models.User;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam(value = "id", required = false) String id) {
		return "edit";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser() {
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

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);
		user.setAreaCode(areaCode);
		user.setLandLineNumber(landLineNumber);
		user.setPincode(pincode);
		user.setEmail("dsdfdf");
		user.setKUId("KUID05");
		user.setCreationDate(new Date());
		userService.insertData(user);
		return new ModelAndView("view");
	}
}
