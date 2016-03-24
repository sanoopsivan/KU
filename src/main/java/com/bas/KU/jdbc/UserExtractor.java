/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class UserExtractor implements ResultSetExtractor<User>{

	public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {		    
			  User user = new User();  		    
			  user.setUserId(resultSet.getInt(1));  
	
			    
			  return user;  
	}

}
