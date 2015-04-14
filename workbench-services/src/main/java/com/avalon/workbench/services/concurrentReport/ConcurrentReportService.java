package com.avalon.workbench.services.concurrentReport;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface ConcurrentReportService {
	public String getConcurrentReport(String respName, String uname, String shortName, String concurrentName, ArrayList<String> params,String progname) throws WorkbenchServiceException, InterruptedException;
}
