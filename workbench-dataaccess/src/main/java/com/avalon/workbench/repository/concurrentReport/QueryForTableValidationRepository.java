package com.avalon.workbench.repository.concurrentReport;

import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.TableValidationValue;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository
public interface QueryForTableValidationRepository {
	public TableValidationValue getValueForTableValidation(String valueSetId) throws WorkbenchDataAccessException;
}
