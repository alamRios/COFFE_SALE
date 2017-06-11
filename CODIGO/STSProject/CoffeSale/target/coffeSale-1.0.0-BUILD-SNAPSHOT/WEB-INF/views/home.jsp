<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Coffe Sale</title>
	<!-- Latest compiled and minified CSS -->
	<meta charset="utf-8"> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">COFFE SALE</a>
	    </div>
	  </div>
	</nav>
	
	<div class="well">
      <h1>Coffe Sale</h1> 
      <p>es una aplicación que permite a lineas de cafeterias llevar la administración de todas su sucursales, contando con punto de venta, administraciòn de personal, administración de ventas y control general de inventario.</p>
    </div>
	
	<footer class="footer">
      <div class="container">
        <p class="text-muted">Tiempo en servidor: ${serverTime}.</p>
      </div>
    </footer>
</body>
</html>
