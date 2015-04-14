package com.avalon.workbench.service.mock.concurrentReport.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.services.concurrentReport.ConcurrentReportParamsService;
import com.avalon.workbench.services.test.AbstractWorkbenchServiceTest;

public class ConcurrentReportParamsServiceImplTest extends
		AbstractWorkbenchServiceTest {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportServiceImplTest.class);
	
	@Autowired
	@Qualifier(value = "ConcurrentReportParamsServiceImpl")
	ConcurrentReportParamsService service;
	
	@Test
	public void test_runConcurrentProgram_Success() throws Exception {
		List<Parameters> params=service.getParams("Employee_information");
		LOG_R.info("param==="+params.get(0).getPrompt());
		Assert.assertTrue(params.get(0).getPrompt().equalsIgnoreCase("Emp Number"));
	}
}
