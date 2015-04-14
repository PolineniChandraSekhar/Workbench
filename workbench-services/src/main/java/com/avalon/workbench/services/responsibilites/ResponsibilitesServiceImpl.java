package com.avalon.workbench.services.responsibilites;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.responsibilites.Responsibilites;
import com.avalon.workbench.repository.responsibilites.ResponsibilitesRepository;
import com.avalon.workbench.repository.user.UserRepositoryImpl;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service("ResponsibilitesServiceImpl")
public class ResponsibilitesServiceImpl implements ResponsibilitesService {
	protected static final Logger LOG_R = Logger
			.getLogger(ResponsibilitesServiceImpl.class);

	@Autowired
	@Qualifier("ResponsibilitesRepositoryImpl")
	private ResponsibilitesRepository responsibilitesRepository;

	public List<Responsibilites> getResonsibilites(String uname)
			throws WorkbenchServiceException {
		// TODO Auto-generated method stub
		try {
			return responsibilitesRepository.getResonsibilites(uname);
		} catch (Exception e) {
			LOG_R.error("Exception occured ::" + e);
			throw new WorkbenchServiceException(e);
		}
	}

}
