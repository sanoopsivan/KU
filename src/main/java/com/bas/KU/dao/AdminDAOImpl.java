package com.bas.KU.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bas.KU.jdbc.AdminRowMapper;
import com.bas.KU.models.Admin;

public class AdminDAOImpl implements AdminDAO {

	@Autowired
	DataSource dataSource;

	private static final String GET_ALL_ADMINS_QUERY = "select * from admin";
	private static final String GET_ADMIN_BY_USERNAME_AND_PASSWORD = "select * from admin where username= '%s' and password = '%s'";

	public void insertData(Admin admin) {
	};

	public List<Admin> getAdminList() {
		List<Admin> adminList = new ArrayList<Admin>();
		String sql = GET_ALL_ADMINS_QUERY;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminList = jdbcTemplate.query(sql, new AdminRowMapper());
		return adminList;
	};

	public void updateData(Admin admin) {
	};

	public void deleteData(String id) {
	};

	public Admin getAdmin(String id) {
		return null;
	};

	public Admin getAdmin(String username, String password) {
		List<Admin> adminList = new ArrayList<Admin>();
		String sql = String.format(GET_ADMIN_BY_USERNAME_AND_PASSWORD, username, password);
		// create database connection using spring jdbc template
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// retrieve the datas from db and map the result to admin
		adminList = jdbcTemplate.query(sql, new AdminRowMapper());

		return adminList.isEmpty() ? null : adminList.get(0);
	}

}
