/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import com.bas.KU.models.Admin;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public interface AdminService {

	public void insertData(Admin admin);

	public List<Admin> getAminList();

	public void deleteData(String id);

	public Admin getAdmin(String id);

	public Admin getAdmin(String username, String password);

	public void updateData(Admin admin);

}
