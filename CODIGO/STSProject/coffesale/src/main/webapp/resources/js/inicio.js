$(document).ready(function(){	
	if(Cookies.get('nombre'))
		$.ajax({
			type: "GET",
			contentType: "application/json",
	        url: "/rest/empleados/usuarios/"+Cookies.get('nombre'),
	        success: function(data){
	        	console.log(data);
	        	$("#msgBienvenida").append((' '+data.nombre + ' ' +data.apPaterno).toUpperCase());
	        	$('#loader').hide();
	        	$(".button-collapse").sideNav();
	        },
	        failure: function(errMsg){
	        	console.log(errMsg);
	        },
	        error: function (jqXHR, status) {
	            console.log(jqXHR);
	        }
	    });
	else
		$(window).attr("location", "login");
});
