/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class UserRowMapper implements RowMapper<User>{

	
	public User mapRow(ResultSet rs, int line) throws SQLException {
		 UserExtractor userExtractor = new UserExtractor();  
		  return userExtractor.extractData(rs);  
	}

}
