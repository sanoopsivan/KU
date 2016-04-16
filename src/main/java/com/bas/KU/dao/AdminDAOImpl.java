package com.bas.KU.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bas.KU.jdbc.AdminRowMapper;
import com.bas.KU.jdbc.AreaRowMapper;
import com.bas.KU.jdbc.KUidExtractor;
import com.bas.KU.jdbc.KUidRowMapper;
import com.bas.KU.jdbc.UserRowMapper;
import com.bas.KU.models.Admin;
import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;
import com.bas.KU.models.User;

public class AdminDAOImpl implements AdminDAO {

	@Autowired
	DataSource dataSource;

	private static final String GET_ALL_ADMINS_QUERY = "select * from admin";
	private static final String GET_ADMIN_BY_USERNAME_AND_PASSWORD = "select * from admin where username= '%s' and password = '%s'";
	private static final String GET_ALL_AREAS = "select * from area";
	private static final String INSERT_NEW_AREA = "insert into area (areaName) values (?)";
	private static final String GET_LAST_KUID = "SELECT * FROM kuid ORDER BY id DESC LIMIT 1;";
	private static final String INSERT_NEW_KUID = "insert into kuid (format,value,KUid) values (? ,? ,?)";

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

	@Override
	public void insertArea(Area area) {
		String sql = INSERT_NEW_AREA;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { area.getAreaName() });

	}

	@Override
	public List<Area> getAreaList() {
		List<Area> areaList = new ArrayList<>();

		String sql = GET_ALL_AREAS;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		areaList = jdbcTemplate.query(sql, new AreaRowMapper());
		return areaList.isEmpty() ? null : areaList;
	}

	@Override
	public void deleteArea(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArea(Area admiarean) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<KUid> getKUidList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertKUid(KUid kuid) {
		String sql = INSERT_NEW_KUID;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { kuid.getFormat(), kuid.getValue(), kuid.getKUid() });

	}

	@Override
	public KUid getLastKuid() {
		List<KUid> kUidList = new ArrayList<KUid>();
		String sql = String.format(GET_LAST_KUID);
		// create database connection using spring jdbc template
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// retrieve the datas from db and map the result to admin
		kUidList = jdbcTemplate.query(sql, new KUidRowMapper());

		return kUidList.isEmpty() ? null : kUidList.get(0);
	}

}
