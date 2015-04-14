package com.avalon.workbench.repository.concurrentReport;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avalon.workbench.beans.concurrntReport.Inputs;
import com.avalon.workbench.repository.exception.WorkbenchDataAccessException;

@Repository("ConcurrentReportInputsRepositoryImpl")
public class ConcurrentReportInputsRepositoryImpl implements
		ConcurrentReportInputsRepository {

	protected static final Logger LOG_R = Logger
			.getLogger(ConcurrentReportInputsRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Inputs getInputs(String concurrentName)
			throws WorkbenchDataAccessException {
		try {
			LOG_R.info("inside getInputs of data access layer----");
			String sql = "Select Xtb.Application_Short_Name ,     XTB.template_code ,          Xtb.Default_Language ,        Xtb.Default_Territory ,       XTB.template_type_code ,           XTB.default_output_type   FROM apps.XDO_DS_DEFINITIONS_VL XDDV,       apps.XDO_TEMPLATES_B XTB,       apps.XDO_TEMPLATES_TL XTT,       apps.XDO_LOBS XL,       apps.FND_APPLICATION_TL FAT,       Apps.Fnd_Application Fa Where      "
					+ "Xddv.Data_Source_Code = '"
					+ concurrentName
					+ "'       AND XDDV.application_short_name = FA.application_short_name       AND FAT.application_id = FA.application_id       AND XTB.application_short_name = XDDV.application_short_name       AND XDDV.data_source_code = XTB.data_source_code       AND XTT.template_code = XTB.template_code       AND XL.lob_code = XTB.template_code            And Xl.Xdo_File_Type = Xtb.Template_Type_Code";
			LOG_R.info("query==" + sql);
			BeanPropertyRowMapper rm = new BeanPropertyRowMapper(Inputs.class);
			List<Inputs> result = jdbcTemplate.query(sql, rm);
			if (result != null && !result.isEmpty())
				return result.get(0);
			return null;
		} catch (Exception e) {
			LOG_R.error("Exception occured :-----:" + e);
			throw new WorkbenchDataAccessException(e);
		}

	}

}
