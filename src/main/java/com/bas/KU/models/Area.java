/**
 * 
 */
package com.bas.KU.models;

/**
 * @author San
 *
 */
public class Area {

	private int id;
	private String areaName;

	public Area(String areaName) {
		this.areaName = areaName;
	}

	public Area() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
