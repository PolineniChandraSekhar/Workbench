package com.avalon.workbench.repository.concurrentReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.TableValidationValue;
import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository("QueryForTableValidationRepositoryImpl")
public class QueryForTableValidationRepositoryImpl implements
		QueryForTableValidationRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(QueryForTableValidationRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TableValidationValue getValueForTableValidation(String valueSetId)
			throws WorkbenchDataAccessException {
		try {
			String sql = "select ffvt.application_table_name, Ffvt.Value_Column_Name,Ffvt.Id_Column_Name,Ffvt.Additional_Where_Clause from Fnd_Flex_Validation_Tables ffvt where Flex_Value_Set_Id='"
					+ valueSetId + "'";
			LOG_R.info("inside getValidationType of DAO sql===" + sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(
					TableValidationValue.class);
			List<TableValidationValue> result = jdbcTemplate.query(sql, rm);
			return result.get(0);
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
	}
}
