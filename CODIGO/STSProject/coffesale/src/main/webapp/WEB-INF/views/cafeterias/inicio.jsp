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
      	<li class="active"><a href="cafeterias" onclick="$('#loader').show();">CAFETERIAS</a></li>
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
	      <h3 class="header center blue-grey-text text-lighten-2" id="msgBienvenida">Cafeterias</h3>
	      <div class="row center">
	        <h5 class="header col s12 light">Aquí encontrarás toda la información de las cafeterías de la línea. 
	        <br/> Puedes crear cafeterias, editar datos de las existentes o sólo consultarlos.</h5>
	      </div>
	    </div>
	  </div>
	      <br><br>
	
	    <div class="section">
	    	<table class="striped bordered" style="text-transform: uppercase;" >
		      <thead>
		         <tr><th>Nombre</th><th>Direccion</th><th>Correo</th><th>Membresias</th><th> </th></tr>
		      </thead>
		      <tbody id="listaCafeterias">
		      </tbody>
	       	</table>
	    </div>
	    
	    <a class="btn-floating right btn-large waves-effect waves-light red" href="#mdlRegistro"><i class="material-icons">add</i></a>
	    
	     <!-- Modal de Registro para cafeterias -->
		  <div id="mdlRegistro" class="modal">
		    <div class="modal-content">
		      <h4>Añadir cafeteria nueva</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='nombreCNueva' id='nombreCNueva' />
	              <label for='nombreCNueva'>Nombre</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <div class="switch">
				    <label>
				      NO ACEPTA MEMBRESIAS
				      <input type="checkbox" name="membresiasCNueva" id="membresiasCNueva">
				      <span class="lever"></span>
				      ACEPTA MEMBRESIAS
				    </label>
				  </div>
	            </div>
	          </div><br/>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='estadoCNueva' id='estadoCNueva' />
	              <label for='estadoCNueva'>Estado</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='email' name='emailCNueva' id='emailCNueva' />
	              <label for='emailCNueva'>E-mail</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='calleCNueva' id='calleCNueva' />
	              <label for='calleCNueva'>Calle</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='number' name='numCNueva' id='numCNueva' />
	              <label for='numCNueva'>No.</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='coloniaCNueva' id='coloniaCNueva' />
	              <label for='coloniaCNueva'>Colonia</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='delegacionCNueva' id='delegacionCNueva' />
	              <label for='delegacionCNueva'>Delegación</label>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12'>
	              <input class='validate' type='text' name='paisCNueva' id='paisCNueva' />
	              <label for='paisCNueva'>País</label>
	            </div>
	          </div>
		    </div>
		    <div class="modal-footer">
		      <a class="modal-action  waves-effect waves-green btn-flat" onclick="registrarCafeteria();">Registrar</a>
		      <a class="modal-action modal-close waves-effect red btn-flat">Cancelar</a>
		    </div>
		  </div>
	    
	    <!-- Modal de Edición para cafeterias -->
		  <div id="mdlEdicion" class="modal">
		    <div class="modal-content">
		      <h4>Editar cafeteria</h4>
		      <div class='row'>
	            <div class='col s12'></div>
	          </div>	
	          <div class='row'>
	            <div class='input-field col s12' id="divNomEdi">
	              <input class='validate' type='text' name='nombreCEditada' id='nombreCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divMembresiaEdi">
	              <div class="switch">
				    <label>
				      NO ACEPTA MEMBRESIAS
				      <input type="checkbox" name="membresiasCEditada" id="membresiasCEditada">
				      <span class="lever"></span>
				      ACEPTA MEMBRESIAS
				    </label>
				  </div>
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divEstadoEdi">
	              <input class='validate' type='text' name='estadoCEditada' id='estadoCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divEmailEdi">
	              <input class='validate' type='email' name='emailCEditada' id='emailCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divCalleEdi">
	              <input class='validate' type='text' name='calleCEditada' id='calleCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divNumEdi">
	              <input class='validate' type='number' name='numCEditada' id='numCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divColoniaEdi">
	              <input class='validate' type='text' name='coloniaCEditada' id='coloniaCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divDelegacionEdi">
	              <input class='validate' type='text' name='delegacionCEditada' id='delegacionCEditada' />
	            </div>
	          </div>
	          <div class='row'>
	            <div class='input-field col s12' id="divPaisEdi">
	              <input class='validate' type='text' name='paisCEditada' id='paisCEditada' />
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
  <script src="<c:url value="/resources/js/cafeterias.js"/>" charset="utf-8"></script>
  </body>
</html>
