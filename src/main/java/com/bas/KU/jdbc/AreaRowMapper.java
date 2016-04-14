/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bas.KU.models.Area;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class AreaRowMapper implements RowMapper<Area> {

	@Override
	public Area mapRow(ResultSet rs, int rowNum) throws SQLException {
		AreaExtractor areaExtractor = new AreaExtractor();
		return areaExtractor.extractData(rs);
	}

}
