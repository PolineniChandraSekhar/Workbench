package com.avalon.workbench.repository.concurrentReport.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportInputsRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;

public class concurrentReportInputsRepositoryImplTest extends
AbstractWorkbenchDataAccessTest{
	protected static final Logger LOG_R = Logger
			.getLogger(concurrentReportInputsRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "ConcurrentReportInputsRepositoryImpl")
	ConcurrentReportInputsRepository repository;

	@Test
	public void test_getInputs_success() throws Exception {
		Inputs inputs=repository.getInputs("Define MassCancel Listing");
		LOG_R.info("shortName===" + inputs.getApplication_Short_Name());
		//Assert.assertTrue(inputs.getApplication_Short_Name().equalsIgnoreCase("PO"));
		Assert.assertNull(inputs);
	}

}
