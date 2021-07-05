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

    <title>Administration Bachelor | </title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Inscription administrative </h3>
                        </div>

                        <div class="title_right">
                            <div class="col-md-5 col-sm-5 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
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
                                    <h2>Formulaire  <small> Inscription administrative</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form action="addEtudiant" method="post" >
                                        <!--<p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a>
                                        </p>-->
                                        <span class="section"> Informations personnelles de l'étudiant </span>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Nom<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="nom" placeholder="Last name" />
                                            </div>
                                        </div>

                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Prènom <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  data-validate-length-range="6" data-validate-words="2" name="prenom" placeholder="first name" />
                                            </div>
                                        </div>

                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align " size= "10" >CNE  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <input type="text" class="form-control"   name="cne"placeholder="Ex: M124578451">
                                            </div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align " size= "10" >CIN  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <input type="text" class="form-control"   name="cin" placeholder="Ex: D784512">
                                            </div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> email <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  name="email" class='email'  type="email" /></div>
                                        </div>

                                        
                                        <!--<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Confirmer email address<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" type="email" class='email' name="confirm_email" data-validate-linked='email' required='required' /></div>
                                        </div>-->
                                        <!--<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Sexe <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" type="number" class='number' name="number" data-validate-minmax="10,100" required='required'></div>
                                        </div>-->
                                           <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date de naissance <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  class='date' type="date" name="dateNaissance" ></div>
                                        </div>
                                          <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date d'inscription <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='date1' type="date" name="dateInscription" ></div>
                                        </div>
                                        
                                      <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" > Année univ de début </label>
                                            <div class="col-md-6 col-sm-6 ">
												<select class="form-control" name="dateDebut">
												<c:forEach items="${annees}" var="anneeuniv">
													<option><c:out value="${anneeuniv.date_debut }"></c:out> </option>
													</c:forEach>
												</select>
											</div>
										</div>
                                        
                                        
                                          <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" > Année univ de fin  </label>
                                            <div class="col-md-6 col-sm-6 ">
												<select class="form-control" name="dateFin">
												<c:forEach items="${annees}" var="anneeuniv">
													<option><c:out value="${anneeuniv.date_fin }"></c:out> </option>
													</c:forEach>
												</select>
											</div>
										</div>
                                        
                                        
                                        
                                        
                                          <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" > Sexe </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="gender" tabindex="-1">
                                                    <option> </option>
                                                    
                                                    <option >male</option>
                                                    <option >female</option>
                                                </select>
                                            </div>
                                        </div>
                                       <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> établissement  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  class='optional' name="etablissement" data-validate-length-range="5,15" type="text" /></div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Lieu de bac  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='optional' name="lieuBac" data-validate-length-range="5,15" type="text" /></div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Lycée <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  class='optional' name="lycee" data-validate-length-range="5,15" type="text" /></div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align " size= "10" >Nationalité  </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <input type="text" class="form-control"  name="nationalite" placeholder="Marocain(e)">
                                            </div>
                                        </div>
                                         <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Province <span class="required"></span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='optional' name="province" data-validate-length-range="5,15" type="text" /></div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Lieu de naissance <span class="required"></span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"   class='optional' name="lieuNaissance" data-validate-length-range="5,15" type="text" /></div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" > Ville </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="ville" tabindex="-1">
                                                    <option> </option>
                                                    
                                                    <option >Meknes</option>
                                                    <option >Rabat</option>
                                                    <option >Casablanca</option>
                                                    <option >Marrakesh</option>
                                                    <option >Assilah</option>
                                                    <option >Kenitra</option>
                                                    

                                                </select>
                                            </div>
                                        </div>

                                         
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Certificat de baccalauréat <span class="required"></span></label>
                                        <a class="btn" title="Insert picture (or just drag & drop)"></a>
                                        <input type="file" name="certificat "data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
                                    </div>
                                    <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Attestation de scolarité <span class="required"></span></label>
                                        <a class="btn" title="Insert picture (or just drag & drop)"></a>
                                        <input type="file" name="attestation" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
                                    </div>
                                    <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Reçu de paiement <span class="required"></span></label>
                                        <a class="btn" title="Insert picture (or just drag & drop)"></a>
                                        <input type="file" name="recu" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
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
                                            
                                            
                                          
                                            
                                            <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" >Mention </label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="mention" tabindex="-1">
                                                    <option> </option>
                                                    <option >Très bien</option>
                                                    <option >Bien</option>
                                                    <option >Passable</option>
                                                </select>
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
                                            
                                            
                                            
                                                                                                                                                   
                                        
                                        <!--  <div class="ln_solid">-->
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                   <input type="submit" class="btn btn-primary" value="Ajouter l'étudiant">
                                                   
                                                    <!--<button type='reset' class="btn btn-success">Reset</button>
                                                 
                                                </div>
                                            </div>
                                        </div>
                                    </div>-->
                               </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    
            <!-- /page content -->

            <!-- footer content -->
            <!--<footer>
                <div class="pull-right">
                    Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                </div>
                <div class="clearfix"></div>
            </footer>
             /footer content
        </div>
    </div>-->


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../vendors/validator/multifield.js"></script>
    <script src="../vendors/validator/validator.js"></script>
    
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
    <style>
    .control-label col-md-3 col-sm-3  {
     width : 2%;
}
    </style>
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