<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<link rel="shortcut icon" href="resources/images/symbol.png" type="image/x-icon" />
<link href="css/reset.css" rel="stylesheet" type="text/css"/>
<link href="css/960.css" rel="stylesheet" type="text/css"/>
<link href="css/coolMenu.css" rel="stylesheet" type="text/css" media="screen"/>
 <link href="resources/css/css_reset.css" rel="stylesheet" type="text/css"> 
<link href="resources/css/main_style.css" rel="stylesheet" type="text/css">
 <link href="resources/css/theme.css" rel="stylesheet" type="text/css"> 

<script type="text/javascript" src="js/modernizr-1.6.min.js"></script> 
</head>
<div id="topbar">
  <div id="topbar_wraper">
    <div class="date_stamp"> &nbsp;&nbsp;Welcome ${uname} <sec:authentication property="principal.username" />  </div>
    <div class="global_links"><a href="getResponsibilities?pageId=0">Home</a> | <a href='<c:url value="/j_spring_security_logout"/>'>Logout</a></div>
    <div class="clearfix"></div>
  </div>
</div>
<div id="banner">
  <div class="bannerwraper">
    <div id="logo"><img src="resources/images/avalonlogo.png" hspace="10" border="0" align="middle"></div>
   
    <div style="float:right;margin-top: 50px; margin-top: 55px; "></div>
    <div class="clearfix"></div>
  </div>
  </div>
  <div id="menubar">
    <div class="menubarwraper">
   
   
   
     <div class="container_16">
		<div class="grid_16">
		
		
  
		
		<!-- <ul id="coolMenu">
		      
     	 <li><a href="#">File&nbsp;&nbsp;&nbsp;&nbsp;</a>
     	 
      <ul class="noJS">
       <div class="row">
        <div class="filesubmenubarwraper">
					<lj><a href="approval.html">New</a></lj>
					</div>
					</div>
					 <div class="row">
					   <div class="filesubmenubarwraper">
					<lj><a href="pendingapprovals.html">Save</a></lj>
					</div>
					</div>
					 <div class="row">
					   <div class="filesubmenubarwraper">
					<lj><a href="fileUploadForm.html">Record</a></lj>
					</div>
					</div>
					 <div class="row">
					   <div class="filesubmenubarwraper">
					<lj><a href="admintab.html">Import</a></lj>
					</div>
					</div>
					 <div class="row">
					   <div class="filesubmenubarwraper">
					<lj><a href="fileDownloadForm.html">Print</a></lj>
					</div>
					</div>
					 <div class="row">
					   <div class="filesubmenubarwraper">
					<lj><a href="fndload.html">FNDLoad</a></lj>
					</div>
					</div>
				</ul> 
			</li>
			
     	 
     		
			
     	  <li><a href="#">Export&nbsp;&nbsp;&nbsp;&nbsp;</a>
     	         <ul class="noJS">
     	          <div class="row">
     	            <div class="exportsubmenubarwraper">
					<lk><a href="#">Single Record</a></lk>
					</div>
					</div>
					 <div class="row">
					   <div class="exportsubmenubarwraper">
					<lk><a href="employeereports.html">All Records</a></lk>
					</div>
					</div>
					 <div class="row">
					   <div class="exportsubmenubarwraper">
					<lk><a href="#">Personalizations</a></lk>
					</div>
					</div>
					
				</ul>
			
				</li>
     	   <li><a href="#">Edit&nbsp;&nbsp;&nbsp;&nbsp;	</a>
     	   <ul class="noJS">
     	    <div class="row">
     	      <div class="editsubmenubarwraper">
					<ll><a href="#">Delete</a></ll>
					</div>
					</div>
					 <div class="row">
					   <div class="editsubmenubarwraper">
					<ll><a href="#">Modify</a></ll>
					</div>
					</div>
					 <div class="row">
					   <div class="editsubmenubarwraper">
					<ll><a href="#">End Date</a></ll>
					</div>
					</div>
					 <div class="row">
					   <div class="editsubmenubarwraper">
					<ll><a href="#">Query</a></ll>
					</div>
					</div>
				</ul>
			</li>
     	   
     	    <li><a href="#">Review&nbsp;&nbsp;&nbsp;&nbsp;</a>
     	    
     	    	<ul class="noJS">
     	    	 <div class="row">
     	    	   <div class="reviewsubmenubarwraper">
					<lm><a href="#">Personalize</a></lm>
					</div>
					</div>
					 <div class="row">
					   <div class="reviewsubmenubarwraper">
					<lm><a href="#">Switch off Personalizations</a></lm>
					</div>
					
					
					  <sec:authorize access="hasRole('CREATEROLE')">
					
					 <div class="row">
					   <div class="reviewsubmenubarwraper">
					<lm><a href="newUserRoleDetails.html">New Role</a></lm>
					</div>
					
					</sec:authorize>
					
					  <sec:authorize access="hasRole('MANAGEROLE')">
					
					 <div class="row">
					   <div class="reviewsubmenubarwraper">
					<lm><a href="manageUserRole.html">Manage Role</a></lm>
					</div>
					</sec:authorize>
					
					  <sec:authorize access="hasRole('CREATEUSER')">
					 <div class="row">
					   <div class="reviewsubmenubarwraper">
					<lm><a href="createuser.html">New User</a></lm>
					</div>
					</sec:authorize>
					
					  <sec:authorize access="hasRole('MANAGEUSER')">
					 <div class="row">
					   <div class="reviewsubmenubarwraper">
					<lm><a href="manageSystemUser.html">Manage User</a></lm>
					</div>
					</sec:authorize>
					
					
					</div>
						</ul>
			</li>
			  <li><a href="#">Reports&nbsp;&nbsp;&nbsp;&nbsp;</a>
     	    
     	        
     	    	<ul class="noJS">
     	    	 <div class="row">
     	    	   <div class="helpsubmenubarwraper">
					<lm><a href="employeereports.html">Employee</a></lm>
					</div>
					</div>
					 <div class="row">
					   <div class="helpsubmenubarwraper">
					<lm><a href="#">Other</a></lm>
					</div>
					</div>
						</ul>
						
						
			</li>
     	    
			
     	     <li><a href="#">Help&nbsp;&nbsp;&nbsp;&nbsp;</a>
     	     
     	     <ul class="noJS">
     	      <div class="row">
     	        <div class="helpsubmenubarwraper">
					<ln><a href="#">Screen Help</a></ln>
					</div>
					</div>
					 <div class="row">
					   <div class="helpsubmenubarwraper">
					<ln><a href="#">Instructions</a></ln>
					</div>
					</div>
						</ul>
				</li>

	
      </ul>
       -->
     
    </div>
  </div>
</div>
</div>
    

