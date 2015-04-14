package com.avalon.workbench.repository.concurrentReport;

import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository
public interface ConcurrentReportInputsRepository {
	public Inputs getInputs(String concurrentName) throws WorkbenchDataAccessException;
}
