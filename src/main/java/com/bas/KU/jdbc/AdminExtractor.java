/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bas.KU.models.Admin;
import com.bas.KU.models.User;

/**
 * @author San
 * This class extracts the admin detail from the db and convert it into a POJO
 *
 */
public class AdminExtractor implements ResultSetExtractor<Admin> {

	public Admin extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		// check if the result set is empty or not
		if (resultSet!=null) {
			Admin admin = new Admin();
			admin.setAdminId(resultSet.getInt("id"));
			admin.setUsername(resultSet.getString("username"));
			admin.setPassword(resultSet.getString("password"));
			admin.setStatus(resultSet.getString("status"));
			return admin;
		} else
			return null;
	}

}
