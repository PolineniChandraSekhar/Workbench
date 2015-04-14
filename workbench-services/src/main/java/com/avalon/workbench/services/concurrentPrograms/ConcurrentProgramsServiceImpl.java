package com.avalon.workbench.services.concurrentPrograms;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.repository.concurrentPrograms.ConcurrentProgramsRepository;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;
import com.avalon.workbench.repository.user.UserRepositoryImpl;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("ConcurrentProgramsServiceImpl")
public class ConcurrentProgramsServiceImpl implements ConcurrentProgramsService {
	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentProgramsServiceImpl.class);

	@Autowired
	@Qualifier("ConcurrentProgramsRepositoryImpl")
	private ConcurrentProgramsRepository concurrentProgramsRepository;

	public List<ConcurrentPrograms> getConcurrentPrograms(String uname,
			String respName) throws WorkbenchServiceException {
		// TODO Auto-generated method stub
		try {
			if (respName.contains("&")) {
				return concurrentProgramsRepository.getConcurrentPrograms(uname, respName.replace("&", "''&''"));
			} else {
				return concurrentProgramsRepository.getConcurrentPrograms(
						uname, respName);
			}
		} catch (WorkbenchDataAccessException e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchServiceException(e);
		}
	}
}
