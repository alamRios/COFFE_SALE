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
    <a id="logo-container" href="inicio" class="brand-logo">COFFE SALE</a>
    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      	<li><a href="cafeterias" onclick="$('#loader').show();">CAFETERIAS</a></li>
      	<li class="active"><a href="empleados" onclick="$('#loader').show();">EMPLEADOS</a></li>
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
	      <h3 class="header center blue-grey-text text-lighten-2" id="msgBienvenida">Empelados</h3>
	      <div class="row center">
	        <h5 class="header col s12 light">Aquí encontrarás toda la información de los empleados en las cafeterías de la línea. 
	        <br/> Puedes añadir empleados, editar datos de los existentes o sólo consultarlos.</h5>
	      </div>
	    </div>
	  </div>
	      <br><br>
	
	    <div class="section">
	    	<table class="striped bordered" style="text-transform: uppercase;" >
		      <thead>
		         <tr><th>Código</th><th>Nombre</th><th>Puesto</th><th>Correo</th><th> </th></tr>
		      </thead>
		      <tbody id="listaEmpleados">
		      </tbody>
	       	</table>
	    </div>
	    
	    <a class="btn-floating right btn-large waves-effect waves-light red" href="#mdlRegistro"><i class="material-icons">add</i></a>
	    
	     <!-- Modal de Registro para empleados -->
		  <div id="mdlRegistro" class="modal">
		    <div class="modal-content">
		      <h4>Añadir empleado nuevo</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='nombreENuevo' id='nombreENuevo' />
	              <label for='nombreENuevo'>Nombre</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='appaternoENuevo' id='appaternoENuevo' />
	              <label for='appaternoENuevo'>Apellido paterno</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='apmaternoENuevo' id='apmaternoENuevo' />
	              <label for='apmaternoENuevo'>Apellido materno</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='email' name='correoENuevo' id='correoENuevo' />
	              <label for='correoENuevo'>Correo</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
				    <select id="listaDePuestosCrear">
				      <option value="" disabled selected>Escoja un puesto</option>
				      <option value="1">Barista</option>
				    </select>
				    <label for="listaDePuestosCrear">Puestos</label>
	            </div>
	          </div>
		    </div>
		    <div class="modal-footer">
		      <a class="modal-action  waves-effect waves-green btn-flat" onclick="registrarEmpleado();">Registrar</a>
		      <a class="modal-action modal-close waves-effect red btn-flat">Cancelar</a>
		    </div>
		  </div>
	    
	    <!-- Modal de Edición para empleados -->
		  <div id="mdlEdicion" class="modal">
		    <div class="modal-content">
		      <h4>Editar empleado</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12' id="divNomEEd">
	              <input class='validate' type='text' name='nombreEEditado' id='nombreEEditado' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divApPEEd">
	              <input class='validate' type='text' name='appaternoEEditado' id='appaternoEEditado' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divApMEEd">
	              <input class='validate' type='text' name='apmaternoEEditado' id='apmaternoEEditado' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divEmaEEd">
	              <input class='validate' type='email' name='correoEEditado' id='correoEEditado' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
				    <select id="listaDePuestosEditar">
				      <option value="" disabled selected>Escoja un puesto</option>
				      <option value="1">Barista</option>
				    </select>
				    <label for="listaDePuestosEditar">Puestos</label>
	            </div>
	          </div>
		    </div>
		    <div class="modal-footer">
		      <a class="modal-action  waves-effect waves-green btn-flat" onclick="terminarEdicion();">Guardar</a>
		      <a class="modal-action modal-close waves-effect red btn-flat">Cancelar</a>
		    </div>
		  </div>
	    
	    <div class="progress" id="loader">
	      	<div class="indeterminate"></div>
	  	  </div>
  </main>
  <br/><br/>
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
  <script src="<c:url value="/resources/js/empleados.js"/>" charset="utf-8"></script>
  </body>
</html>
