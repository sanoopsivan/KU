/**
 * 
 */
package com.bas.KU.enums;

/**
 * @author San
 *
 */
public enum UserStatus {

	ACTIVATED("ACTIVATED"), DE_ACTIVATED("DE_ACTIVATED"), PENDING_FOR_ACTIVATION("PENDING_FOR_ACTIVATION");
	private String userStatus;

	private UserStatus(String status) {
		this.userStatus = status;
	}

	public String getStatus() {
		return userStatus;
	}

}
