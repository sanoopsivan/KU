/**
 * 
 */
package com.bas.KU.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bas.KU.enums.UserStatus;
import com.bas.KU.jdbc.AdminRowMapper;
import com.bas.KU.jdbc.UserRowMapper;
import com.bas.KU.models.Admin;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class UserDAOImpl implements UserDAO {

	private static final String INSERT_NEW_USER_QUERY = "INSERT INTO user (KUid,firstName,lastName,name,gender,email,address,phoneNumber,landlineNumber,areaCode,status,comment,creationDate,activationDate,deactivationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
	private static final String UPDATE_USER_QUERY = "UPDATE user set firstName = ?,lastName = ?, name=?, gender = ?, email = ? ,address = ?,phoneNumber =?,landlineNumber =?,areaCode =?,status =?,comment =?,activationDate =?,deactivationDate=? where id = ?";
	private static final String SELECT_ALL_USER_QUERY = "select * from user";
	private static final String SELECT_A_LIMIT_OF_USERS_QUERY = "select * from user limit %d,%d";
	private static final String SELECT_NAME_AND_PHONE_OF_ALLUSERS_QUERY = "SELECT name,phoneNumber FROM user";
	private static final String SELECT_USER_BY_ID = "select * from user where id = '%s'";
	private static final String DELETE_USER_BY_ID = "DELETE FROM user where id ='%s'";
	private static final String SELECT_ALL_USER_FOR_STATUS_UPDATION = "select * from user where status = '%s' and deactivationDate <= CURDATE()";

	@Autowired
	DataSource dataSource;

	public void insertUser(User user) {
		String sql = INSERT_NEW_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql,
				new Object[] { user.getKUId(), user.getFirstName(), user.getLastName(), user.getName(),
						user.getGender(), user.getEmail(), user.getAddress(), user.getPhoneNumber(),
						user.getLandLineNumber(), user.getAreaCode(), user.getStatus(), user.getComment(),
						user.getCreationDate(), null, null });

	}

	public List<User> getUserList() {
		List<User> userList = new ArrayList<>();

		String sql = SELECT_ALL_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	public void updateUser(User user) {
		String sql = UPDATE_USER_QUERY;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql,
				new Object[] { user.getFirstName(), user.getLastName(), user.getName(), user.getGender(),
						user.getEmail(), user.getAddress(), user.getPhoneNumber(), user.getLandLineNumber(),
						user.getAreaCode(), user.getStatus(), user.getComment(), user.getActivationDate(),
						user.getDeactivationDate(), user.getUserId() });

	}

	public void deleteUser(String id) {
		String sql = String.format(DELETE_USER_BY_ID, id);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	public User getUser(String id) {

		List<User> userList = new ArrayList<User>();
		String sql = String.format(SELECT_USER_BY_ID, id);
		// create database connection using spring jdbc template
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// retrieve the datas from db and map the result to admin
		userList = jdbcTemplate.query(sql, new UserRowMapper());

		return userList.isEmpty() ? null : userList.get(0);
	}

	public List<User> getUserList(int startLimit, int endLimit) {
		List<User> userList = new ArrayList<>();

		String sql = String.format(SELECT_A_LIMIT_OF_USERS_QUERY, startLimit, endLimit);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	public List<User> getUserList(String query) {
		List<User> userList = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(query, new UserRowMapper());
		return userList;
	}

	public List<User> getUserNameAndPhone() {
		List<User> userList = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(SELECT_NAME_AND_PHONE_OF_ALLUSERS_QUERY, new UserRowMapper());
		return userList;
	}

	public List<User> getUsersForStatusUpdation() {
		List<User> userList = new ArrayList<>();
		String sql = String.format(SELECT_ALL_USER_FOR_STATUS_UPDATION, UserStatus.ACTIVATED.getStatus());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

}
