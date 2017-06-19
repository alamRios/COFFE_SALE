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
  </style>
</head>
<body>
  <nav class="red lighten-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">COFFE SALE</a>
      <ul class="right hide-on-med-and-down">
      </ul>
    </div>
  </nav>
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-grey-text text-lighten-2">El sistema para tu cafetería</h1>
      <div class="row center">
        <h5 class="header col s12 light"><a class="red-text text-lighten-3">Coffe Sale</a> es un sistema diseñado especialmente para llevar la administración de lineas de cafetería desde cualquier dispositivo <a class="green-text text-lighten-2">Android</a>.<br/> Implementable el mismo día que lo solicites. </h5>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="section">
      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center red-text"><i class="material-icons">perm_identity</i></h2>
            <h5 class="center">Todo lo que necesitas</h5>

            <p class="light">Contamos con un sistema para el administrador de la línea de cafeterías, un sistema para los moderadores y un punto de venta que te permitirá tener integrado todo el proceso de negocios. De manera que cada movimiento se verá reflejado para todos.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center blue-text"><i class="material-icons">work</i></h2>
            <h5 class="center">Optimiza tu negocio</h5>

            <p class="light">Coffe Sale te permite administrar todos los movimientos en tu línea de cafeterías, de tal manera que sin importar cuantas sucursales tengas, siempre tendrás disponible la información y podrás realizar los movimientos administrativos necesarios para mantener tu negocio actualizado.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center green-text"><i class="material-icons">android</i></h2>
            <h5 class="center">Disponible en Android</h5>

            <p class="light">El enfoque principal del proyecto está en poder realizar el registro de ventas, movimientos de empleados, gestión de inventarios y monitoreo de finanzas desde cualquier dispositivo.</p>
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div class="section">

    </div>
  </div>

  <footer class="page-footer red darken-4">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Desarrollado en <b>IPN</b> - <b>ESCOM</b></h5>
          <p class="grey-text text-lighten-4">Proyecto realizado por <b>Alam Ríos</b> y <b>Alejandro Maguey</b> para la unidad de aprendizaje de <i>Programación Orientada a Objetos</i> a cargo del profesor <b>M. en C. Saúl De la O</b>.</p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Contacto</h5>
	          <ul>
	            <li><a class="grey-text text-lighten-2" href="https://github.com/alamRios">alamRios@GitHub</a></li>
	            <li><a class="grey-text text-lighten-2" href="https://github.com/AlexMaguey">AlexMaguey@GitHub</a></li>
	          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Desarrollo Java</h5>
          <p class="grey-text text-lighten-4">Desarrollo completamente en Java. API-REST desarrollada por Alam Ríos y plataforma Android por Alejandro Maguey</p>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Entrega en el transcurso del semestre 2017/2
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
  </body>
</html>
