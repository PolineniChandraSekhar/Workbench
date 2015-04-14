package com.avalon.workbench.service.mock.concurrentReport.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.services.concurrentReport.ParamsValidationTypeService;
import com.avalon.workbench.services.test.AbstractWorkbenchServiceTest;

public class ParamsValidationTypeServiceImplTest extends
		AbstractWorkbenchServiceTest {

	protected static final Logger LOG_R = Logger
			.getLogger(ParamsValidationTypeServiceImplTest.class);

	@Autowired()
	@Qualifier(value = "ParamsValidationTypeServiceImpl")
	ParamsValidationTypeService service;

	@Test
	public void test_getConcurrentReport_Success() throws Exception {
		ValidationType val=service.getValidationType("Employee_Information1");
		LOG_R.info("type===" + val.getValidation_type());
		Assert.assertTrue(val.getValidation_type().equalsIgnoreCase("Table"));
	}

}
