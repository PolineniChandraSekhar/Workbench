package com.avalon.workbench.repository.concurrentPrograms.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.repository.concurrentPrograms.ConcurrentProgramsRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;
import com.avalon.workbench.repository.user.UserRepositoryImpl;

public class ConcurrentProgramsRepositoryImplTest extends
		AbstractWorkbenchDataAccessTest {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentProgramsRepositoryImplTest.class);
	@Autowired
	@Qualifier(value = "ConcurrentProgramsRepositoryImpl")
	ConcurrentProgramsRepository repository;

	@Test
	public void test_getUser_success() throws Exception {
		List<ConcurrentPrograms> result = repository.getConcurrentPrograms(
				"OPERATIONS", "Alert Manager, Vision Enterprises");
		LOG_R.info("name===" + result.get(0).getUser_name()
				+ "Application_name==" + result.get(0).getApplication_name());
		Assert.assertTrue(result.get(0).getApplication_name()
				.equalsIgnoreCase("Alert"));
	}

}
