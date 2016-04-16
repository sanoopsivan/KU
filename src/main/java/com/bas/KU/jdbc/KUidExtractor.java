/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;

/**
 * @author San
 *
 */
public class KUidExtractor implements ResultSetExtractor<KUid> {

	@Override
	public KUid extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		if (resultSet != null) {
			KUid kuid = new KUid();
			kuid.setId(resultSet.getInt("id"));
			kuid.setValue(resultSet.getString("value"));
			kuid.setFormat(resultSet.getString("format"));
			kuid.setKUid(kuid.getFormat(), kuid.getValue());
			return kuid;

		}
		return null;
	}

}
