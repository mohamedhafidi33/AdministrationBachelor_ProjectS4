<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Administration Bachelor|</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>
<% if(session.getAttribute("admin")==null){ 
        response.sendRedirect("login.jsp");} 
   	 %>
<body class="nav-md">
	<div class="container body">

		<%@include file="headerAdmin.jsp"%>

		<!-- top navigation -->

		<!-- /top navigation -->

		<!-- page content -->
		<div class="right_col" role="main">
			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Gestion des salles</h3>
					</div>

					<div class="title_right">
						<div class="col-md-5 col-sm-5 form-group pull-right top_search">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Search for..."> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									Ajout d'une salle<small></small>
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i
											class="fa fa-chevron-up"></i></a></li>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-expanded="false"><i
											class="fa fa-wrench"></i></a>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuButton">
											<a class="dropdown-item" href="#">Settings 1</a> <a
												class="dropdown-item" href="#">Settings 2</a>
										</div></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<form class="" action="addSalle" method="post">
									<p>
										For alternative validation library
										<code>parsleyJS</code>
										check out in the <a href="form.html">form page</a>
									</p>
									<span class="section">Données de salle</span>

									<div class="field item form-group">
										<label class="col-form-label col-md-3 col-sm-3  label-align">Numero
											<span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="number" class='number'
												name="numero" data-validate-minmax="10,100"
												required='required'>
										</div>
									</div>

									<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Type de salle</label>
										<div class="col-md-9 col-sm-9 ">
											<select class="form-control" name="typesalle">
												<option>Cours</option>
												<option>TP</option>
												<option>LA</option>
											</select>
										</div>
									</div>
									<div class="field item form-group">
										<label class="col-form-label col-md-3 col-sm-3  label-align">Description<span
											class="required">*</span></label>
										<div class="col-md-6 col-sm-6">
											<textarea required="required" name="description"></textarea>
										</div>
									</div>
									<div class="ln_solid">
										<div class="form-group">
											<div class="col-md-6 offset-md-3">
												<input type="submit" class="btn btn-primary" value="Aouter">
												<button type='reset' class="btn btn-success">Reset</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /page content -->

		<!-- footer content -->
		<footer>
			<div class="pull-right">
				Gentelella - Bootstrap Admin Template by <a
					href="https://colorlib.com">Colorlib</a>
			</div>
			<div class="clearfix"></div>
		</footer>
		<!-- /footer content -->
	</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="vendors/validator/multifield.js"></script>
	<script src="vendors/validator/validator.js"></script>

	<!-- Javascript functions	-->
	<script>
		function hideshow(){
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");
			
			if(password.type === 'password'){
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			}
			else{
				password.type = "password";
				slash.style.display = "none";
				eye.style.display = "block";
			}

		}
	</script>

	<script>
        // initialize a validator instance from the "FormValidator" constructor.
        // A "<form>" element is optionally passed as an argument, but is not a must
        var validator = new FormValidator({
            "events": ['blur', 'input', 'change']
        }, document.forms[0]);
        // on form "submit" event
        document.forms[0].onsubmit = function(e) {
            var submit = true,
                validatorResult = validator.checkAll(this);
            console.log(validatorResult);
            return !!validatorResult.valid;
        };
        // on form "reset" event
        document.forms[0].onreset = function(e) {
            validator.reset();
        };
        // stuff related ONLY for this demo page:
        $('.toggleValidationTooltips').change(function() {
            validator.settings.alerts = !this.checked;
            if (this.checked)
                $('form .alert').remove();
        }).prop('checked', false);

    </script>

	<!-- jQuery -->
	<script src="vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- validator -->
	<!-- <script src="../vendors/validator/validator.js"></script> -->

	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>

</body>

</html>
