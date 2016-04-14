/**
 * 
 */
package com.bas.KU.dao;

import java.util.List;

import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;

/**
 * @author San
 *
 */
public interface AdminDAO {

	public void insertData(Admin admin);

	public List<Admin> getAdminList();

	public void updateData(Admin admin);

	public void deleteData(String id);

	public Admin getAdmin(String id);

	public Admin getAdmin(String username, String password);
	
	public void insertArea(Area area);
	
	public List<Area> getAreaList();
	
	public void deleteArea(String id);
	
	public void updateArea(Area area);
}
