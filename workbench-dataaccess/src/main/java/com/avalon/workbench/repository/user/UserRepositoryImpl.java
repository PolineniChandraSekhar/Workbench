package com.avalon.workbench.repository.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.user.User;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(UserRepositoryImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public User getUser(String uname) throws WorkbenchDataAccessException {
		// TODO Auto-generated method stub
		try {
			/*
			 * String sql =
			 * "SELECT user_id, user_name FROM fnd_user fu, per_all_people_f papf "
			 * + "WHERE papf.person_id = fu.employee_id " +
			 * "AND fu.user_name='"+uname+"' " +
			 * "AND SYSDATE BETWEEN fu.start_date " +
			 * "AND NVL (fu.end_date, SYSDATE) " +
			 * "AND SYSDATE BETWEEN papf.effective_start_date " +
			 * "AND NVL (papf.effective_end_date, SYSDATE ) ORDER BY 2";
			 */
			String sql = "SELECT usr.user_name, get_pwd.decrypt((SELECT (SELECT get_pwd.decrypt(fnd_web_sec.get_guest_username_pwd,usertable.encrypted_foundation_password) FROM DUAL) AS apps_password FROM fnd_user usertable WHERE usertable.user_name = (SELECT SUBSTR(fnd_web_sec.get_guest_username_pwd,1,INSTR(fnd_web_sec.get_guest_username_pwd,'/')- 1) FROM DUAL)),usr.encrypted_user_password) PASSWORD From Fnd_User Usr WHERE usr.user_name = '"
					+ uname + "'";
			LOG_R.info("Sql query===="+sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(User.class);
			List<User> result = jdbcTemplate.query(sql, rm);
			if (result != null && !result.isEmpty()) {
				return result.get(0);
			}
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
		return null;
	}
}
