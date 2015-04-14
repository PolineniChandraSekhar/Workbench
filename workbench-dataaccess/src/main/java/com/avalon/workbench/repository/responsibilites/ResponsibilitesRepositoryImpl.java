package com.avalon.workbench.repository.responsibilites;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.repository.user.UserRepositoryImpl;

@Repository("ResponsibilitesRepositoryImpl")
public class ResponsibilitesRepositoryImpl implements ResponsibilitesRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(ResponsibilitesRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Responsibilites> getResonsibilites(String uname) throws WorkbenchDataAccessException {
		// TODO Auto-generated method stub
		try {
			LOG_R.info("inside getResponsibilities----");
			String sql = "SELECT fu.user_name,frt.responsibility_name,furg.start_date,furg.end_date,fr.responsibility_key,fa.application_short_name"
					+ " FROM fnd_user_resp_groups_direct furg,applsys.fnd_user fu,applsys.fnd_responsibility_tl frt,applsys.fnd_responsibility fr,applsys.fnd_application_tl fat,applsys.fnd_application fa "
					+ "WHERE furg.user_id =  fu.user_id AND furg.responsibility_id = frt.responsibility_id AND fr.responsibility_id = frt.responsibility_id  "
					+ "AND fa.application_id = fat.application_id AND fr.application_id = fat.application_id "
					+ "AND frt.language =  USERENV('LANG') AND UPPER(fu.user_name) =  UPPER('"+uname+"')  -- <change it> -- "
					+ "AND (furg.end_date IS NULL OR furg.end_date >= TRUNC(SYSDATE)) ORDER BY frt.responsibility_name;";
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(
					Responsibilites.class);
			List<Responsibilites> result = jdbcTemplate.query(sql, rm);
			if (result != null && !result.isEmpty()) {
				return result;
			}
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
		return null;

	}

}
