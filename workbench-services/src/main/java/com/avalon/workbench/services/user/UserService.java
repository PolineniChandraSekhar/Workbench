package com.avalon.workbench.services.user;

import org.springframework.stereotype.Service;

import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Service
public interface UserService {
	public boolean AuthenticateUser(String uname, String pwd) throws WorkbenchServiceException;

}
