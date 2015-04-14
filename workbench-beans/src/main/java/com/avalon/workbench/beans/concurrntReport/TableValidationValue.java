package com.avalon.workbench.beans.concurrntReport;

public class TableValidationValue {
	String application_table_name,Value_Column_Name,Id_Column_Name,Additional_Where_Clause;

	public String getApplication_table_name() {
		return application_table_name;
	}

	public void setApplication_table_name(String application_table_name) {
		this.application_table_name = application_table_name;
	}

	public String getValue_Column_Name() {
		return Value_Column_Name;
	}

	public void setValue_Column_Name(String value_Column_Name) {
		Value_Column_Name = value_Column_Name;
	}

	public String getId_Column_Name() {
		return Id_Column_Name;
	}

	public void setId_Column_Name(String id_Column_Name) {
		Id_Column_Name = id_Column_Name;
	}

	public String getAdditional_Where_Clause() {
		return Additional_Where_Clause;
	}

	public void setAdditional_Where_Clause(String additional_Where_Clause) {
		Additional_Where_Clause = additional_Where_Clause;
	}
}
