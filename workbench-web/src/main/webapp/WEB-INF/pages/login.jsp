<html>
<head>
<title>Avalon's Tool</title>
<link href="resources/css/css_reset.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="resources/images/symbol.png"
	type="image/x-icon" />
<script type="text/javascript" src="resources/js/main.js"></script>
<script type="text/javascript" src="resources/js/shortcuts.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>

<script>
	
</script>
</head>
<body>

	<div id="topbar">
		<div id="topbar_wraper">

			<div class="clearfix"></div>
		</div>
	</div>

	<div id="banner">
		<div class="bannerwraper">
			<div id="logo">
				<img src="resources/images/avalonlogo.png" hspace="10" border="0"
					align="middle">
			</div>

			<div style="float: right; margin-top: 50px; margin-top: 55px;"></div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div id="page_container">
		<div class="clearfix"></div>
		<div id="content_main">
	    <form method="post" action="checkUser"> 
				<div id="login_pane" class="section_full_search">
					<div style="float: left;">
						<span style="font-size: 14px; color: #356BA7;"></span>
					</div>
					<div class="float_right" style="margin: 15px 0 5px 0;"></div>
					<div class="clearfix"></div>
					<div class="box_border">

						<div class="Login_rightblock">
							<div class="clearfix"></div>
							<div class="box_border"
								style="margin: 23px 10px 0 0; background-image: none;">
								<h2 style="color: #D80000; size: 4; margin: 8px 0px 0px 38px">${status}</h2>
								<label class="required_sign"> </label>

								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
								<div class="clearfix"></div>
								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>

								<div class="row">
									<div class="frmlabel">
										<label for="j_username">User Name</label>
									</div>
									<div class="frmvalue">
										<input type="text" name="uname" /> <label
											class="required_sign"></label>
									</div>
								</div>
								<div class="row">
									<div class="frmlabel">
										<label for="j_password">Password&nbsp;&nbsp;</label>
									</div>
									<div class="frmvalue">
										<input type="password" name="pass" /> <label
											class="required_sign"></label>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
								<div class="clearfix"></div>
								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
								<div class="clearfix"></div>
								<div class="row">

									<input type="submit" value='Go' class="button" /> <input
										type="reset" value='Clear' class="button" /> <input
										type="submit" value='Reset Password' class="button" />


								</div>
								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
								<div class="clearfix"></div>
								<div class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
