package com.avalon.workbench.service.mock.concurrentReport.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.services.concurrentReport.ConcurrentReportInputsService;
import com.avalon.workbench.services.test.AbstractWorkbenchServiceTest;

public class ConcurrentReportInputsServiceImplTest extends
		AbstractWorkbenchServiceTest {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportInputsServiceImplTest.class);
	
	@Autowired
	@Qualifier(value = "ConcurrentReportInputsServiceImpl")
	ConcurrentReportInputsService service;
	
	@Test
	public void test_getInputs_Success() throws Exception {
		Inputs inputs=service.getInputs("EMPLOYEE_INFORMATION");
		LOG_R.info("shortName===" + inputs.getApplication_Short_Name());
		Assert.assertTrue(inputs.getApplication_Short_Name().equalsIgnoreCase("po"));
	}
}
