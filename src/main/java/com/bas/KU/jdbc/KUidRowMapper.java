/**
 * 
 */
package com.bas.KU.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bas.KU.models.Area;
import com.bas.KU.models.KUid;

/**
 * @author San
 *
 */
public class KUidRowMapper implements RowMapper<KUid> {

	@Override
	public KUid mapRow(ResultSet rs, int rowNum) throws SQLException {
		KUidExtractor kuidExtractor = new KUidExtractor();
		return kuidExtractor.extractData(rs);
	}

}
