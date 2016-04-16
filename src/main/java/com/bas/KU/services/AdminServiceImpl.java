/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bas.KU.dao.AdminDAO;
import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;

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

	@Override
	public void insertArea(Area area) {
		adminDAO.insertArea(area);

	}

	@Override
	public List<Area> getAreaList() {
		return adminDAO.getAreaList();
	}

	@Override
	public void deleteArea(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArea(Area area) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<KUid> getKUidList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertKUid(KUid kuid) {
		adminDAO.insertKUid(kuid);

	}

	@Override
	public KUid getLastKuid() {
		return adminDAO.getLastKuid();
	}

}
