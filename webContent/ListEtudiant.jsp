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
          <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
              <div class="navbar nav_title" style="border: 0;">
                <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
              </div>

              <div class="clearfix"></div>

              <!-- menu profile quick info -->
              <div class="profile clearfix">
                <div class="profile_pic">
                  <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                </div>
                <div class="profile_info">
                  <span>Welcome,</span>
                  <h2>John Doe</h2>
                </div>
              </div>
              <!-- /menu profile quick info -->

              <br />

              <!-- sidebar menu -->
              <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                <div class="menu_section">
                  <h3>General</h3>
                  <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="index.html">Dashboard</a></li>
                        <li><a href="index2.html">Dashboard2</a></li>
                        <li><a href="index3.html">Dashboard3</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="form.html">General Form</a></li>
                        <li><a href="form_advanced.html">Advanced Components</a></li>
                        <li><a href="form_validation.html">Form Validation</a></li>
                        <li><a href="form_wizards.html">Form Wizard</a></li>
                        <li><a href="form_upload.html">Form Upload</a></li>
                        <li><a href="form_buttons.html">Form Buttons</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="general_elements.html">General Elements</a></li>
                        <li><a href="media_gallery.html">Media Gallery</a></li>
                        <li><a href="typography.html">Typography</a></li>
                        <li><a href="icons.html">Icons</a></li>
                        <li><a href="glyphicons.html">Glyphicons</a></li>
                        <li><a href="widgets.html">Widgets</a></li>
                        <li><a href="invoice.html">Invoice</a></li>
                        <li><a href="inbox.html">Inbox</a></li>
                        <li><a href="calendar.html">Calendar</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="tables.html">Tables</a></li>
                        <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="chartjs.html">Chart JS</a></li>
                        <li><a href="chartjs2.html">Chart JS2</a></li>
                        <li><a href="morisjs.html">Moris JS</a></li>
                        <li><a href="echarts.html">ECharts</a></li>
                        <li><a href="other_charts.html">Other Charts</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                        <li><a href="fixed_footer.html">Fixed Footer</a></li>
                      </ul>
                    </li>
                  </ul>
                </div>
                <div class="menu_section">
                  <h3>Live On</h3>
                  <ul class="nav side-menu">
                    <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="e_commerce.html">E-commerce</a></li>
                        <li><a href="projects.html">Projects</a></li>
                        <li><a href="project_detail.html">Project Detail</a></li>
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="profile.html">Profile</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                        <li><a href="page_403.html">403 Error</a></li>
                        <li><a href="page_404.html">404 Error</a></li>
                        <li><a href="page_500.html">500 Error</a></li>
                        <li><a href="plain_page.html">Plain Page</a></li>
                      
                        <li><a href="pricing_tables.html">Pricing Tables</a></li>
                      </ul>
                    </li>
                    <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span class="fa fa-chevron-down"></span></a>
                      <ul class="nav child_menu">
                          <li><a href="#level1_1">Level One</a>
                          <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                              <li class="sub_menu"><a href="level2.html">Level Two</a>
                              </li>
                              <li><a href="#level2_1">Level Two</a>
                              </li>
                              <li><a href="#level2_2">Level Two</a>
                              </li>
                            </ul>
                          </li>
                          <li><a href="#level1_2">Level One</a>
                          </li>
                      </ul>
                    </li>                  
                    <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>
                  </ul>
                </div>

              </div>
              <!-- /sidebar menu -->

              <!-- /menu footer buttons -->
              <div class="sidebar-footer hidden-small">
                <a data-toggle="tooltip" data-placement="top" title="Settings">
                  <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                </a>
                <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                  <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                </a>
                <a data-toggle="tooltip" data-placement="top" title="Lock">
                  <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                </a>
                <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                  <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                </a>
              </div>
              <!-- /menu footer buttons -->
            </div>
          </div>

          <!-- top navigation -->
          <div class="top_nav">
              <div class="nav_menu">
                  <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                  </div>
                  <nav class="nav navbar-nav">
                  <ul class=" navbar-right">
                    <li class="nav-item dropdown open" style="padding-left: 15px;">
                      <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                        <img src="images/user.png" alt="">Admin
                      </a>
                      <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item"  href="javascript:;"> Profile</a>
                          <a class="dropdown-item"  href="javascript:;">
                            <span class="badge bg-red pull-right">50%</span>
                            <span>Settings</span>
                          </a>
                      <a class="dropdown-item"  href="javascript:;">Help</a>
                        <a class="dropdown-item"  href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                      </div>
                    </li>
    
                    <li role="presentation" class="nav-item dropdown open">
                      <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-envelope-o"></i>
                        <span class="badge bg-green">6</span>
                      </a>
                      <ul class="dropdown-menu list-unstyled msg_list" role="menu" aria-labelledby="navbarDropdown1">
                        <li class="nav-item">
                          <a class="dropdown-item">
                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                            <span>
                              <span>John Smith</span>
                              <span class="time">3 mins ago</span>
                            </span>
                            <span class="message">
                              Film festivals used to be do-or-die moments for movie makers. They were where...
                            </span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="dropdown-item">
                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                            <span>
                              <span>John Smith</span>
                              <span class="time">3 mins ago</span>
                            </span>
                            <span class="message">
                              Film festivals used to be do-or-die moments for movie makers. They were where...
                            </span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="dropdown-item">
                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                            <span>
                              <span>John Smith</span>
                              <span class="time">3 mins ago</span>
                            </span>
                            <span class="message">
                              Film festivals used to be do-or-die moments for movie makers. They were where...
                            </span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="dropdown-item">
                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                            <span>
                              <span>John Smith</span>
                              <span class="time">3 mins ago</span>
                            </span>
                            <span class="message">
                              Film festivals used to be do-or-die moments for movie makers. They were where...
                            </span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <div class="text-center">
                            <a class="dropdown-item">
                              <strong>See All Alerts</strong>
                              <i class="fa fa-angle-right"></i>
                            </a>
                          </div>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </nav>
              </div>
            </div>
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
                  </div>
                </div>
              </div>  
              
              
             <td>
                               <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg" ><i class="fa fa-folder"></i>Modifier </button>
                               
                               

														<div class="modal fade bs-example-modal-lg" tabindex="-1"
															role="dialog" aria-hidden="true" style="display: none;">
															<div class="modal-dialog modal-lg">
																<div class="modal-content">

																	<div class="col-md-12 col-sm-12 ">
																		<div class="x_panel">
																			<div class="x_title">
																				<h2>Modification de l'emploi </h2>
																				<ul class="nav navbar-right panel_toolbox">
																					<li><a class="collapse-link"><i
																							class="fa fa-chevron-up"></i></a></li>
																					<li class="dropdown"><a
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
																									l'étudiant</h5>
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Id 
																													de l'étudiant : </label><input
																													value='<c:out value="${etudiant1.id }"></c:out>'
																													name="id" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>

																									</div>
																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Nom : </label><input
																													value='<c:out value="${etudiant1.nom }"></c:out>'
																													name="nom" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Prènom : </label><input
																													value='<c:out value="${etudiant1.prenom }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<!-- <div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Sexe : </label><input
																													value='<c:out value="${etudiant.sexe }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>-->
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">CIN : </label><input
																													value='<c:out value="${etudiant1.cin }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">CNE : </label><input
																													value='<c:out value="${etudiant1.cne }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<!--  <div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Date d'inscription : </label>
																												<input
																													value='<c:out value="${etudiant.dateInscription }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="date"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Date de naissance : </label><input
																													value='<c:out value="${etudiant.dateNaissance }"></c:out>'
																													name="dateNaissance" id="last_name_fr"
																													placeholder="" type="date"
																													class="form-control">
																											</div>
																										</div>
																										</div>-->
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Email : </label><input
																													value='<c:out value="${etudiant1.email }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Etablissement : </label><input
																													value='<c:out value="${etudiant1.etablissement }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																									</div>
																									
																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="first_name_fr" class="">Lieu de naissance : </label><input
																												name="description"	value='<c:out value="${etudiant1.lieuNaissance }"></c:out>'
																													
																													id="first_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>

																									</div>
																									
																									<!--  <div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Lieu de Bac : </label><input
																													value='<c:out value="${etudiant.lieuBac }"></c:out>'
																													name="lieuBac" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>-->
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Lycée : </label><input
																													value='<c:out value="${etudiant1.lycee }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										

																									<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label
																													class="control-label col-md-3 col-sm-3 ">Mention
																													</label>
																												<div class="col-md-9 col-sm-9 ">
																													<select class="form-control"
																														name="typesalle">
																														<option>Très bien</option>
																														<option>Bien</option>
																														<option>Assez bien</option>
																														<option>Passable </option>
																													</select>
																												</div>
																											</div>
																										</div>
																									</div>
																									
																									
																							<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Province : </label><input
																													value='<c:out value="${etudiant1.province }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label
																													class="control-label col-md-3 col-sm-3 ">Ville : 
																													</label>
																												<div class="col-md-9 col-sm-9 ">
																													<select class="form-control"
																														name="typesalle">
																														<option>Meknes</option>
																														<option>Rabat</option>
																														
																													</select>
																												</div>
																											</div>
																										</div>
																									</div>
																							
																										
																										
																										<div class="form-row">
																										<div class="col-md-6">
																											<div class="position-relative form-group">
																												<label for="last_name_fr" class="">Nationalité : </label><input
																													value='<c:out value="${etudiant1.nationalite }"></c:out>'
																													name="numero" id="last_name_fr"
																													placeholder="" type="text"
																													class="form-control">
																											</div>
																										</div>
																										</div>
																										
																										
																							
																							 <a type="submit" class="mt-2 btn btn-primary col-md-12" href="editEtudiant?id=<c:out value='${etudiant1.id}' />">Modifier </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																							 
																							<!-- <button class="mt-2 btn btn-primary col-md-12"
																								type="submit">Modifier l'étudiant</button>-->
																								
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