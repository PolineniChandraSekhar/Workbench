package com.avalon.workbench.repository.concurrentReport.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportParamsRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;

public class concurrentReportParamsRepositoryImplTest extends
		AbstractWorkbenchDataAccessTest {
	protected static final Logger LOG_R = Logger
			.getLogger(concurrentReportParamsRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "concurrentReportParamsRepositoryImpl")
	ConcurrentReportParamsRepository repository;

	@Test
	public void test_getParams_success() throws Exception {
		List<Parameters> params=repository.getParams("Employee_information");
		LOG_R.info("params===" + params.get(0).getPrompt()+" "+params.get(0).getColumn_seq_num());
		Assert.assertTrue(params.get(0).getPrompt().equalsIgnoreCase("Emp Number"));
	}

}
