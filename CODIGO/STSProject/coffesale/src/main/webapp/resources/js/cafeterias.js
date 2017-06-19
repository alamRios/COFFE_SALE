$(document).ready(function(){
	if(Cookies.get('lineaId'))
		$.ajax({
			type: "GET",
			contentType: "application/json",
	        url: "/rest/cafeterias/"+Cookies.get('lineaId'),
	        success: function(data){
	        	for(var i in data){
	        		$('#listaCafeterias').append(
			        		'<tr>'+
			        			'<td>'+
			        				data[i].nombre +
			        			'</td>'+
			        			'<td>'+
			        				data[i].direccion+
			        			'</td>'+
			        			'<td>'+
			        				data[i].email+
			        			'</td>'+
			        			'<td>'+
		        					(data[i].aceptaMembresias ? 'ACEPTA':'NO ACEPTA')+
		        				'</td>'+
			        			'<td>'+
		        					'<button class="btn waves-effect red" type="submit" name="action"'+
			        					' onclick="editarCafeteria('+
			        							data[i].identificador+','+
			        							'\''+data[i].nombre+'\''+','+
			        							'\''+data[i].direccion+'\''+','+
			        							'\''+data[i].email+'\''+
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

function registrarCafeteria(){
	var nc_nombre = $('#nombreCNueva').val(); 
	var nc_aceptaMembresias = $('#membresiasCNueva').val() == 'on'? true : false; 
	var nc_estado = $('#estadoCNueva').val();
	var nc_email = $('#emailCNueva').val();
	var nc_calle = $('#calleCNueva').val();
	var nc_numero = $('#numCNueva').val();
	var nc_colonia = $('#coloniaCNueva').val();
	var nc_delegacion = $('#delegacionCNueva').val();
	var nc_pais = $('#paisCNueva').val();
	
	var nCafeteria = {
		"nombre":nc_nombre,
		"linea":Cookies.get('lineaId'),
		"identificador":"",
		"aceptaMembresias":nc_aceptaMembresias,
		"email":nc_email,
		"direccion":nc_calle+","+nc_numero+","+nc_colonia+","+nc_delegacion+","+nc_estado+","+nc_pais
	}
	
	$.ajax({
		type: "POST",
		data: JSON.stringify(nCafeteria),
		contentType: "application/json",
        url: "/rest/cafeterias/create",
        success: function(data){
        	if(data.identificador != 0){
	        	$(window).attr("location", "cafeterias");
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

function editarCafeteria(cafeteriaId,nombre,direccion,email){
	Cookies.set('cafeteriaEdicionId',cafeteriaId);
	var direccionAr = direccion.split(' ');
	$('#divNomEdi').append('<label for="nombreCEditada">'+nombre+'</label>');
	$('#divEstadoEdi').append('<label for="estadoCEditada">'+direccionAr[6].replace(',','')+'</label>');
	$('#divEmailEdi').append('<label for="emailCEditada">'+email+'</label>');
	$('#divCalleEdi').append('<label for="calleCEditada">'+direccionAr[0]+'</label>');
	$('#divNumEdi').append('<label for="numCEditada">'+direccionAr[1].replace('#','')+'</label>');
	$('#divColoniaEdi').append('<label for="coloniaCEditada">'+direccionAr[3]+'</label>');
	$('#divDelegacionEdi').append('<label for="delegacionCEditada">'+direccionAr[5].replace(',','')+'</label>');
	$('#divPaisEdi').append('<label for="paisCEditada">'+direccionAr[7]+'</label>');
	$('#mdlEdicion').modal('open');
}

function terminarEdicion(){
	var cafeteriaEditada = {
			"nombre":$('#nombreCEditada').val().replace(/ /g,'-'),
			"linea":Cookies.get('lineaId'),
			"identificador":Cookies.get('cafeteriaEdicionId'),
			"aceptaMembresias":($('#membresiasCEditada').val() == 'on'?true:false),
			"email":$('#emailCEditada').val(),
			"direccion":$('#calleCEditada').val().replace(/ /g,'-')+","+$('#numCEditada').val()+
				","+$('#coloniaCEditada').val().replace(/ /g,'-')+","+$('#delegacionCEditada').val().replace(/ /g,'-')+
				","+$('#estadoCEditada').val().replace(/ /g,'-')+","+$('#paisCEditada').val().replace(/ /g,'-')
		}
	console.log(JSON.stringify(cafeteriaEditada));
	$.ajax({
		type: "PUT",
		data: JSON.stringify(cafeteriaEditada),
		contentType: "application/json",
        url: "/rest/cafeterias/update",
        success: function(data){
        	if(data.identificador != 0){
	        	$(window).attr("location", "cafeterias");
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

