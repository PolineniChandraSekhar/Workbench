package com.avalon.workbench.repository.concurrentReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.beans.user.User;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository("concurrentReportParamsRepositoryImpl")
public class ConcurrentReportParamsRepositoryImpl implements
		ConcurrentReportParamsRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportParamsRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Parameters> getParams(String progName)
			throws WorkbenchDataAccessException {
		try {
			String sql = "SELECT  fdfcuv.column_seq_num ,fdfcuv.form_left_prompt , fdfcuv.enabled_flag ,        fdfcuv.required_flag ,        fdfcuv.display_flag ,        fdfcuv.flex_value_set_id ,        ffvs.flex_value_set_name ,       Fdfcuv.Default_Value       FROM        fnd_concurrent_programs fcp,        fnd_concurrent_programs_tl fcpl,        fnd_descr_flex_col_usage_vl fdfcuv,        Fnd_Flex_Value_Sets Ffvs,        Fnd_Lookup_Values Flv     WHERE        fcp.concurrent_program_id = fcpl.concurrent_program_id        AND    fcpl.user_concurrent_program_name = '"
					+ progName
					+ "'        AND    fdfcuv.descriptive_flexfield_name = '$SRS$.'                 || fcp.concurrent_program_name        AND    ffvs.flex_value_set_id = fdfcuv.flex_value_set_id        AND    flv.lookup_type(+) = 'FLEX_DEFAULT_TYPE'        AND    flv.lookup_code(+) = fdfcuv.default_type        AND    fcpl.LANGUAGE = USERENV ('LANG')        And    Flv.Language(+) = Userenv ('LANG')      ORDER BY fdfcuv.column_seq_num";
			LOG_R.info("sql===" + sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(
					Parameters.class);
			List<Parameters> result = jdbcTemplate.query(sql, rm);
			return result;
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
	}

}
