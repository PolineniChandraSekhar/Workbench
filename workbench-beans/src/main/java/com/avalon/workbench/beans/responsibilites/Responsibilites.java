package com.avalon.workbench.beans.responsibilites;

public class Responsibilites implements Comparable<Responsibilites>{
	private String user_name,responsibility_name,responsibility_key,application_short_name,start_date,end_date;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getResponsibility_name() {
		return responsibility_name;
	}

	public void setResponsibility_name(String responsibility_name) {
		this.responsibility_name = responsibility_name;
	}

	public String getResponsibility_key() {
		return responsibility_key;
	}

	public void setResponsibility_key(String responsibility_key) {
		this.responsibility_key = responsibility_key;
	}

	public String getApplication_short_name() {
		return application_short_name;
	}

	public void setApplication_short_name(String application_short_name) {
		this.application_short_name = application_short_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int compareTo(Responsibilites o) {
		// TODO Auto-generated method stub
		return this.responsibility_name.compareTo(o.getResponsibility_name());
	}
}
