package com.avalon.workbench.services.concurrentReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportParamsRepository;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportRepository;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("ConcurrentReportParamsServiceImpl")
public class ConcurrentReportParamsServiceImpl implements
		ConcurrentReportParamsService {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportParamsServiceImpl.class);

	@Autowired
	@Qualifier(value = "concurrentReportParamsRepositoryImpl")
	ConcurrentReportParamsRepository concurrentReportParamsRepository;

	public List<Parameters> getParams(String progName) throws WorkbenchServiceException {
		// TODO Auto-generated method stub
		try {
			
			
			//Added by  Mallik
			//For adding ' to treat as a String
			int i= 0,k = 0;

			while( (k = progName.indexOf("'",k)) != -1 ){
			progName = (progName.substring(i,k)).concat("'").concat(progName.substring(k));
			k+=2;
			}			
			
			return concurrentReportParamsRepository.getParams(progName);
		} catch (WorkbenchDataAccessException e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchServiceException(e);
		}
	}

}
