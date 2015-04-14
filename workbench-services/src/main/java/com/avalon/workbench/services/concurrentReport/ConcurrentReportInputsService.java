package com.avalon.workbench.services.concurrentReport;

import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface ConcurrentReportInputsService {
	public Inputs getInputs(String concurrentName) throws WorkbenchServiceException;
}
