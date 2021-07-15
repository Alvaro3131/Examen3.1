<%-- 
    Document   : Index.jsp
    Created on : 15 jul. 2021, 11:35:11
    Author     : Alvaro Alva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="recursos/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
  <style>
      *{
          margin-top: 5px;
      }
      .a{
          height: 70px;
          border: 1px solid rgb(156, 156, 156);
          border-right: none;
          background-color: #66ff66;
          
      }
      .a1{
          height: 70px;
          border: 1px solid rgb(156, 156, 156);
          border-left: none;
          text-align: end;
           background-color: #66ff66;
          
          
      }
      .b{
          height: 550px;
          border: 1px solid rgb(156, 156, 156);
           background-color: #66ff66;
          
          
      }
      .c{
        height: 50px;
        border: 1px solid rgb(156, 156, 156);
      }
      .h1{
          margin-top: 6px;
          font-size: 30px;
      }
    </style>
    </head>
    <body>
      
        <div class="container-fluid" style="width: 95%;">
        <div class="row">
            <div class="col-6 a">
                <div style="display: flex; flex-direction: initial;">
                      
                       <h1 class="h1">EXAMEN FINAL</h1>
              


                   </div>
             </div>
             <div class="col-6 a1">
               <img src='recursos/imagenes/user.png' alt='' width='10%' style='border: 1px solid black; border-radius: 100%;'> 
               <div id="user" style="display: flex; flex-direction: initial; float: right; padding-top: 15px; padding-left: 3px ">Alvaro Alva</div>
               
             </div>
            <div class="col-2 b">
                <nav class="navbar navbar-light " style="display: flex; flex-direction:inherit;">
                    <div style=" display: flex; flex-direction: initial;">
                     <i class="fas fa-home" style=" width: 10px; margin-right: 15px; margin-top: 15px;"></i>
                     <a class="navbar-brand color" href="#" style="color: rgb(0, 0, 0); font-size: 18px; " onclick="p()">
                       HOME
                     </a>
                   </div>
                   </nav>
                <nav class="navbar navbar-light " style="display: flex; flex-direction:inherit;">
                    <div style=" display: flex; flex-direction: initial;">
                     <i class="fas fa-shopping-cart"style=" width: 10px; margin-right: 15px; margin-top: 15px;"></i>
                     <a class="navbar-brand color" href="#" style="color: rgb(0, 0, 0); font-size: 18px; " onclick="p()">
                       Ventas2021
                     </a>
                   </div>
                   </nav>
                <nav class="navbar navbar-light  " style="padding: 0; margin: 0; padding-left: 4px; padding-bottom: 10px; padding-top: 10px; ">
              
                    <div class="dropdown" >
                      
                     <div style="display: flex; flex-direction: initial;">
                     
                      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style=" background-color: #66ff66; color: black; text-align: start;border: none; font-size: 15px;">
                        Personal
                      </button>
                      <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <button class="dropdown-item" type="button">Empleados</button>
                        <button class="dropdown-item" type="button">Empleados Externos</button>
                        
                      </div>
                    </div>
                    </div>
                  
                </nav>
                   
            </div>
            <div class="col-10" id="todo">
              <div class="container small" style="margin-bottom: 40px">
                <div class="form-group">
                  <h1>Crud Porducto</h1>
                  <hr style="margin:0; padding: 0; background-color: black">
                  <div style="padding-left: 15px; padding-top: 10px">
                        <div class="row">
                  <input type="text" class="form-control col-3"	id="idproducto" style="margin-right: 20px;" placeholder=" IdProducto" /> 
                 
                  <input type="text" class="form-control col-3"	id="nombre" placeholder="Nombre_Producto"/> 
                  
                  <select class="form-control col-4" id="categoria" style="margin-left: 20px">
      <option value=0>Seleccione la categoria de su produto</option>
      <option value=1>COCINA</option>
      <option value=2> LIMPIEZA</option>
      <option value=3>ALIMENTO</option>
     
    </select>
                  
                </div>
                <br>
                 <div class="row">
                  <input type="text" class="form-control col-4"	id="precio" style="margin-right: 20px;" placeholder="Precio" /> 
                 
                  <input type="text" class="form-control col-4"	id="stock" placeholder="Stock"/> 
                  <button class="btn btn-danger" id="boton2" style="margin-left: 20px; background-color: blue; border: none">Crear</button>
                  
                </div>
                <br>
                <div class="row">
                  

                  <input type="hidden" class="form-control col-7"	id="id" value="0" />
                  
                  
                </div>
                  </div>
                  
                
                </div>
               
              </div>
              <div class="container small">
                <table class="table" id="tablita">
                  <thead class="thead-dark">
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">ID</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Precio</th>
                      <th scope="col">STOCK</th>
                      <th scope="col">CATEGORIA</th>
            
                      <th scope="col" colspan="2">Acción</th>
                    </tr>
                  </thead>
                  <tbody>
            
                  </tbody>
                </table>
              </div>
            </div>
          
        </div>
    </div>
        
        
        
        
        
        <script src="recursos/js/jquery-3.6.0.min.js"></script>
  <script src="recursos/js/bootstrap.min.js"></script>
 
  <script >
      $(document).ready(function(){
	listar();
        limpiar();
	
});

function listar(){
	$.get("pc", {"opc":1}, function(data){
		var x= JSON.parse(data);
		$("#tablita tbody tr").remove();
		for(var i=0;i<x.length;i++){
                    
			$("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idproducto+"</td><td>"+x[i].nombre+"</td><td>"+x[i].preio+"</td><td>"+x[i].stock+"</td><td>"+x[i].noca+"</td><td><a href='#' onclick='editar("+x[i].idproducto+")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+x[i].idproducto+")'><i class='fas fa-trash-alt'></i></a></td></tr>");
                         
		}
	});
}
$("#boton2").click(function(){
	var idr = $("#id").val();
	
	if(idr==0){
	var param = {"i":$("#idproducto").val(),"nombre":$("#nombre").val(),"precio":$("#precio").val(),"stock":$("#stock").val(),"ca":$("#categoria").val(), "opc":2};
	$.ajax({
		beforeSend: function(){
			$('#resultado').html('Esperando...!');
		},
		data: param,
		url: 'pc',
		type: 'POST',
		success: function(response){
			
			limpiar();
			listar();
		},
		error: function(jqXHR, estado, error){
		console.log(estado)
		console.log(error)
		},
		complete: function (jqXHR, estado){
			console.log(estado)
		}				
	});
	}else{
		
		$.post("pc",{"id":$("#id").val(),"nombre":$("#nombre").val(),"precio":$("#precio").val(),"stock":$("#stock").val(),"ca":$("#categoria").val(),"opc":4},function (data) {
		listar();
		limpiar();	
    });
	}
});
function editar(id){

	$("#boton2").html("Editar");
	$.get("pc",{"id":id,"opc":3},function (data) {
		var x = JSON.parse(data);
        $("#nombre").val(x.nombre)
        $("#precio").val(x.preio)
        $("#stock").val(x.stock)
        $("#categoria").val(x.idcategoria)
        $("#id").val(x.idproducto);
        $("#idproducto").val(x.idproducto);
    });
}
function limpiar(){
	$("#nombre").val("");
	$("#precio").val("");
	$("#stock").val("");
        $("#categoria").val(0);
	$("#idproducto").val("");
	$("#nombre").focus();
	$("#id").val(0);
	$("#boton2").html("Crear");
}
function eliminar(id){
	$.get("pc",{"id":id,"opc":5},function () {
        listar();
    });
}
      
  </script>
    </body>
</html>
