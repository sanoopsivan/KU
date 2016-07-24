/**
 * 
 */
package com.bas.KU.services;

import java.util.List;

import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public interface UserService {

	public void insertData(User user);

	public List<User> getUserList();

	public void deleteUser(String id);

	public User getUser(String id);

	public void updateData(User user);

	public List<User> getUserList(int startLimit, int endLimit);

	public List<User> getUserList(String query);

	public List<User> getUserNameAndPhone();

	public List<User> getUsersForStatusUpdation();
}
