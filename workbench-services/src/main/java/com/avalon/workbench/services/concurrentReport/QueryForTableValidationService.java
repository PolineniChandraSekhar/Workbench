package com.avalon.workbench.services.concurrentReport;

import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.TableValidationValue;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface QueryForTableValidationService {
	public TableValidationValue getValueForTableValidation(String valueSetId) throws WorkbenchServiceException;
}
