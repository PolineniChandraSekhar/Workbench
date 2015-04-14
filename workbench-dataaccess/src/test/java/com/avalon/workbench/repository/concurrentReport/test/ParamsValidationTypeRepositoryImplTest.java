package com.avalon.workbench.repository.concurrentReport.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.concurrentReport.ParamsValidationTypeRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;

public class ParamsValidationTypeRepositoryImplTest extends
		AbstractWorkbenchDataAccessTest {
	protected static final Logger LOG_R = Logger
			.getLogger(concurrentReportParamsRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "ParamsValidationTypeRepositoryImpl")
	ParamsValidationTypeRepository repository;

	@Test
	public void test_getParams_success() throws Exception {
		ValidationType val=repository.getValidationType("Employee_Information1");
		LOG_R.info("type===" + val.getValidation_type());
		Assert.assertTrue(val.getValidation_type().equalsIgnoreCase("Table"));
	}

}
