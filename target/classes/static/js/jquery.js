// ESTE FUNCION ENVIA EL DEPARTEMENTO Y RETORna
//SOLO SE EJECUTA SI HAY UN CAMBIO
//<!--JQUERY___$( ".select-location" )=VERIFICA QUE ELEMENTO CON LA CLASE TENGA UN CAMBIO(change)-->
$( ".select-location" ).change(
//<!--JQUERY___loadCity=FUNCION QUE LLAMO AL HABER CAMBIOS EN EL SELECT ( ".select-location" ) -->

function loadCity() {
    //<!--departament=  VALOR OBTENIDO DEL SELECT-->
    var departament=$(".select-location").val();
    //<!--$.ajax=ACEDO AL METODO-->
    console.log(departament)
    var dato={"departament":departament}
    console.log(dato)

//$.ajax({= SENTENCIA AJAX
     $.ajax({
     //type= METODO PARA ENVIAR INFORMACION
                type: "GET",
     //contentType= FORMATO DE ENVIO POR URL(FORMA )
                contentType: "application/json",
     //url= UBICACION ENDPOINT
                url: "/city/searchCity",
     //data=informacion envidad
                data: dato,
     //dataType=formato de retorno
                dataType: 'json',
     //success=DATO RETORNADO
                success: function (data) {
                                //$(".select2").empty()=UBICACION DEL SELECT A LLENAR
                                $(".select2").empty();
                                //for= RECORRO EL JSON
                                for(var i=0;i < data.length;i++)
                                {
                                //newrow= VARIABEL QUE AGREGA LOS OBJETOS
                                var newrow ="<option id="+data[i].id+" value="+data[i].id+">"+data[i].nombre+"</option>";
                                //SE AGREGAN LAS OPCIONES
                                 $(newrow).appendTo(".select2");


                                 //UBICACION DE LA CIUDAD

                                }}
            });

});


// ESTE FUNCION ENVIA EL CIUDAD Y CATEGORIA  Y RETORNA LAS PROVVEDORES___________________________________________________________
//SOLO SE EJECUTA SI HAY UN CAMBIO
$( ".select3" ).change(
//JQUERY___loadCity=FUNCION QUE LLAMO AL HABER CAMBIOS EN EL SELECT ( ".select-location" )

function loadSupplier() {
    //<!--departament=  VALOR OBTENIDO DEL SELECT-->
    var citys=$(".select2").val();
    var category=$(".select3").val();
    console.log(category)
//CREA UN DATO EN FORMATO JSON
    var dato={"city":citys,"category":category}
    console.log(dato)

//$.ajax({= SENTENCIA AJAX
     $.ajax({
     //type= METODO PARA ENVIAR INFORMACION
                type: "GET",
     //contentType= FORMATO DE ENVIO POR URL(FORMA )
                contentType: "application/json",
     //url= UBICACION ENDPOINT
                url: "/supplier/searchSupplier",
     //data=informacion envidad
                data: dato,
     //dataType=formato de retorno
                dataType: 'json',
                success: function (data) {
                                                //$(".select2").empty()=UBICACION DEL SELECT A LLENAR
                                                $(".select4").empty();
                                                //for= RECORRO EL JSON
                                                for(var i=0;i < data.length;i++)
                                                {
                                                //newrow= VARIABEL QUE AGREGA LOS OBJETOS
                                                var newrow ="<option id="+data[i].id+" value="+data[i].coordeadas+">"+data[i].nombre+"</option>";
                                                //SE AGREGAN LAS OPCIONES
                                                 $(newrow).appendTo(".select4");


                                                 //UBICACION DE LA CIUDAD

                                                }}


            });

});



