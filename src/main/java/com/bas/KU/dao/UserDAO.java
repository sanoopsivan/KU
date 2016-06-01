/**
 * 
 */
package com.bas.KU.dao;

import java.util.List;

import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public interface UserDAO {
	public void insertUser(User user);

	public List<User> getUserList();

	public void updateUser(User user);

	public void deleteData(String id);

	public User getUser(String id);

	public List<User> getUserList(int startLimit, int endLimit);

	public List<User> getUserList(String query);

	public List<User> getUserNameAndPhone();

}
