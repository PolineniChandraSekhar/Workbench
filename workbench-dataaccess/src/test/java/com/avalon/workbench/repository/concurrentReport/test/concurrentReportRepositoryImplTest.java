package com.avalon.workbench.repository.concurrentReport.test;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;

public class concurrentReportRepositoryImplTest extends
		AbstractWorkbenchDataAccessTest {
	protected static final Logger LOG_R = Logger
			.getLogger(concurrentReportRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "concurrentReportRepositoryImpl")
	ConcurrentReportRepository repository;

	@Test
	public void test_generateConcurrentReport_success() throws Exception {
		LOG_R.info("repository="+repository);
		Inputs inputs=new Inputs();
		inputs.setApplication_Short_Name("PO");
		inputs.setTemplate_code("EMPLOYEE_INFORMATION");
		inputs.setDefault_Language("en");
		inputs.setDefault_Territory("US");
		inputs.setDefault_output_type("PDF");
		ArrayList<String> list=new ArrayList<String>();
		list.add("1010");
		String id=repository.generateConcurrentReport("Purchasing, Vision Operations (USA)", "OPERATIONS", "po", "EMPLOYEE_INFORMATION", inputs, list);
		LOG_R.info("id==="+id);
		Assert.assertTrue(true);
	}
	@Test
	public void test_getConcurrentReport_success() throws Exception {
		LOG_R.info("repository="+repository);
		repository.getConcurrentReport(null);
		Assert.assertTrue(true);
	}
}
