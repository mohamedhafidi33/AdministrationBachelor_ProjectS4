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

<title>Administration Bachelor |</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">

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
		<%@include file="headerAdmin.jsp"%>

		<!-- /top navigation -->

		<!-- page content -->
		<div class="right_col" role="main">
			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Liste des Salles</h3>
					</div>

					<div class="title_right">
						<div class="col-md-5 col-sm-5   form-group pull-right top_search">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Search for..."> <span
									class="input-group-btn">
									<button class="btn btn-secondary" type="button">Go!</button>
								</span>
							</div>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12">
						<div class="x_panel">
							<div class="x_title">
								<h2></h2>
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

								<p></p>



								<!-- start project list -->

								<table class="table table-striped projects">
									<thead>
										<tr>
											<th style="width: 1%">Id</th>
											<th style="width: 20%">Numero</th>
											<!--<th>Team Members</th>-->
											<th>Description</th>
											<th style="width: 20%">Type de salle</th>
											<th>Modifier/Supprimer</th>
										</tr>

									</thead>

									<tbody>
										<form method="post" action="modifierSalle">
											<c:forEach items="${salles}" var="salle">

												<tr>
													<td>${salle.id}<input type="hidden" name="id"
														value=${salle.id } />
													</td>
													<td><a> ${salle.numero} <input type="hidden"
															name="numero" value=${salle.numero } />
													</a> <br /> <!--<small>Created 01.01.2015</small>--></td>

													</td>
													<td><a> ${salle.description} <input type="hidden"
															name="description" value=${salle.description } />
													</a></td>
													<td><a> ${salle.typesalle} <input type="hidden"
															name="typesalle" value=${salle.typesalle } />
													</a> <br /> <!--<small>Created 01.01.2015</small>--></td>
													</div>
													</div>
													<!--<small>47% Complete</small>-->


													<td>
														<!--<button class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> Consult </button>-->

														<button type="button" class="btn btn-info btn-xs"
															data-toggle="modal" data-target=".bs-example-modal-lg">
															<i class="fa fa-pencil"></i>Modifier
														</button>

														<div class="modal fade bs-example-modal-lg" tabindex="-1"
															role="dialog" aria-hidden="true" style="display: none;">
															<div class="modal-dialog modal-lg">
																<div class="modal-content">

																	<div class="col-md-12 col-sm-12 ">
																		<div class="x_panel">
																			<div class="x_title">
																				<h2>Modification de salle</h2>
																				<ul class="nav navbar-right panel_toolbox">
																					<li><a class="collapse-link"><i
																							class="fa fa-chevron-up"></i></a></li>
																					<li class="dropdown"><a
																						href="http://localhost:33/AdministrationBachelor_ProjectS4/afficheSalles#"
																						class="dropdown-toggle" data-toggle="dropdown"
																						role="button" aria-expanded="false"><i
																							class="fa fa-wrench"></i></a></li>

																				</ul>
																				<div class="clearfix"></div>
																			</div>
																			<div class="x_content">
																				<div class="row">
																					<div class="col-sm-12">
																						<div class="card-box">

																							<div class="card-body bulk_action">
																								<h5 class="card-title">Modification de
																									salle</h5>
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Id
																													de salle</label><input
																													value='<c:out value="${salle.id }"></c:out>'
																													name="id" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>

																									</div>
																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Numero
																													de salle</label><input
																													value='<c:out value="${salle.numero }"></c:out>'
																													name="numero1" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>

																									</div>
																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="first_name_fr" class="">Description</label><input
																												name="description1"	value='<c:out value="${salle.description }"></c:out>'
																													
																													id="first_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>

																									</div>

																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label
																													class="control-label col-md-3 col-sm-3 ">Type
																													de salle</label>
																												<div class="col-md-9 col-sm-9 ">
																													<select class="form-control"
																														name="typesalle1">
																														<option>Cours</option>
																														<option>TP</option>
																														<option>LA</option>
																													</select>
																												</div>
																											</div>
																										</div>
																									</div>
																							</div>
																							<button class="mt-2 btn btn-primary col-md-12"
																								type="submit">Modifier</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div> 
														<button class="btn btn-danger btn-xs" formmethod="POST" formaction="deleteSalle">Suprimer</button>
													</td>
												</tr>
												</form>
										</c:forEach>
										</tbody>
										</table>





										<!-- /page content -->

										<!-- footer content -->
										<footer>
											<div class="pull-right">
												Administration Bachelor <a href="https://colorlib.com"></a>
											</div>
											<div class="clearfix"></div>
										</footer>
										<!-- /footer content -->
										</div>
										</div>


										<!-- Custom Theme Scripts -->

										<!-- jQuery -->
										<script src="vendors/jquery/dist/jquery.min.js"></script>
										<!-- Bootstrap -->
										<script
											src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
										<!-- FastClick -->
										<script src="vendors/fastclick/lib/fastclick.js"></script>
										<!-- NProgress -->
										<script src="vendors/nprogress/nprogress.js"></script>
										<!-- bootstrap-progressbar -->
										<script
											src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

										<!-- Custom Theme Scripts -->
										<script src="build/js/custom.min.js"></script>
</body>
</html>