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
      <c:if test="${prof }">
       <%@include file="headerProf.jsp"%>
      </c:if>
      
  <c:if test="${admin }">
     <%@include file="headerAdmin.jsp"%>
</c:if>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3><small>Ajout d'absences</small></h3>
              </div>
              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <form method="post" action="absenceData" >
							<div class="col-md-9 col-sm-9 ">
												<select class="form-control" name="matiere">
												<c:forEach items="${listMatiere }" var="matiere">
													<option>${matiere.nom }</option>
												</c:forEach>
												</select>
											</div>
											<td>  <a> 
                           
							<input id="birthday" name="date" class="date-picker form-control" placeholder="dd-mm-yyyy" type="text" required="required" type="text" onfocus="this.type='date'" onmouseover="this.type='date'" onclick="this.type='date'" onblur="this.type='text'" onmouseout="timeFunctionLong(this)">
								<script>
									function timeFunctionLong(input) {
											setTimeout(function() {
												input.type = 'text';
												}, 60000);
											}
									</script>
											
                              </a> </td>
                              <div class="col-md-9 col-sm-9 ">
												<select class="form-control" name="creneau">
												<option>C1</option>
												<option>C2</option>
												<option>C3</option>
													<option>C4</option>
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
                    <h2>Listes des étudiants<small>Users</small></h2>
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
                    
                    <form class="" action="addAbsence" method="post" novalidate>
                    <table id="datatable-buttons" class="table table-striped table-bordered" style="width:100%">
                      
                      <thead>
										<tr>
							 				<th><input type="checkbox" id="check-all" ></th>
						  			
											<th style="width: 1%">Id</th>
											<th style="width: 20%">Nom</th>
											
											<th style="width: 20%">Prenom</th>
											<th style="width: 20%">CIN</th>
											<th style="width: 20%">CNE</th>
											<th style="width: 20%">Email</th>
											<th style="width: 20%">Ville</th>
											<th style="width: 20%">Sexe</th>
											
										</tr>

									</thead>

									<tbody>
										
											<c:forEach items="${etudiants}" var="etudiant">

												<tr>
													<td>
													 <input name="listEtudiant" value="${etudiant.id }" type="checkbox" id="check-all" >
						  							</td>
													<td>${etudiant.id}<input type="hidden" name="id"
														value=${etudiant.id } />
													</td>
													<td><a> ${etudiant.nom } <input type="hidden"
															name="numero" value=${etudiant.nom } />
													</a> </td>
													
													<td><a> ${etudiant.prenom } <input type="hidden"
															name="description" value=${etudiant.prenom } />
													</a></td>
													<td><a> ${etudiant.cin } <input type="hidden"
													name="typesalle" value=${etudiant.cin } />
													</a> </td>
													<td><a> ${etudiant.cne } <input type="hidden"
													name="typesalle" value=${etudiant.cne } />
													</a> </td>
													<td><a> ${etudiant.email } <input type="hidden"
													name="typesalle" value=${etudiant.email } />
													</a> </td>
													<td><a> ${etudiant.ville } <input type="hidden"
													name="typesalle" value=${etudiant.ville } />
													</a> </td>
													<td><a> ${etudiant.sexe } <input type="hidden"
													name="typesalle" value=${etudiant.sexe } />
													</a> </td>
													
                      </c:forEach>
                     
                      </tbody>
                     	
                    </table>
                    <div class="x_content">
                  <button type="submit" class="btn btn-round btn-success">Ajouter Absence</button>
                </div>
                     </form>
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