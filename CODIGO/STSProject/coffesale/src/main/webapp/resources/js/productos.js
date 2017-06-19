$(document).ready(function(){
	if(Cookies.get('lineaId'))
		$.ajax({
			type: "GET",
			contentType: "application/json",
	        url: "/rest/productos/"+Cookies.get('lineaId'),
	        success: function(data){
	        	for(var i in data){
	        		$('#listaProductos').append(
			        		'<tr>'+
			        			'<td>'+
			        				data[i].identificador +
			        			'</td>'+
			        			'<td>'+
			        				data[i].nombre+
			        			'</td>'+
			        			'<td>'+
			        				'$'+data[i].costo+
			        			'</td>'+
			        			'<td>'+
		        					'<button class="btn waves-effect red" type="submit" name="action"'+
			        					' onclick="editarProducto('+data[i].identificador+','+
			        						'\''+data[i].nombre+'\','+data[i].costo+');" >'+
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

function registrarPNuevo(){
	var nombrePNuevo = $('#nombrePNuevo').val();
	var costoPNuevo = $('#costoPNuevo').val();
	
	if(nombrePNuevo == '' || costoPNuevo == ''
		|| nombrePNuevo == ' ' || costoPNuevo == ' '){
		Materialize.toast('Debe llenar los campos', 3000, 'red');
	}else{	
		pNuevo = {
			"codigoLinea":Cookies.get('lineaId')*1,
			"costo":costoPNuevo * 1,
			"identificador":'',
			"nombre":nombrePNuevo
		}
		
		console.log(JSON.stringify(pNuevo));
		
		if(nombrePNuevo && costoPNuevo){
			$.ajax({
				type: "POST",
				data: JSON.stringify(pNuevo),
				contentType: "application/json",
		        url: "/rest/productos/create",
		        success: function(data){
		        	if(data.identificador != 0){
			        	$(window).attr("location", "productos");
			        }else{
			        	Materialize.toast('Hubo un problema al registrar producto', 3000, 'red');
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
	}
}

function editarProducto(identificador,nombre,costo){
	Cookies.set('productoEdicionId',identificador);
	$('#divNomPEdi').append('<label for="nombrePEdicion">'+nombre+'</label>');
	$('#divCostPEdi').append('<label for="costoPEdicion">'+costo+'</label>');
	$('#mdlEdicion').modal('open');
}

function terminarEdicion(){
	var nombrePNuevo = $('#nombrePEdicion').val();
	var costoPNuevo = $('#costoPEdicion').val();
	
	if(nombrePNuevo == '' || costoPNuevo == ''
		|| nombrePNuevo == ' ' || costoPNuevo == ' '){
		Materialize.toast('Debe llenar los campos', 3000, 'red');
	}else{	
		pNuevo = {
			"codigoLinea":Cookies.get('lineaId')*1,
			"costo":costoPNuevo * 1,
			"identificador":Cookies.get('productoEdicionId'),
			"nombre":nombrePNuevo
		}
		
		console.log(JSON.stringify(pNuevo));
		
		if(nombrePNuevo && costoPNuevo){
			$.ajax({
				type: "PUT",
				data: JSON.stringify(pNuevo),
				contentType: "application/json",
		        url: "/rest/productos/update",
		        success: function(data){
		        	if(data.identificador != 0){
		        		Cookies.remove('productoEdicionId');
			        	$(window).attr("location", "productos");
			        }else{
			        	Materialize.toast('Hubo un problema al actualizar producto', 3000, 'red');
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
	}
}