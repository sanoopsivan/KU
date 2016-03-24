/**
 * 
 */
package com.bas.KU.utils;

/**
 * @author San
 *
 */
public class MainUtils {

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

}
