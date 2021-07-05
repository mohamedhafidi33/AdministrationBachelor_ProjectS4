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
                            <h3>Gestion des emplois du temps </h3>
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
                                    <h2>Formulaire  <small> Gestion des emplois </small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form enctype='multipart/form-data' action="addEmploi" method="post" >
                                        <!--<p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a>
                                        </p>-->
                                        <span class="section"> Ajout d'un emploi  </span> 
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Nom de l'emploi <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  data-validate-length-range="6" data-validate-words="2" name="nomEmploi"  required="required" />
                                            </div>
                                        </div>
                                        
                                             <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" > Semestre <span class="required"> *</span></label>
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
                                            <label class="col-form-label col-md-3 col-sm-3  label-align" >Session <span class="required"> *</span></label>
                                            <div class="col-md-6 col-sm-6 ">
                                                <select class="select2_single form-control" name="session" tabindex="-1">
                                                    <option> </option>
                                                    <option >automne</option>
                                                    <option >printemps</option>
                                                 
                                                </select>
                                            </div>
                                            </div>
                                            
                                            
                                           <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date de d�but de l'ann�e  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control"  class='date' type="date" name="dateDebut" required='required'>
                                           </div>
                                        </div>
                                        
                                          <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Date de fin de l'ann�e  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" class='date1' type="date" name="dateFin" required='required'>
                                                </div>
                                        </div>
  
                                            
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align"> Joindre fichier :  <span class="required"> *</span></label>
                                        <a class="btn" title="Insert picture (or just drag & drop)"></a>
                                        <input type="file" id="IdFile"name="emploiFile "data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
                                    </div>
                                            
                                            
                                                                                                                                       
                                        
                                        <!--  <div class="ln_solid">-->
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                
                                                   <input type="submit" class="btn btn-primary" value="Confirmer l'ajout ">
                                                   
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