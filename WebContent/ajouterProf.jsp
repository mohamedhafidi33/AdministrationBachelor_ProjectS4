<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>

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
<%
if (session.getAttribute("admin") == null) {
	response.sendRedirect("login.jsp");
}
%>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="headerAdmin.jsp"%>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Gestion des professeurs</h3>
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
										Ajout d'un professeur <small></small>
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
									<form class="" action="addProf" method="post" novalidate>

										<span class="section">Les Donn�es de professeur</span>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Nom<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" data-validate-length-range="6"
													data-validate-words="2" name="nom"
													placeholder="ex. mohamed" required="required" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Prenom<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" data-validate-length-range="6"
													data-validate-words="2" name="prenom"
													placeholder="ex. alaoui" required="required" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">CIN<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" class='optional' name="cin"
													data-validate-length-range="5,15" type="text" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">email<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" name="email" class='email'
													required="required" type="email" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Nationalit�<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" class='optional'
													name="nationalite" data-validate-length-range="5,15"
													type="text" />
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Ville</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control" name="ville">
													<option>Rabat</option>
													<option>Tanger</option>
													<option>Meknes</option>
													<option>Casa-Blanca</option>
													<option>Agadir</option>
													<option>Fes</option>
													<option>Marrakech</option>
												</select>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Province<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" class='optional' name="province"
													data-validate-length-range="5,15" type="text" />
											</div>
										</div>

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align">Gender</label>
											<div class="col-md-6 col-sm-6 ">
												<div id="gender" class="btn-group" data-toggle="buttons">
													<label class="btn btn-secondary"
														data-toggle-class="btn-primary"
														data-toggle-passive-class="btn-default"> <input
														type="radio" name="gender" value="male" class="join-btn">
														Male
													</label> <label class="btn btn-primary"
														data-toggle-class="btn-primary"
														data-toggle-passive-class="btn-default"> <input
														type="radio" name="gender" value="female" class="join-btn">
														Female
													</label>
												</div>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-md-3 col-sm-3  control-label">Checkboxes
												and radios <br> <small class="text-navy">Normal
													Bootstrap elements</small>
											</label>

											<div class="col-md-9 col-sm-9 ">
												<c:forEach items="${listMatiere}" var="matiere">
													<div class="checkbox">
														<label> <input name="matiereList" type="checkbox"
															class="flat" checked="0" value="${matiere.id }">
															<c:out value="${matiere.nom }"></c:out>
														</label>
													</div>
												</c:forEach>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Ajouter
												fichier Excel<span class="required"></span>
											</label>
											<div class="btn-group">
												<a class="btn" title="Insert picture (or just drag & drop)"
													id="pictureBtn"><i class="fa fa-picture-o"></i></a> <input
													type="file" data-role="magic-overlay" name="excelList"
													data-target="#pictureBtn" data-edit="insertImage" />
											</div>
										</div>
										<div class="ln_solid">
											<div class="form-group">
												<div class="col-md-6 offset-md-3">
													<button type='submit' class="btn btn-primary">Submit</button>
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
	<script src="../vendors/validator/multifield.js"></script>
	<script src="../vendors/validator/validator.js"></script>

	<!-- Javascript functions	-->
	<script>
		function hideshow() {
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");

			if (password.type === 'password') {
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			} else {
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
			"events" : [ 'blur', 'input', 'change' ]
		}, document.forms[0]);
		// on form "submit" event
		document.forms[0].onsubmit = function(e) {
			var submit = true, validatorResult = validator.checkAll(this);
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
