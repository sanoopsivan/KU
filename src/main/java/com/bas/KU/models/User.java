/**
 * 
 */
package com.bas.KU.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bas.KU.functions.MainFunctions;

/**
 * @author San
 *
 */
public class User {
	private String userId;
	private String KUId;
	private String name;
	private String status;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String phoneNumber;
	private String email;
	private String creationDate;
	private String areaCode;
	private String landLineNumber;
	private String pincode;
	private String activationDate;
	private String deactivationDate;
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getKUId() {
		return KUId;
	}

	public void setKUId(String KUId) {
		this.KUId = KUId;
	}

	public String getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		this.activationDate = sf.format(activationDate);
	}

	public void setActivationDate(Date activationDate, boolean val) {
		if (activationDate != null) {
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			this.activationDate = sf.format(activationDate);
		}
	}

	public String getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		this.deactivationDate = sf.format(deactivationDate);
	}

	public void setDeactivationDate(Date deactivationDate, boolean val) {
		if (activationDate != null) {
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			this.deactivationDate = sf.format(deactivationDate);
		}
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate, boolean val) {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		this.creationDate = sf.format(creationDate);
	}

	public void setCreationDate(Date creationDate) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		this.creationDate = sf.format(creationDate);
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emial) {
		this.email = emial;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String firstName, String lastName) {
		StringBuilder name = new StringBuilder(firstName);
		this.name = name.append(" ").append(lastName).toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
