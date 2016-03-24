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
	public void insertData(User user);

	public List<User> getUserList();

	public void updateData(User user);

	public void deleteData(String id);

	public User getUser(String id);

}
