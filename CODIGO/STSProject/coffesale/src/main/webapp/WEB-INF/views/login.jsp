<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>COFFE SALE</title>
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
  <style type="text/css">
  	p{
		text-align: justify !important;
		text-justify: inter-word;
	}
    body {
    	display: flex;
    	min-height: 100vh;
    	flex-direction: column;
    }

    main {
    	flex: 1 0 auto;
    }

    body {
    	background: #fff;
    }

    .input-field input[type=date]:focus + label,
    .input-field input[type=text]:focus + label,
    .input-field input[type=email]:focus + label,
    .input-field input[type=password]:focus + label {
    	color: #e91e63;
    }

    .input-field input[type=date]:focus,
    .input-field input[type=text]:focus,
    .input-field input[type=email]:focus,
    .input-field input[type=password]:focus {
	    border-bottom: 2px solid #e91e63;
	    box-shadow: none;
    }
  </style>
</head>
<body>
  <div class="section no-pad-bot" id="index-banner">
    <div class="section"></div>
  	<main>
	  <center>
	    <div class="section"></div>
	    <div class="section"></div>
	    <div class="container">
	      <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
	        <div class="col s12">
	          <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='name' id='name' />
	              <label for='name'>Usuario</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='password' name='password' id='password' />
	              <label for='password'>Contraseña</label>
	            </div>
	          </div>
	
	          <br />
	          <center>
	            <div class='row'>
	              <button type='submit' name='btn_login' 
	              		class='col s12 btn btn-large waves-effect red'
	              		onclick="verifyLogin();$('#loader').show();">
	              	Ingresar
	              </button>
	            </div>
	          </center>
	        </div>
	      </div>
	    </div>
	  </center>
	
	  <div class="section"></div>
	  <div class="section"></div>
	  
	  <div class="progress" id="loader">
      	<div class="indeterminate"></div>
  	  </div>
	  
	</main>
  </div>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
  <script src="<c:url value="/resources/js/jquery-cookie.js"/>"></script>
  <script src="<c:url value="/resources/js/login.js"/>" charset="utf-8"></script>
  </body>
</html>
