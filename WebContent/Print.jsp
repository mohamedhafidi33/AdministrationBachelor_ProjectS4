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

    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    
    <link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <%@include file="headerAdmin.jsp"%>

        <!-- top navigation -->
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Users <small>Some examples to get you started</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <form method="post" action="sendSemestre" >
							<div class="col-md-9 col-sm-9 ">
												<select class="form-control" name="semestre">
												<c:forEach items="${listSemestre }" var="semestre">
													<option>${semestre.nom }</option>
												</c:forEach>
												</select>
											</div>
									<button class="btn btn-secondary" type="submit">Go!</button>
								</form>
                </div>
              </div>
            </div>
            <div class="clearfix"></div>
            <div class="row">
               <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Button Example <small>Users</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Settings 1</a>
                            <a class="dropdown-item" href="#">Settings 2</a>
                          </div>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="row">
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <p class="text-muted font-13 m-b-30">
                      The Buttons extension for DataTables provides a common set of options, API methods and styling to display buttons on a page that will interact with a DataTable. The core library provides the based framework upon which plug-ins can built.
                    </p>
                    <table id="datatable-buttons" class="table table-striped table-bordered" style="width:100%">
                      <c:if test="${printSalle }">
                      <thead>
										<tr>
											<th style="width: 1%">Id</th>
											<th style="width: 20%">Numero</th>
											<!--<th>Team Members</th>-->
											<th>Description</th>
											<th style="width: 20%">Type de salle</th>
											
										</tr>

									</thead>

									<tbody>
										
											<c:forEach items="${salles}" var="salle">

												<tr>
													<td>${salle.id}<input type="hidden" name="id"
														value=${salle.id } />
													</td>
													<td><a> ${salle.numero} <input type="hidden"
															name="numero" value=${salle.numero } />
													</a> </td>
													
													<td><a> ${salle.description} <input type="hidden"
															name="description" value=${salle.description } />
													</a></td>
													<td><a> ${salle.typesalle} <input type="hidden"
															name="typesalle" value=${salle.typesalle } />
													</a> </td>
													
                      </c:forEach>
                      </tbody>
                     	
                      
                       </c:if>
                       
                       <c:if test="${printProfs }">
                       
                       <thead>
										<tr>
											<th style="width: 1%">Id</th>
											<th style="width: 20%">Nom</th>
											<!--<th>Team Members</th>-->
											<th>Prenom</th>
											<th style="width: 20%">CIN</th>
											<th style="width: 20%">Email</th>
											<th style="width: 20%">Ville</th>
											<th style="width: 20%">Nationalite</th>
											<th style="width: 20%">Sexe</th>
											
										</tr>

									</thead>

									<tbody>
										
											<c:forEach items="${profs}" var="prof">

												<tr>
													<td>${prof.id}<input type="hidden" name="id"
														value=${prof.id } />
													</td>
													<td><a> ${prof.nom} <input type="hidden"
															name="numero" value=${prof.nom } />
													</a> </td>

													
													<td><a> ${prof.prenom} <input type="hidden"
															name="description" value=${prof.prenom } />
													</a></td>
													<td><a> ${prof.cin} <input type="hidden"
															name="typesalle" value=${prof.cin } />
													</a> </td>
													<td><a> ${prof.email} <input type="hidden"
															name="typesalle" value=${prof.email } />
													</a> </td>
													<td><a> ${prof.ville} <input type="hidden"
															name="description" value=${prof.ville } />
													</a></td>
													<td><a> ${prof.nationalite} <input type="hidden"
															name="nationalite" value=${prof.nationalite } />
													</a></td>
													<td><a> ${prof.sexe} <input type="hidden"
															name="sexe" value=${prof.sexe } />
													</a></td>
													
													
							</c:forEach>						
                       </tbody>
                     	
                       </c:if>
                    </table>
                  </div>
                </div>
              </div>
            </div>
                </div>
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
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
   <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="vendors/jszip/dist/jszip.min.js"></script>
    <script src="vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>

  </body>
</html>