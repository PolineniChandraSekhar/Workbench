package com.avalon.workbench.services.concurrentReport;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.TableValidationValue;
import com.avalon.workbench.repository.concurrentReport.ParamsValidationTypeRepository;
import com.avalon.workbench.repository.concurrentReport.QueryForTableValidationRepository;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("QueryForTableValidationServiceImpl")
public class QueryForTableValidationServiceImpl implements
		QueryForTableValidationService {
	
	protected static final Logger LOG_R = Logger
			.getLogger(QueryForTableValidationServiceImpl.class);

	@Autowired
	@Qualifier(value = "QueryForTableValidationRepositoryImpl")
	QueryForTableValidationRepository queryForTableValidationRepository;

	public TableValidationValue getValueForTableValidation(String valueSetId) throws WorkbenchServiceException {
		// TODO Auto-generated method stub
		try{
		return queryForTableValidationRepository.getValueForTableValidation(valueSetId);
	}catch(Exception e){
		LOG_R.error("Exception occured ::" + e);
		throw new WorkbenchServiceException(e);
	}

}
}
