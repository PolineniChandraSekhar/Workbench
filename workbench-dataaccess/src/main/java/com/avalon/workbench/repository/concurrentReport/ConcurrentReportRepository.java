package com.avalon.workbench.repository.concurrentReport;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository
public interface ConcurrentReportRepository {
	public String generateConcurrentReport(String respName, String uname, String shortName,String concurrentName, Inputs inputs, ArrayList<String> params) throws WorkbenchDataAccessException;
	public void getConcurrentReport(String fileName) throws WorkbenchDataAccessException;
	public String getExecutionQuery(String fileName,String reqId);
}
