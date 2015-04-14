package com.avalon.workbench.repository.concurrentReport;

import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository
public interface ParamsValidationTypeRepository {
	public ValidationType getValidationType(String valueSetName) throws WorkbenchDataAccessException;
}
