package com.avalon.workbench.repository.concurrentReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository("ParamsValidationTypeRepositoryImpl")
public class ParamsValidationTypeRepositoryImpl implements
		ParamsValidationTypeRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(ParamsValidationTypeRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ValidationType getValidationType(String valueSetName)
			throws WorkbenchDataAccessException {
		try {
			String sql = "SELECT ffvs.flex_value_set_id,  ffvs.flex_value_set_name,  ffvs.description set_description ,  fl.meaning validation_type,  ffvt.value_column_name ,  ffvt.meaning_column_name ,  ffvt.id_column_name ,  ffvt.application_table_name ,  ffvt.additional_where_clause FROM apps.fnd_flex_value_sets ffvs ,  apps.fnd_flex_validation_tables ffvt,  apps.fnd_lookups fl WHERE ffvs.flex_value_set_id = ffvt.flex_value_set_id(+) AND ffvs.flex_value_set_name ='"
					+ valueSetName
					+ "' And Fl.Lookup_Type = 'SEG_VAL_TYPES' And Fl.Lookup_Code = Ffvs.Validation_Type";
			LOG_R.info("inside getValidationType of DAO sql===" + sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(
					ValidationType.class);
			List<ValidationType> result = jdbcTemplate.query(sql, rm);
			return result.get(0);
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
	}
}
