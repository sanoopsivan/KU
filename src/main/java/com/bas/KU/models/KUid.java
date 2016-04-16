/**
 * 
 */
package com.bas.KU.models;

/**
 * @author San
 *
 */
public class KUid {

	private int id;
	private String format;
	private String value;
	private String KUid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKUid() {
		return KUid;
	}

	public void setKUid(String format, String value) {
		KUid = format + value;
	}

}
