package com.avalon.workbench.repository.concurrentReport;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Repository("concurrentReportRepositoryImpl")
public class ConcurrentReportRepositoryImpl implements
		ConcurrentReportRepository {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String generateConcurrentReport(final String respName,
			final String uname, final String shortName,
			final String concurrentName, final Inputs inputs,
			final ArrayList<String> params) throws WorkbenchDataAccessException {
		try {
			CallableStatementCreator callableStatementCreator = new CallableStatementCreator() {

				public CallableStatement createCallableStatement(Connection con)
						throws SQLException {
					CallableStatement cs = con
							.prepareCall("{call Concurrent_Prog_Exec(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cs.setString(1, respName);
					cs.setString(2, uname);
					if (inputs != null) {
						cs.setString(3, inputs.getApplication_Short_Name());
						cs.setString(4, inputs.getTemplate_code());
						cs.setString(5, inputs.getDefault_Language());
						cs.setString(6, inputs.getDefault_Territory());
						if(inputs.getDefault_output_type()!= null)
						   cs.setString(7,inputs.getDefault_output_type() );
						else
							cs.setString(7,"PDF" );
					} else {
						cs.setString(3, null);
						cs.setString(4, null);
						cs.setString(5, null);
						cs.setString(6, null);
						cs.setString(7, null);
					}
					cs.setString(8, shortName);
					cs.setString(9, concurrentName);
					int k=10;
					for(int i=0;i<15;i++){
						if(i<params.size())
							if(params.get(i)!=null){
								LOG_R.info("if in not null");
								cs.setString(k, params.get(i));
							}
							else
								cs.setString(k, null);
						else {
							LOG_R.info("=--- Out else");
							 cs.setString(k, null);
						}
						k++;
						LOG_R.info("-=-=-=k is "+k);
					}
						
					
					
					
					//commented by Mallik @ 20-03-15
//					if (params != null) {
//						if(params.get(0)!=null)
//						cs.setString(10, params.get(0));
//						cs.setString(11, params.get(1));
//						cs.setString(12, params.get(2));
//						cs.setString(13, params.get(3));
//						cs.setString(14, params.get(4));
//						cs.setString(15, params.get(5));
//						cs.setString(16, params.get(6));
//						cs.setString(17, params.get(7));
//						cs.setString(18, params.get(8));
//						cs.setString(19, params.get(9));
//						cs.setString(20, params.get(10));
//						cs.setString(21, params.get(11));
//						cs.setString(22, params.get(12));		
//						cs.setString(23, params.get(13));
//						cs.setString(24, params.get(14));
//					} else {
//						cs.setString(10, null);
//						cs.setString(11, null);
//						cs.setString(12, null);
//						cs.setString(13, null);
//						cs.setString(14, null);
//						cs.setString(15, null);
//						cs.setString(16, null);
//						cs.setString(17, null);
//						cs.setString(18, null);
//						cs.setString(19, null);
//						cs.setString(20, null);
//						cs.setString(21, null);
//						cs.setString(22, null);
//						cs.setString(23, null);
//						cs.setString(24, null);
//					}
					cs.registerOutParameter(25, Types.INTEGER);
					return cs;
				}
			};
			List param = new ArrayList();
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlParameter(Types.VARCHAR));
			param.add(new SqlOutParameter("retVal", Types.INTEGER));
			String reqId = (String) jdbcTemplate
					.call(callableStatementCreator, param).get("retVal")
					.toString();
			if (reqId != null)
				return reqId;
			return "0";
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
	}

	public void getConcurrentReport(String fileName)
			throws WorkbenchDataAccessException {
		String hostname = "192.168.100.100";
		String username = "oracle";
		String password = "oracle";
		String copyFrom = "/oraAS/oracle/VIS/inst/apps/VIS_apps/logs/appl/conc/out/"
		//		+"APPPBR_5943927_1.PDF";
				+ fileName;
		LOG_R.info("Copyfrom===" + copyFrom);
		String copyTo = "D:/" + fileName;
		//String copyTo = "D:/" + "APPPBR_5943927_1.PDF";
		JSch jsch = new JSch();
		Session session = null;
		try {
			session = jsch.getSession(username, hostname, 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			LOG_R.info("inside getConcurrentReport--------Connected");
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			LOG_R.info("B4 copy");
			sftpChannel.get(copyFrom, copyTo);
			LOG_R.info("Aftr Copy");
			sftpChannel.exit();
			session.disconnect();
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchDataAccessException(e);
		}
	}
		
	public String getExecutionQuery(String progName,String reqId) {
	//jdbcTemplate.execute();
		try {	
	LOG_R.info("execution time----"+progName);
	String sql1 ="SELECT TO_CHAR ( TRUNC (SYSDATE)+ NUMTODSINTERVAL ( MAX ( (F.ACTUAL_COMPLETION_DATE - F.ACTUAL_START_DATE)) * 86400,'second'),'HH24:MI:SS')"
          
  +  " FROM APPLSYS.FND_CONCURRENT_REQUESTS F,APPLSYS.FND_CONCURRENT_PROGRAMS P, APPLSYS.FND_USER A,APPLSYS.FND_CONCURRENT_PROGRAMS_TL PT  WHERE     PHASE_CODE = 'C' "
       +"  AND STATUS_CODE = 'C'  AND F.CONCURRENT_PROGRAM_ID = P.CONCURRENT_PROGRAM_ID  AND P.CONCURRENT_PROGRAM_ID = PT.CONCURRENT_PROGRAM_ID"
      +"   AND A.USER_ID(+) = F.REQUESTED_BY and PT.USER_CONCURRENT_PROGRAM_NAME ='"+progName+"'"
      +" GROUP BY P.CONCURRENT_PROGRAM_NAME, PT.USER_CONCURRENT_PROGRAM_NAME" ;

	
	/*String sql1 ="SELECT"
	  +" TO_CHAR(ROUND(((sysdate-a.actual_start_date)*24*60*60/60),2))"	 
	+" FROM apps.fnd_concurrent_requests a,"
	 +" apps.fnd_concurrent_programs b,"
	  +"  apps.FND_CONCURRENT_PROGRAMS_TL c,"
	  +" apps.fnd_user d"
	+" WHERE a.concurrent_program_id=b.concurrent_program_id"
	+" AND b.concurrent_program_id  =c.concurrent_program_id"
	+" AND a.requested_by =d.user_id"
	+" AND (status_code ='R'  OR  status_code ='C')"
	+" AND a.request_id = '"+reqId+"'";
	*/
	
	LOG_R.info("query==" + sql1);	
	//BeanPropertyRowMapper rm1 = new BeanPropertyRowMapper();
	String result =(String) jdbcTemplate.queryForObject(sql1, String.class);
	if (result != null && !result.isEmpty())
	LOG_R.info("-=-=-=-=-=-="+result);
		return result;
	
	/*List<String> certs = jdbcTemplate.queryForList(sql1, String.class); 
    if (certs.isEmpty()) {
        return null;
    } else {
        return certs.get(0);
    }*/
	//return null;	
			} catch (Exception e) {
				LOG_R.error("Exception occured ::" + e);
				
		}
		return null;
	}// CLASS END
	
	
} // CLASS BODY END
