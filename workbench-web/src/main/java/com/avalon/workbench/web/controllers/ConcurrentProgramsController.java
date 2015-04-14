package com.avalon.workbench.web.controllers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avalon.workbench.beans.concurrntPrograms.ConcurrentPrograms;
import com.avalon.workbench.beans.concurrntReport.Parameters;
import com.avalon.workbench.services.concurrentPrograms.ConcurrentProgramsService;
import com.avalon.workbench.services.concurrentReport.ConcurrentReportParamsService;
import com.avalon.workbench.services.concurrentReport.ConcurrentReportService;
import com.avalon.workbench.services.exception.WorkbenchServiceException;

@Controller
public class ConcurrentProgramsController {
	protected static final Logger log = Logger.getLogger(ConcurrentProgramsController.class);

	@Autowired
	@Qualifier("ConcurrentProgramsServiceImpl")
	ConcurrentProgramsService concurrentProgramsService;

	@Autowired
	@Qualifier("ConcurrentReportServiceImpl")
	ConcurrentReportService concurrentReportService;

	@Autowired
	@Qualifier("ConcurrentReportParamsServiceImpl")
	ConcurrentReportParamsService concurrentReportParamsService;

	@RequestMapping(value = "/getConcurrentPrograms", method = RequestMethod.GET)
	public String getConcurrentPrograms(@RequestParam("pageId") int pageId,
			HttpSession session, Model model, String respName)
			throws WorkbenchServiceException {
		log.info("inside getConcurrentPrograms......");
		String uname = (String) session.getAttribute("uname");
		List<ConcurrentPrograms> programs = concurrentProgramsService
				.getConcurrentPrograms(uname, respName);
		PagedListHolder<ConcurrentPrograms> pagedListHolder = new PagedListHolder<ConcurrentPrograms>(
				programs);
		int page = pageId > 0 ? pageId : 0;
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("respName", respName);
		return "ConcurrentPrograms";
		
	}

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public void getFile(@RequestParam Map<String,String> allRequestParams,String respName, String progName,String shortName,String concurrentName,
			HttpServletResponse response, HttpSession session) {
		try {
			List<Parameters> params = concurrentReportParamsService
					.getParams(progName);
			ArrayList<String> paramsList=new ArrayList<String>();
			//Modification By Mallik @ 20-03-15
			log.info("@getReport-------Length Of params"+ params.size());
			log.info("@Concurrent Name -------"+ concurrentName);
			
			for(int i=0;i<params.size();i++){
				log.info("-=-=-"+i+"-=-=-"+params.get(i));				
				String param1=allRequestParams.get(params.get(i).getPrompt());
				paramsList.add(param1);
			}
			
			// Modification End by mallik	
			
			
			//String param1=allRequestParams.get(params.get(0).getPrompt());
			//ArrayList<String> paramsList=new ArrayList<String>();
			//paramsList.add(param1);						
			//log.info("Param value "+param1);
			//log.info("parameter==="+paramsList.get(0)+"respName="+respName);
			String uname = (String) session.getAttribute("uname");
			
			String fileName = concurrentReportService.getConcurrentReport(
					respName, uname, shortName, concurrentName, paramsList,progName);
			
			log.info("filename====="+fileName);
			// get your file as InputStream
			InputStream is = new FileInputStream("D:/" + fileName);
			// copy it to response's OutputStream
			IOUtils.copy(is, response.getOutputStream());
			//response.setContentType("application/pdf");
			response.flushBuffer();
		} catch (Exception ex) {
			log.info("Error writing file to output stream. Filename was");
			throw new RuntimeException("IOError writing file to output stream");
		}

	}

	@RequestMapping(value = "/getParameters", method = RequestMethod.GET)
	public String getParameters(String respName,String progName,String shortName,String concurrentName, Model model)
			throws WorkbenchServiceException {
		List<Parameters> params = concurrentReportParamsService
				.getParams(progName);	

		
		log.info("promt====="+params.get(0).getPrompt());
		model.addAttribute("parameters", params);
		model.addAttribute("progName", progName);
		model.addAttribute("shortName", shortName);
		model.addAttribute("concurrentName", concurrentName);
		model.addAttribute("respName", respName);
		return "sanjay";
	}
}
