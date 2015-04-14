package com.avalon.workbench.services.concurrentPrograms;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface ConcurrentProgramsService {
	public List<ConcurrentPrograms> getConcurrentPrograms(String uname,String resName) throws WorkbenchServiceException;
}
