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
 *
 */
public class UserExtractor implements ResultSetExtractor<User> {

	public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		if (resultSet != null) {
			User user = new User();
			user.setUserId(resultSet.getString("id"));
			user.setKUId(resultSet.getString("kUid"));
			user.setFirstName(resultSet.getString("firstName"));
			user.setLastName(resultSet.getString("lastName"));
			user.setEmail(resultSet.getString("email"));
			user.setAddress(resultSet.getString("address"));
			user.setPhoneNumber(resultSet.getString("phoneNumber"));
			user.setGender(resultSet.getString("gender"));
			user.setAreaCode(resultSet.getString("areaCode"));
			user.setLandLineNumber(resultSet.getString("landlineNumber"));
			user.setCreationDate(resultSet.getDate("creationDate"));
			user.setActivationDate(resultSet.getDate("activationDate"));
			user.setDeactivationDate(resultSet.getDate("deactivationDate"));
			return user;
		} else
			return null;

	}

}
