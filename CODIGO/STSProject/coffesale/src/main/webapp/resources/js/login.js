$(document).ready(function(){
	$('#loader').hide();
});

function verifyLogin(){
	var usr_nom = $('#name').val();
	var usr_pass = $('#password').val();
	
	var usuario = new Usuario(usr_nom,usr_pass,0);
	
	$.ajax({
		type: "POST",
		data: JSON.stringify(usuario),
		contentType: "application/json",
        url: "/rest/usuarios/login",
        success: function(data){
        	if(data.lineaId != 0){
	        	Cookies.set('lineaId',data.lineaId);
	        	Cookies.set('nombre',data.nombre);
	        	$(window).attr("location", "inicio");
	        }else{
	        	Materialize.toast('Usuario o Password no valido', 3000, 'red');
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

function Usuario(usr_nom,usr_pass,lineaId){
	this.nombre = usr_nom;
	this.password = usr_pass;
	this.lineaId = lineaId; 
}