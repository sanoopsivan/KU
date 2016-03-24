/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bas.KU.dao.AdminDAO;
import com.bas.KU.models.Admin;

/**
 * @author San
 *
 */
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;

	public void insertData(Admin admin) {
		// TODO Auto-generated method stub

	}

	public void deleteData(String id) {
		// TODO Auto-generated method stub

	}

	public Admin getAdmin(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateData(Admin admin) {
		// TODO Auto-generated method stub

	}

	public Admin getAdmin(String username, String password) {
		return adminDAO.getAdmin(username, password);
	}

	public List<Admin> getAminList() {
		return adminDAO.getAdminList();
	}

	

}
