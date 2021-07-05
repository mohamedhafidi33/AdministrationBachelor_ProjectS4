<%@page import="beans.Etudiant"%>
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

    <body class="nav-md">
   
      <div class="container body">
        <div class="main_container">
          <%@include file="headerAdmin.jsp"%>
          <!-- /top navigation -->

          <!-- page content -->
          <div class="right_col" role="main">
            <div class="">
              <div class="page-title">
               
                
                <div class="title_right">
              
              
						</div>
						</div>	
                        </div> 
                        
                
              
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
											
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									
									
									
									<form method ="post" action ="selectData">

										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date de début de l'année  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  class='date' type="date" name="dateDebut" required='required'>
                                           </div>
                                        </div>
                                          <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date de fin de l'année  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='date1' type="date" name="dateFin" required='required'></div>
                                        </div>
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" >Filière </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="filiere" tabindex="-1">
                                                    <option> </option>
                                                    <option >BGI</option>
                                                    <option >BGB</option>
                                                    <option >BCA</option>
                                                </select>
                                            </div>
                                            </div>
                                            
                                            <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" >Semestre </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="nomSemestre" tabindex="-1">
                                                    <option> </option>
                                                    <option >S1</option>
                                                    <option >S2</option>
                                                    <option >S3</option>
                                                    <option >S4</option>
                                                    <option >S5</option>
                                                    
                                                </select>
                                            </div>
                                            </div>
										<!--<div class="item form-group">
											<label for="middle-name" class="col-form-label col-md-3 col-sm-3 label-align">Middle Name / Initial</label>
											<div class="col-md-6 col-sm-6 ">
												<input id="middle-name" class="form-control" type="text" name="middle-name">
											</div>
										</div>-->
										
										
										<div class="ln_solid"></div>
										<div class="item form-group">
											<div class="col-md-6 col-sm-6 offset-md-3">
												
												<!--<button class="btn btn-primary" type="reset">Reset</button>-->
												
												 <button type="submit" class="btn btn-success"> Chercher dans la liste des étudiants </button> 
											</div>
										</div>

									</form>
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
                      <!-- start project list -->
                      
                      <table class="table table-striped projects">
                        <thead>
                          <tr>
                          
                          
                            <th >Id</th>
                            <th>CIN</th>
                            <th>Nom</th>
                            <th>Prènom </th>
                            <th>CNE</th>
                              
                            <th> email </th>
                            <th> Modifier/Supprimer </th>
                            
                          </tr>
                        </thead>
                        
                        <tbody>
                        
                        
							 <c:forEach items="${etudiants}" var="etudiant1">
							 
                          <tr>
                          
                            <td> ${etudiant1.id} </td> 
                            <td> ${etudiant1.cin} </td>
                            <td> ${etudiant1.nom} </td>
                             
                        
                            <td>
                            ${etudiant1.prenom}
                            </td>
                            <td> ${etudiant1.cne}
                            </td>
                            
                            
                        
                            <td> ${etudiant1.email}
                            </td>
                    <!-- /modal-->
                 
              
              
             <td>
             
          
                             
   <a type="submit" class="btn btn-success" href="modifierEtudiant?id=<c:out value='${etudiant1.id}' />"> <i class="fa fa-folder"></i>Modifier </a>
<a href="supprimerEtudiant?id= <c:out value='${etudiant1.id}'/>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"> </i> Supprimer </a> 
														
                               
                               
                                

                            </td>
                           
                            </tr>
                        
                           
                     </c:forEach>
                     
                   
                     
                      
                               </tbody>
                              </table>
                              
                              
                              
                                   
                            
                 
                  
                  
          <!-- /page content -->

          <!-- footer content -->
         
          <!-- /footer content -->
        
      

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