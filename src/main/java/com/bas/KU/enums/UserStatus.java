/**
 * 
 */
package com.bas.KU.enums;

/**
 * @author San
 *
 */
public enum UserStatus {

	ACTIVATED("ACTIVATED", "ACTIVATED"), DE_ACTIVATED("DE_ACTIVATED",
			"DEACTIVATE"), PENDING_FOR_ACTIVATION("PENDING_FOR_ACTIVATION", "PENDING FOR ACTIVATION");
	private String userStatus;
	private String label;

	private UserStatus(String status, String label) {
		this.userStatus = status;
		this.label = label;
	}

	public String getStatus() {
		return userStatus;
	}

	public String getLabel() {
		return label;
	}

}
