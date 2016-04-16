/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;
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

	public void insertArea(Area area);

	public List<Area> getAreaList();

	public void deleteArea(String id);

	public void updateArea(Area area);

	public List<KUid> getKUidList();

	public void insertKUid(KUid kuid);

	public KUid getLastKuid();

}
