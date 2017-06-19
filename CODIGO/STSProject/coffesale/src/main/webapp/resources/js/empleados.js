$(document).ready(function(){	
	if(Cookies.get('nombre'))
		$.ajax({
			type: "GET",
			contentType: "application/json",
	        url: "/rest/empleados/"+Cookies.get('lineaId'),
	        success: function(data){
	        	for(var i in data){
	        		$('#listaEmpleados').append(
	        				'<tr>'+
			        		'<td>'+
		        				data[i].codigoEmpleado +
		        			'</td>'+
		        			'<td>'+
		        				data[i].nombre +' '+
		        				data[i].apPaterno +' '+
		        				data[i].apMaterno +  
		        			'</td>'+
		        			'<td>'+
	        					data[i].puesto+
	        				'</td>'+
		        			'<td>'+
	        					data[i].correo+
	        				'</td>'+
		        			'<td>'+
	        					'<button class="btn waves-effect red" type="submit" name="action"'+
		        					' onclick="editarEmpleado('+
		        							data[i].codigoEmpleado+','+
		        							'\''+data[i].nombre+'\''+','+
		        							'\''+data[i].apPaterno+'\''+','+
		        							'\''+data[i].apMaterno+'\''+','+
		        							'\''+data[i].puesto+'\''+','+
		        							'\''+data[i].correo+'\''+
		        						');" >'+
		        						'Editar'+
		        						'<i class="material-icons right">mode_edit</i>'+
	        					'</button>'+
	        				'</td>'+
		        		'</tr>'
			        	);
	        	}
	        	
	        	$('#loader').hide();
	        	$(".button-collapse").sideNav();
		        $('.modal').modal();
		        $('select').material_select();
		        
		        cargarPuestos();
		        cargarPuestosEditar();
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

function cargarPuestos(){
	$.ajax({
		type: "GET",
		contentType: "application/json",
        url: "/rest/util/puestos",
        success: function(data){
        	for(var i in data){
        		$('#listaDePuestosCrear').append(
        			'<option value="'+
        				data[i].id +
        			'">'+
        				data[i].nombre +
        			'</option>'
        		);
        		$('#listaDePuestosCrear').trigger('contentChanged');
        		$('#listaDePuestosCrear').on('contentChanged',function(){
        			$(this).material_select();
        		});
        	}
        },
        failure: function(errMsg){
        	console.log(errMsg);
        },
        error: function (jqXHR, status) {
            console.log(jqXHR);
        }
    });
}

function cargarPuestosEditar(){
	$.ajax({
		type: "GET",
		contentType: "application/json",
        url: "/rest/util/puestos",
        success: function(data){
        	for(var i in data){
        		$('#listaDePuestosEditar').append(
        			'<option value="'+
        				data[i].id +
        			'">'+
        				data[i].nombre +
        			'</option>'
        		);
        		
        		$('#listaDePuestosEditar').trigger('contentChanged');
        		$('#listaDePuestosEditar').on('contentChanged',function(){
        			$('select').material_select();
        		});
        	}
        },
        failure: function(errMsg){
        	console.log(errMsg);
        },
        error: function (jqXHR, status) {
            console.log(jqXHR);
        }
    });
}

function registrarEmpleado(){
	var empleadoNuevo = {
		"codigoEmpleado": Cookies.get('lineaId'),
		"nombre":$('#nombreENuevo').val(),
		"apPaterno":$('#appaternoENuevo').val(),
		"apMaterno":$('#apmaternoENuevo').val(),
		"correo":$('#correoENuevo').val(),
		"puesto":$('#listaDePuestosCrear').val()
	}
	
	console.log(empleadoNuevo);
	
	$.ajax({
		type: "POST",
		data: JSON.stringify(empleadoNuevo),
		contentType: "application/json",
        url: "/rest/empleados/create",
        success: function(data){
        	if(data.identificador != 0){
	        	$(window).attr("location", "empleados");
	        }else{
	        	Materialize.toast('Ha ocurrido un error', 3000, 'red');
	        	$('#loader').hide();
	        }
        },
        failure: function(errMsg){
        	console.log(errMsg);
        },
        error: function (jqXHR, status) {
            console.log(jqXHR);
        }
    });
}

function editarEmpleado(codigo,nombre,appaterno,apmaterno,puesto,correo){
	Cookies.set('empleadoEnEdicion',codigo);
	
	$('#divNomEEd').append('<label for="nombreEEditado">'+nombre+'</label>');
	$('#divApPEEd').append('<label for="appaternoEEditado">'+appaterno+'</label>');
	$('#divApMEEd').append('<label for="apmaternoEEditado">'+apmaterno+'</label>');
	$('#divEmaEEd').append('<label for="correoEEditado">'+correo+'</label>');
	
	$('#mdlEdicion').modal('open');
}

function terminarEdicion(){
	var empleadoEditado = {
			"codigoEmpleado": Cookies.get('empleadoEnEdicion')*1,
			"nombre":$('#nombreEEditado').val(),
			"apPaterno":$('#appaternoEEditado').val(),
			"apMaterno":$('#apmaternoEEditado').val(),
			"correo":$('#correoEEditado').val(),
			"puesto":$('#listaDePuestosEditar').val()
		}
	
	console.log(empleadoEditado);
	
	$.ajax({
		type: "PUT",
		data: JSON.stringify(empleadoEditado),
		contentType: "application/json",
        url: "/rest/empleados/update",
        success: function(data){
        	if(data.codigoEmpleado != 0){
	        	$(window).attr("location", "empleados");
	        }else{
	        	Materialize.toast('Ha ocurrido un error', 3000, 'red');
	        	$('#loader').hide();
	        }
        },
        failure: function(errMsg){
        	console.log(errMsg);
        },
        error: function (jqXHR, status) {
            console.log(jqXHR);
        }
    });
}