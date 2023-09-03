var mymap = L.map('mapii').setView([51.505, -0.09], 13);


    // Agregar capa de OpenStreetMap al mapa
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18,
    }).addTo(mymap);

    // Obtener las coordenadas del modelo


    // Agregar los marcadores al mapa
    for (var i = 0; i < producto1.length; i++) {
        var coordenada = producto1[i];

        // Crear el contenido del popup
        var contenidoPopup = "<b>Nombre:</b> " + coordenada.nombre + "<br>" +
                             "<b>Correo:</b> " + coordenada.fechaCreacion + "<br>" +
                             "<b>Cédula:</b> " + coordenada.imagen;

        // Agregar el marcador con el popup al mapa
        L.marker([parseFloat(coordenada.estado), parseFloat(coordenada.fechaModificacion)])
         .bindPopup(contenidoPopup)
         .addTo(feature_group_46b3488c1943b112ae03fdd7afdaad2b);
    }

