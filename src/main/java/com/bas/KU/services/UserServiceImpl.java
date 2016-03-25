/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bas.KU.dao.UserDAO;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class UserServiceImpl implements UserService {
	
	@Autowired  
	 UserDAO userdao;  

	public void insertData(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userdao.getUserList();  
	}

	public void deleteData(String id) {
		// TODO Auto-generated method stub

	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateData(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUserList(int limit) {
		return userdao.getUserList(limit);
	}

}
