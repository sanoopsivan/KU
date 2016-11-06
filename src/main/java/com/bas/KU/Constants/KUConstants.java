/**
 * 
 */
package com.bas.KU.constants;

import java.text.SimpleDateFormat;

/**
 * @author San
 *
 */
public interface KUConstants {

	public static final String ADMIN = "admin";
	// pages
	public static final String ADD_USER_PAGE = "addUser";
	public static final String LOGIN_PAGE = "login";
	public static final String VIEW_PAGE = "view";
	public static final String EDIT_USER_PAGE = "editUser";
	public static final String ADD_AREA_PAGE = "addArea";
	public static final String ADD_UNIQUE_ID = "addUniqueID";
	public static final String ADMIN_HOME = "adminHome";

	public static final String DEFAULT_STATUS = "ALL";
	public static final String SHOW_ALL_RESULTS = "ALL";
	public static final int NUMBER_OF_RESULTS_PER_PAGE = 3;
	public static final String DATE_FORMAT = "dd/mm/YYYY";
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

}
