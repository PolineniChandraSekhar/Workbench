package com.avalon.workbench.repository.concurrentPrograms;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.repository.user.UserRepositoryImpl;

@Repository("ConcurrentProgramsRepositoryImpl")
public class ConcurrentProgramsRepositoryImpl implements
		ConcurrentProgramsRepository {

	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentProgramsRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ConcurrentPrograms> getConcurrentPrograms(String uname,
			String respNmae) throws WorkbenchDataAccessException {
		// TODO Auto-generated method stub
		try {
			LOG_R.info("inside getConcurrentPrograms----");
			String sql = "select distinct fu.user_name, p.user_concurrent_program_name, a.application_name, a.application_short_name, p.concurrent_program_name, p.concurrent_program_id, p.application_id "
					+ "from fnd_concurrent_programs_vl p, fnd_application_vl a, fnd_request_group_units u, fnd_responsibility_vl r, fnd_user fu "
					+ "where p.srs_flag in ('Y', 'Q') and p.enabled_flag = 'Y' and request_set_flag = 'N' and ((a.application_id = u.unit_application_id "
					+ "and u.application_id = r.group_application_id and u.request_group_id = r.request_group_id and u.request_unit_type = 'A') "
					+ "or (p.application_id = u.unit_application_id and p.concurrent_program_id = u.request_unit_id and u.application_id = r.group_application_id "
					+ "and u.request_group_id = r.request_group_id and u.request_unit_type = 'P')) and p.application_id = a.application_id "
					+ "and r.responsibility_name='"
					+ respNmae
					+ "' and fu.user_name='" + uname + "' order by 1,2,4";
			LOG_R.info("query==" + sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(
					ConcurrentPrograms.class);
			List<ConcurrentPrograms> result = jdbcTemplate.query(sql, rm);
			return result;
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}

	}
}
