/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int numberOfColumns = resultSetMetaData.getColumnCount();
			User user = new User();
			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = resultSetMetaData.getColumnName(i);
				// Get the name of the column's table name
				switch (columnName) {
				case "id":
					user.setUserId(resultSet.getString("id"));
					break;
				case "kUid":
					user.setKUId(resultSet.getString("kUid"));
					break;
				case "firstName":
					user.setFirstName(resultSet.getString("firstName"));
					break;
				case "lastName":
					user.setLastName(resultSet.getString("lastName"));
					break;
				case "email":
					user.setEmail(resultSet.getString("email"));
					break;
				case "phoneNumber":
					user.setPhoneNumber(resultSet.getString("phoneNumber"));
					break;
				case "gender":
					user.setGender(resultSet.getString("gender"));
					break;
				case "areaCode":
					user.setAreaCode(resultSet.getString("areaCode"));
					break;
				case "landlineNumber":
					user.setLandLineNumber(resultSet.getString("landlineNumber"));
					break;
				default:
					System.out.println("Unknown Column");
					break;

				}
				user.setName(user.getFirstName(), user.getLastName());
			}

			/*
			 * user.setCreationDate(resultSet.getDate("creationDate"));
			 * user.setActivationDate(resultSet.getDate("activationDate"));
			 * user.setDeactivationDate(resultSet.getDate("deactivationDate"));
			 */
			return user;
		} else
			return null;

	}

}
