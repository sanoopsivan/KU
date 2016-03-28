/**
 * 
 */
package com.bas.KU.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bas.KU.models.User;
import com.bas.KU.services.UserService;

/**
 * @author San
 *
 */

@Controller
public class SearchController {
	
	private static final String  QUERY = "select * from user ";

	@Autowired
	UserService userservice;

	@RequestMapping("/ajax")
	public @ResponseBody List<User> Search(@RequestParam(value = "q", required = false) String q,
											@RequestParam(value = "area", required = false) String area,
											@RequestParam(value = "startDate", required = false) Date startDate,
											@RequestParam(value = "endDate", required = false) Date endDate,
											@RequestParam(value = "status", required = false) String status){
			
		List <User> searchResults = new ArrayList<>();
		StringBuilder query = new StringBuilder(QUERY);
		/*if(StringUtils.isNotBlank(q))
			query.append("where").append("user.firstName like ").append(q);
	*/
		searchResults = userservice.getUserList();
		return searchResults;
	}

}
