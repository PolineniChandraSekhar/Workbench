package com.avalon.workbench.service.mock.concurrentReport.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportRepository;
import com.avalon.workbench.repository.concurrentReport.ConcurrentReportRepositoryImpl;
import com.avalon.workbench.services.concurrentReport.ConcurrentReportServiceImpl;
import com.avalon.workbench.services.test.AbstractWorkbenchServiceTest;

//@RunWith(MockitoJUnitRunner.class)
public class ConcurrentReportServiceImplTest extends
		AbstractWorkbenchServiceTest {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportServiceImplTest.class);
	
	@Autowired()
	@Qualifier(value = "ConcurrentReportServiceImpl")
	ConcurrentReportServiceImpl service;
	
	/*@InjectMocks
	private ConcurrentReportServiceImpl service;

	@Mock
	private concurrentReportRepositoryImpl concurrentReportRepositoryImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}*/

	@Test
	public void test_getConcurrentReport_Success() throws Exception {
		ArrayList<String> list=new ArrayList<String>();
		list.add("1010");
		service.getConcurrentReport("Purchasing, Vision Operations (USA)", "OPERATIONS", "po", "POXMCDEF", null, null);
		Assert.assertTrue(true);
	}
	
}
