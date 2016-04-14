/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bas.KU.models.Area;
import com.bas.KU.models.User;

/**
 * @author San
 *
 */
public class AreaExtractor implements ResultSetExtractor<Area> {

	@Override
	public Area extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		if (resultSet != null) {
			Area area = new Area();
			area.setId(resultSet.getInt("id"));
			area.setAreaName(resultSet.getString("areaName"));
			return area;

		}
		return null;
	}

}
