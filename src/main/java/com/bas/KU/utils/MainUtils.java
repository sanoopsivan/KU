/**
 * 
 */
package com.bas.KU.utils;

/**
 * @author San
 *
 */
public class MainUtils {

	public static String getPage(String role) {
		switch (role) {
		case "admin":
			return "view";
		case "superadmin":
			return "view";
		case "unauthorized":
			return "login";
		default:
			return "login";
		}
	}

}
