package com.avalon.workbench.service.mock.responsibilites.test;

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

import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.beans.user.User;
import com.avalon.workbench.repository.responsibilites.ResponsibilitesRepository;
import com.avalon.workbench.service.mock.concurrentPrograms.test.ConcurrentProgramsServiceImplTest;
import com.avalon.workbench.services.responsibilites.ResponsibilitesServiceImpl;
import com.avalon.workbench.services.test.AbstractWorkbenchServiceTest;

@RunWith(MockitoJUnitRunner.class)
public class ResponsibilitesServiceImplTest extends AbstractWorkbenchServiceTest{
	protected static final Logger LOG_R = Logger
			.getLogger(ResponsibilitesServiceImplTest.class);
	@InjectMocks
	private ResponsibilitesServiceImpl service;
	
	@Mock
	private ResponsibilitesRepository responsibilitesRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_AuthenticateUser_Success()
			throws Exception {
		Responsibilites responsibilites=new Responsibilites();
		responsibilites.setUser_name("test1");
		ArrayList<Responsibilites> list=new ArrayList<Responsibilites>();
		list.add(responsibilites);
		Mockito.when(responsibilitesRepository.getResonsibilites(Mockito.anyString())).thenReturn(list);
		List<Responsibilites> value=service.getResonsibilites("asd");
		Assert.assertTrue(value.get(0).getUser_name().equals("test1"));
	}
}
