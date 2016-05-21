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
	 public void deleteData(String id);  
	 public User getUser(String id);  
	 public void updateData(User user);  
	 public List<User> getUserList(int limit);
	 public List<User> getUserList(String query);
	 public List<User> getUserNameAndPhone();
}
