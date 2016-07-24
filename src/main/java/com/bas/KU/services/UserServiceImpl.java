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
		userdao.insertUser(user);

	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userdao.getUserList();
	}

	public void deleteUser(String id) {
		userdao.deleteUser(id);
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userdao.getUser(id);
	}

	public void updateData(User user) {
		userdao.updateUser(user);

	}

	public List<User> getUserList(int startLimit, int endLimit) {
		return userdao.getUserList(startLimit, endLimit);
	}

	public List<User> getUserList(String query) {
		return userdao.getUserList(query);
	}

	public List<User> getUserNameAndPhone() {
		return userdao.getUserNameAndPhone();
	}

	@Override
	public List<User> getUsersForStatusUpdation() {
		return userdao.getUsersForStatusUpdation();
	}

}
