<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
  <html lang="en">
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!-- Meta, title, CSS, favicons, etc. -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">

      <title>Gentelella Alela! | </title>

      <!-- Bootstrap -->
      <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- Font Awesome -->
      <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
      <!-- NProgress -->
      <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
      <!-- iCheck -->
      <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">

      <!-- Custom Theme Style -->
      <link href="build/css/custom.min.css" rel="stylesheet">
    </head>
<% if(session.getAttribute("professeur")==null){ 
        response.sendRedirect("login.jsp");} 
   	 %>
    <body class="nav-md">
    <c:out value="Bonjour !!!" /><br/>
      <div class="container body">
       <%@include file="headerProf.jsp" %>
          <!-- top navigation -->
          
          <!-- /top navigation -->

          <!-- page content -->
          <div class="right_col" role="main">
            <div class="">
              <div class="page-title">
                <div class="title_left">
                  <h3>Liste des Salles disponibles </h3>
                </div>
			<form method="post" action="sendDate" >
                <div class="title_right">
                  <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                    <div class="input-group">
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
                      <span class="input-group-btn">
                        <button class="btn btn-secondary" type="submit">Go!</button>
                      </span>
                    </div>
                  </div>
                </div>
                </form>
              </div>
              
              <div class="clearfix"></div>

              <div class="row">
                <div class="col-md-12">
                  <div class="x_panel">
                    <div class="x_title">
                      <h2></h2>
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

                      <p>  </p>
                     
                    
					
                      <!-- start project list -->
                      
                      <table class="table table-striped projects">
                        <thead>
                          <tr>
                            <th style="width: 1%">Id</th>
                            <th style="width: 20%">Numero</th>
                            <!--<th>Team Members</th>-->                   
                            <th>Description </th>
                            <th style="width: 20%"> Type de salle </th>
                            <th>Creneau 1</th>
                            <th>Creneau 2</th>
                            <th>Creneau 3</th>
                            <th>Creneau 4</th>
                          </tr>
                         
                        </thead>
                        
                        <tbody>
                        <form method="post" action="reserver" > 
                          <c:forEach items="${salles}" var="salle">
                          <tr>
                            
                            <td> <a>${salle.id } 
                             <input type="hidden"  name="id" value=${salle.id }  />
                          </a>  </td>
                          
                            <td> <a> ${salle.numero } 
       							<input type="hidden"  name="numero" value=${salle.numero } />
                              </a> </td>
                            
                           
                            <td> <a> ${salle.description } 
                            <input type="hidden"  name="description" value=${salle.description } />
                            </a> </td>
                            
                            <td>  <a> ${salle.typesalle} 
                              <input type="hidden"  name="typesalle" value=${salle.typesalle }  />
                              </a> </td>
                            
                            
                              <!--<small>47% Complete</small>-->
                            
                            
                            <td>
                              <!--<button class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> Consult </button>-->
                              
                  <button name="creneau" value="C1" type="submit" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg" >R�server </button>
                              
					 
					  </td>
                <td>
                  <button name="creneau" value="C2" type="submit" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg" >R�server </button>
                  </td>
                 <td>
                 
                  <button name="creneau" value="C3" type="submit" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg" >R�server </button>
                  </td>
                  <td>
                  <button name="creneau" value="C4" type="submit" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg" >R�server </button>
                  </td>
                   
                </c:forEach>
                            </form>                        
                            
                  
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
     <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
      <!-- FastClick -->
      <script src="vendors/fastclick/lib/fastclick.js"></script>
      <!-- NProgress -->
      <script src="vendors/nprogress/nprogress.js"></script>
      <!-- bootstrap-progressbar -->
      <script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
      
      <!-- Custom Theme Scripts -->
      <script src="build/js/custom.min.js"></script>

    </body>
  </html>