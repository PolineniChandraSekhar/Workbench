package com.avalon.workbench.services.concurrentReport;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.concurrentReport.ParamsValidationTypeRepository;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("ParamsValidationTypeServiceImpl")
public class ParamsValidationTypeServiceImpl implements
		ParamsValidationTypeService {
	
	protected static final Logger LOG_R = Logger
			.getLogger(ParamsValidationTypeServiceImpl.class);

	@Autowired
	@Qualifier(value = "ParamsValidationTypeRepositoryImpl")
	ParamsValidationTypeRepository paramsValidationTypeRepository;
	
	@Autowired
	@Qualifier(value = "QueryForTableValidationServiceImpl")
	QueryForTableValidationService queryForTableValidationService;

	public ValidationType getValidationType(String valueSetName) throws WorkbenchServiceException {
		try {
			ValidationType type= paramsValidationTypeRepository.getValidationType(valueSetName);
			LOG_R.info("id==="+type.getFlex_value_set_id());
			if(type.getValidation_type().equalsIgnoreCase("Table")){
				queryForTableValidationService.getValueForTableValidation(type.getFlex_value_set_id());
			}else{
				//todo
			}
			return type;
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchServiceException(e);
		}
	}
}
