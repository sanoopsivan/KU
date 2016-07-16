/**
 * 
 */
package com.bas.KU.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bas.KU.enums.AdminStatus;
import com.bas.KU.enums.UserStatus;
import com.bas.KU.functions.MainFunctions;
import com.bas.KU.models.Admin;
import com.bas.KU.models.User;
import com.bas.KU.services.AdminService;
import com.bas.KU.services.ThirdPartyService;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */

@Controller
@SessionAttributes("admin")
public class UserController {

	private static final String DATE_FORMAT = "dd/mm/yyyy";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@Autowired
	ThirdPartyService thirdPartyService;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect:/login";
		}
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
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "comment", required = false) String comment) {

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
		MainFunctions.setUserKUID(user);
		user.setStatus(UserStatus.PENDING_FOR_ACTIVATION.getStatus());
		user.setCreationDate(MainFunctions.MYSQLDateFormatter(new Date()));
		user.setComment(comment);
		user.setName(firstName, lastName);
		userService.insertData(user);
		// thirdPartyService.sendMail();
		// thirdPartyService.sendSMS();
		return new ModelAndView("view");
	}

	// Handles the edit user action
	@RequestMapping(value = "/view/{id}/editUser", method = RequestMethod.GET)
	public String getUserIdFromURL(@PathVariable(value = "id") String id, ModelMap model) {
		if (!model.containsAttribute("admin")) {
			return "redirect:/login";
		}
		System.out.println(id);
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		MainFunctions.KUDateFormatter(user.getCreationDate());
		MainFunctions.setAreaList(model);
		return "editUser";
	}

	// Handle the update use action
	@RequestMapping(value = "/view/{id}/updateUser", method = RequestMethod.POST)
	public String updateUser(@PathVariable(value = "id") String id, ModelMap model,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "landLineNumber", required = false) String landLineNumber,
			@RequestParam(value = "pincode", required = false) String pincode,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "activationDate", required = false) Date activationDate,
			@RequestParam(value = "deactivationDate", required = false) Date deactivationDate) {
		System.out.println("1");

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
		if (StringUtils.isNotBlank(areaCode))
			user.setAreaCode(areaCode);
		if (StringUtils.isNotBlank(status))
			user.setStatus(status);
		if (StringUtils.isNotBlank(comment))
			user.setComment(comment);
		if (activationDate != null)
			user.setActivationDate(MainFunctions.MYSQLDateFormatter(activationDate));
		if (deactivationDate != null)
			user.setDeactivationDate(MainFunctions.MYSQLDateFormatter(deactivationDate));
		user.setName(user.getFirstName(), user.getLastName());
		userService.updateData(user);
		// redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/view/" + user.getUserId() + "/editUser";
	}

	// Handle the update use action
	@RequestMapping(value = "/view/{id}/activateUser", method = RequestMethod.POST)
	public String activateUser(@PathVariable(value = "id") String id, ModelMap model,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "landLineNumber", required = false) String landLineNumber,
			@RequestParam(value = "pincode", required = false) String pincode,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "comment", required = false) String comment) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 2);

		// redirectAttributes.addFlashAttribute("user", user);
		return updateUser(id, model, firstName, lastName, gender, address, areaCode, landLineNumber, pincode, email,
				UserStatus.ACTIVATED.getStatus(), comment, new Date(), c.getTime());
	}

	// Handle the update use action
	@RequestMapping(value = "/view/{id}/deactivateUser", method = RequestMethod.POST)
	public String deactivateUser(@PathVariable(value = "id") String id, ModelMap model,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "areaCode", required = false) String areaCode,
			@RequestParam(value = "landLineNumber", required = false) String landLineNumber,
			@RequestParam(value = "pincode", required = false) String pincode,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "comment", required = false) String comment) {

		// redirectAttributes.addFlashAttribute("user", user);
		return updateUser(id, model, firstName, lastName, gender, address, areaCode, landLineNumber, pincode, email,
				UserStatus.PENDING_FOR_ACTIVATION.getStatus(), comment, null, null);
	}

	// Handle the update use action
	@RequestMapping(value = "/view/{id}/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@PathVariable(value = "id") String id, ModelMap model) {

		userService.deleteUser(id);
		return "redirect:/view";
	}
}
