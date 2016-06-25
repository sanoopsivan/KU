/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bas.KU.models.Admin;
import com.bas.KU.models.User;

/**
 * @author San This class acts as front door to call its extractor
 *
 */
public class AdminRowMapper implements RowMapper<Admin> {

	public Admin mapRow(ResultSet resultSet, int arg1) throws SQLException {
		AdminExtractor adminExtractor = new AdminExtractor();
		return adminExtractor.extractData(resultSet);
	}

}
