package com.avalon.workbench.repository.responsibilites.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.repository.responsibilites.ResponsibilitesRepository;
import com.avalon.workbench.repository.test.AbstractWorkbenchDataAccessTest;
import com.avalon.workbench.repository.user.UserRepositoryImpl;

public class ResponsibilitesRepositoryImplTest extends AbstractWorkbenchDataAccessTest{
	protected static final Logger LOG_R = Logger
			.getLogger(UserRepositoryImpl.class);
	@Autowired
	@Qualifier(value = "ResponsibilitesRepositoryImpl")
	ResponsibilitesRepository repository;

	@Test
	public void test_getUser_success() throws Exception {
		LOG_R.info("repository="+repository);
		List<Responsibilites> result = repository.getResonsibilites("AALLEN");
		LOG_R.info("name==="+result.get(0).getUser_name()+"Responsibility_name=="+result.get(0).getResponsibility_name());
		Assert.assertTrue(result.get(0).getResponsibility_name().equalsIgnoreCase("Team Member, Progress S&L"));
		Assert.assertTrue(result.size()==9);
	}
}
