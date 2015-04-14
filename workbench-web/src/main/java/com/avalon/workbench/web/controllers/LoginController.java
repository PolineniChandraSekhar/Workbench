package com.avalon.workbench.web.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avalon.workbench.beans.responsibilites.Responsibilites;
//import com.avalon.workbench.repository.responsibilites.TestRRepository;
//import com.avalon.workbench.repository.user.TestRepository;
import com.avalon.workbench.services.exception.WorkbenchServiceException;
import com.avalon.workbench.services.responsibilites.ResponsibilitesService;
//import com.avalon.workbench.services.responsibilites.TestRService;
//import com.avalon.workbench.services.user.TestService;
import com.avalon.workbench.services.user.UserService;

@Controller
public class LoginController {

	protected static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	@Qualifier("UserServiceImpl")
	UserService service;

	@Autowired
	@Qualifier("ResponsibilitesServiceImpl")
	ResponsibilitesService responsibilitesService;
	
		
	/*@Autowired
	@Qualifier("TestServiceImpl")
	TestService  tservice;
		
	@Autowired
	@Qualifier("TestRServiceimpl")
	TestRService  trservice;
*/
	
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	public String checkUser(String uname,String pass, Model model,HttpSession session) throws Exception {
		log.info("inside checkUser......");
		boolean flag = service.AuthenticateUser(uname, pass);
		if (flag){
			session.setAttribute("uname", uname);
			return "redirect:getResponsibilities?pageId=0";
		}
		else{
			model.addAttribute("status", "invalid Username");
			return "login";
		}
			
	}

	@RequestMapping(value = "/getResponsibilities", method = RequestMethod.GET)
	public String getResponsibilities(@RequestParam("pageId") int pageId,HttpSession session, Model model) throws WorkbenchServiceException {
		log.info("inside getResponsibilities......");
		String uname=(String) session.getAttribute("uname");
		List<Responsibilites> responsibilites = responsibilitesService
				.getResonsibilites(uname);
		
		Collections.sort(responsibilites);
	
		log.info("responsibilities"+responsibilites);
		
		PagedListHolder<Responsibilites> pagedListHolder = new PagedListHolder<Responsibilites>(
				responsibilites);
		
		int page = pageId > 0 ? pageId : 0;
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "Responsibilites";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		return "login";
	}
	@RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "login";
	}
	
	
}	

		
		/*tservice.testMethod();
		log.info("After Calling Method in Controller");*/
		
		
	
		
		/*@RequestMapping(value = "/testingcall", method = RequestMethod.POST)
		public void  testingCall() throws Exception {
			log.info("testingCall method in Login Controller.....");
			tripository.testMethod1();
			log.info("After Calling Method in Repository");
		
		}*/
	

		
	
	
	
	
	
	
	
	
	
	

