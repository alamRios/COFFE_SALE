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
      	<li><a href="empleados" onclick="$('#loader').show();">EMPLEADOS</a></li>
      	<li class="active"><a href="productos" onclick="$('#loader').show();">PRODUCTOS</a></li>
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
		      <h3 class="header center blue-grey-text text-lighten-2" id="msgBienvenida">Productos </h3>
		      <div class="row center">
		        <h5 class="header col s12 light">Aquí encontrarás los productos registrados a tu línea.<br/>
		        Puedes modificar los datos de cada uno o añadir nuevos.</h5>
		      </div>
		    </div>
		  </div>
	    <div class="section">
			<table class="striped bordered" style="text-transform: uppercase;" >
		      <thead>
		         <tr><th>Código</th><th>Nombre</th><th>Costo</th><th> </th></tr>
		      </thead>
		      <tbody id="listaProductos">
		      </tbody>
	       </table>
	    </div>
	    
	    <a class="btn-floating right btn-large waves-effect waves-light red" href="#mdlRegistro"><i class="material-icons">add</i></a>
	    
	     <!-- Modal de Registro para productos -->
		  <div id="mdlRegistro" class="modal">
		    <div class="modal-content">
		      <h4>Añadir producto nuevo</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='nombrePNuevo' id='nombrePNuevo' />
	              <label for='nombrePNuevo'>Nombre</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='number' name='costoPNuevo' id='costoPNuevo' />
	              <label for='costoPNuevo'>Costo</label>
	            </div>
	          </div>
		    </div>
		    <div class="modal-footer">
		      <a class="modal-action  waves-effect waves-green btn-flat" onclick="registrarPNuevo();">Registrar</a>
		      <a class="modal-action modal-close waves-effect red btn-flat">Cancelar</a>
		    </div>
		  </div>
		  
		  <!-- Modal de edición de productos -->
		  <div id="mdlEdicion" class="modal">
		    <div class="modal-content">
		      <h4>Añadir producto nuevo</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12' id="divNomPEdi">
	              <input class='validate' type='text' name='nombrePEdicion' id='nombrePEdicion' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divCostPEdi">
	              <input class='validate' type='number' name='costoPEdicion' id='costoPEdicion' />
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
  <script src="<c:url value="/resources/js/productos.js"/>" charset="utf-8"></script>
  </body>
</html>
