/**
 * 
 */
package com.bas.KU.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bas.KU.jdbc.UserRowMapper;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class UserDAOImpl implements UserDAO {

	private static final String INSERT_NEW_USER_QUERY = "INSERT INTO user (KUid,firstName,lastName,gender,email,address,phoneNumber,landlineNumber,areaCode,creationDate,activationDate,deactivationDate ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER_QUERY = "UPDATE user set firstName = ?,lastName = ?, gender = ?, email = ? ,address = ?,phoneNumber =? where user_id = ?";
	private static final String SELECT_ALL_USER_QUERY = "select * from user";
	private static final String SELECT_A_LIMIT_OF_USERS_QUERY = "select * from user limit %d";

	@Autowired
	DataSource dataSource;

	public void insertUser(User user) {
		String sql = INSERT_NEW_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql,
				new Object[] { user.getKUId(), user.getFirstName(), user.getLastName(), user.getGender(),
						user.getEmail(), user.getAddress(), user.getPhoneNumber(), user.getLandLineNumber(),
						user.getAreaCode(), user.getCreationDate(), null, null });

	}

	public List<User> getUserList() {
		List<User> userList = new ArrayList<>();

		String sql = SELECT_ALL_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.isEmpty() ? null : userList;
	}

	public void updateUser(User user) {
		String sql = UPDATE_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { user.getFirstName(), user.getLastName(), user.getGender(),
				user.getEmail(), user.getAddress(), user.getPhoneNumber() });

	}

	public void deleteData(String id) {
		// TODO Auto-generated method stub

	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserList(int limit) {
		List<User> userList = new ArrayList<>();

		String sql = String.format(SELECT_A_LIMIT_OF_USERS_QUERY, limit);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.isEmpty() ? null : userList;
	}

	public List<User> getUserList(String query) {
		List<User> userList = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(query, new UserRowMapper());
		return userList.isEmpty() ? null : userList;
	}

}
