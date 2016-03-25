/**
 * 
 */
package com.bas.KU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author San
 *
 */

@Controller
public class UserController {

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id", required = false) String id) {
		return new ModelAndView("edit");
	}

}
