package com.avalon.workbench.repository.concurrentReport.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.TableValidationValue;
import com.avalon.workbench.beans.concurrntReport.ValidationType;
import com.avalon.workbench.repository.concurrentReport.ParamsValidationTypeRepository;
import com.avalon.workbench.repository.concurrentReport.QueryForTableValidationRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;

public class QueryForTableValidationRepositoryImplTest extends
		AbstractWorkbenchDataAccessTest {
	protected static final Logger LOG_R = Logger
			.getLogger(QueryForTableValidationRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "QueryForTableValidationRepositoryImpl")
	QueryForTableValidationRepository repository;

	@Test
	public void test_getParams_success() throws Exception {
		TableValidationValue val=repository.getValueForTableValidation("50540");
		LOG_R.info("type===" + val.getId_Column_Name());
		Assert.assertTrue(val.getId_Column_Name().equalsIgnoreCase("LOOKUP_CODE"));
	}

}
