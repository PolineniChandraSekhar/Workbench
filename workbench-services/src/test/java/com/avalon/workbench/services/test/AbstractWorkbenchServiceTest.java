package com.avalon.workbench.services.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;


@ContextConfiguration( { "classpath:test-application-service.xml"} )
@RunWith( SpringJUnit4ClassRunner.class )
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class , DirtiesContextTestExecutionListener.class})
@TransactionConfiguration(defaultRollback =true)
@Transactional
public abstract class AbstractWorkbenchServiceTest {

}
