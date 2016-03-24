/**
 * 
 */
package com.bas.KU.enums;

/**
 * @author San
 *
 */
public enum AdminStatus {

	ADMIN("admin"), SUPERADMIN("superadmin"),UNAUTHORISED("unauthorised");

	private String adminStatus;

	private AdminStatus(String status) {
		this.adminStatus = status;
	}

	public String getStatus() {
		return adminStatus;
	}

}
