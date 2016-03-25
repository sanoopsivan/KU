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

	@Autowired
	DataSource dataSource;

	public void insertData(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> getUserList() {
		List<User> userList = new ArrayList<>();

		String sql = "select * from user";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.isEmpty() ? null : userList;
	}

	public void updateData(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteData(String id) {
		// TODO Auto-generated method stub

	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
