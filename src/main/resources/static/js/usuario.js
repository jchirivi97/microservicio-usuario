var usuario = (function() {
	var status = 0;
	var login = function() {
		var user = document.getElementById("user").value;
		var password = document.getElementById("pass").value;
		apiUsuario.loginUser(user, password);
		sessionStorage.setItem("usuario", user);
	};

	var lista = function() {
		apiUsuario.ListaReproduccion(sessionStorage.getItem('usuario'),
				mostrarReproduccion);
	};

	var mostrarReproduccion = function(datos) {
		var columnT = '<tr><th scope="col"><center>' + datos[0].nombre
				+ '</center></th></tr>'
		$("table thead").append(columnT);

		var column = '<tr><th scope="col">Nombre</th><th scope="col">Audio</th></tr>'
		$("table thead").append(column);

		listaCanciones(datos[0].nombre);
	};

	var listaCanciones = function(nombre) {
		apiUsuario.ListaCanciones(sessionStorage.getItem('usuario'),nombre,mostrarCanciones);
	};

	var mostrarCanciones = function(datos) {
		for (var i = 0; i < datos.length; i++) {
			var column = '<tr><th scope="col">'
					+ datos[i].nombre
					+ '</th><th scope="col">'
					+ '<div class="col-md-12">'
					+ '<audio id="audio" preload="auto"></audio>'
					+ '<div class="btn-group">'
					+'<button onclick="usuario.play(\'' + datos[i].contenido +'\''+','+'\''+ 'audio' +'\');" class="btn btn-custom"><span title="Play" id="play" class="glyphicon glyphicon-play aligned"></span></button>'
					+'<button onclick="usuario.stop(\'' + datos[i].contenido +'\''+','+'\''+ 'audio' +'\');" class="btn btn-custom"><span title="Stop" id="stop" class="glyphicon glyphicon-stop aligned"></span></button>' 
					+'<button onclick="usuario.volUP(\'' + datos[i].contenido +'\''+','+'\''+ 'audio' +'\');" class="btn btn-custom"><span title="Volumen Up" id="volumenup" class="glyphicon glyphicon-plus aligned"></span></button>'
					+'<button onclick="usuario.volDown(\'' + datos[i].contenido +'\''+','+'\''+ 'audio' +'\');" class="btn btn-custom"><span title="Volumen Down" id="volumendown" class="glyphicon glyphicon-minus aligned"></span></button>' 
					+ '</div>' + '</div>' + '</th></tr>'

			$("table tbody").append(column);
			
		}
	};
	
	var Play = function(music,id) {
	    var audio = $("#"+id); 
		if(status == 0 || status == 2)
		{     
			if(status == 0) audio.attr("src", music);
			audio[0].play();
			$("#play").attr("class","glyphicon glyphicon-pause aligned")
			status = 1;
		} else if(status == 1) {    
			audio[0].pause();
			$("#play").attr("class","glyphicon glyphicon-play aligned")
			status = 2;
		}
	}
	var Stop = function (music,id) {
		var audio = $("#"+id);
		audio.attr("src", '');
		$("#play").attr("class","glyphicon glyphicon-play aligned")
		status = 0;
	}
	var VolumeUp = function (music,id) {
		var audio = $("#"+id);
		var volume = $("#"+id).prop("volume")+0.1;
		if(volume > 1) volume = 1;
	    $("#"+id).prop("volume",volume);
	}
	var VolumeDown = function (music,id) {
		var audio = $("#"+id);
		var volume = $("#"+id).prop("volume")-0.1;
		if(volume < 0) volume = 0;
	    $("#"+id).prop("volume",volume);
	}

	return {

		ingresar : login,
		listas : lista,
		play : Play,
		stop : Stop,
		volUP : VolumeUp,
		volDown : VolumeDown
	}

})()