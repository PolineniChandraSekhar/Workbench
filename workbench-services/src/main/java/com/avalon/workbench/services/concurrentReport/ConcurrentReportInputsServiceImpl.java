package com.avalon.workbench.services.concurrentReport;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportInputsRepository;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("ConcurrentReportInputsServiceImpl")
public class ConcurrentReportInputsServiceImpl implements ConcurrentReportInputsService{
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportInputsServiceImpl.class);

	@Autowired
	@Qualifier(value = "ConcurrentReportInputsRepositoryImpl")
	ConcurrentReportInputsRepository concurrentReportInputsRepository;

	public Inputs getInputs(String concurrentName) throws WorkbenchServiceException {
		try {
			LOG_R.info("inside getInputs of service layer....");
			return concurrentReportInputsRepository.getInputs(concurrentName);
		} catch (WorkbenchDataAccessException e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchServiceException(e);
		}
	}

}
