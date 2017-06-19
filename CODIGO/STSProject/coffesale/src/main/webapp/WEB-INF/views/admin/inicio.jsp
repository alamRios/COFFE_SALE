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
    	display: flex !important;
    	min-height: 100vh !important;
    	flex-direction: column !important;
	}
	main {
		flex: 1 0 auto !important;
	}
  </style>
</head>
<body>
  <nav class="red lighten-2" role="navigation">
    <div class="nav-wrapper container">
    <a id="logo-container" href="#" class="brand-logo">COFFE SALE</a>
    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      	<li><a href="cafeterias" onclick="$('#loader').show();">CAFETERIAS</a></li>
      	<li><a href="empleados" onclick="$('#loader').show();">EMPLEADOS</a></li>
      	<li><a href="productos" onclick="$('#loader').show();">PRODUCTOS</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="cafeterias" onclick="$('#loader').show();">CAFETERIAS</a></li>
      	<li><a href="empleados" onclick="$('#loader').show();">EMPLEADOS</a></li>
      	<li><a href="productos" onclick="$('#loader').show();">PRODUCTOS</a></li>
      </ul>
    </div>
  </nav>
  <main>
	  <div class="section no-pad-bot" id="index-banner">
	    <div class="container">
	      <br><br>
	      <h3 class="header center blue-grey-text text-lighten-2" id="msgBienvenida">Bienvenido: </h3>
	      <div class="row center">
	        <h5 class="header col s12 light">Utiliza el menú de arriba para navegar
	        entre las opciones del sistema.</h5>
	      </div>
	    </div>
	  </div>
	      <br><br>
	
	    <div class="section">
	    </div>
	    
	    <div class="progress" id="loader">
	      	<div class="indeterminate"></div>
	  	  </div>
  </main>
  <footer class="page-footer red darken-4">
  	<div class="container">
      <div class="row">
        <div class="col l6 s12">
        </div>
        <div class="col l3 s12">
        </div>
        <div class="col l3 s12">
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Entrega en el transcurso del semestre 2017/2 por Alam Ríos y Alejandro Maguey
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
  <script src="<c:url value="/resources/js/jquery-cookie.js"/>"></script>
  <script src="<c:url value="/resources/js/inicio.js"/>" charset="utf-8"></script>
  </body>
</html>
