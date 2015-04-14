package com.avalon.workbench.beans.user;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 8742033608551005976L;

	private Long USER_ID;
	
	public Long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	private String USER_NAME,PASSWORD;

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
}
