package com.avalon.workbench.services.concurrentReport;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface ParamsValidationTypeService {
	public ValidationType getValidationType(String valueSetName) throws WorkbenchServiceException;
}
