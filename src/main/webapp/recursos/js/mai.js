var data = sessionStorage.getItem('user'); 
var data1 = sessionStorage.getItem('rol');
$("#user").html("<b >"+data+"</b>");
$("#rol").html("<b >"+data1+"</b>");
function l(op){
  if(op==1){
       window.location=('index.jsp')
  }
  if(op==2){
        $("#todo").load("vista/contenedor.jsp");
  }
  
  if(op==3){
      window.location = 'main.jsp'; 
  }
   if(op==4){
      $("#todo").load("vista/gestiondetablaas.jsp");
         
  }
  if(op==5){
      $("#todo").load("Principal.jsp");
         
  }
  
}

function g(op){
  
  if(op==1){
        $("#crud").load("vista/socio.jsp");
  }
  if(op==2){
        $("#crud").load("vista/banco.jsp");
 
  }
   if(op==3){
        $("#crud").load("vista/Usuario.jsp");
    }
   if(op==4){
        $("#crud").load("vista/nom_rol.jsp");
  }
  if(op==5){
        $("#crud").load("vista/capacitdor.jsp");
  }
  if(op==6){
        $("#crud").load("vista/programa.jsp");
  }
  if(op==7){
        $("#crud").load("vista/capacitacion.jsp");
  }
  if(op==8){
        $("#crud").load("vista/sesion.jsp");
  }
   if(op==9){
        $("#crud").load("vista/recurso.jsp");
  }
   if(op==10){
        $("#crud").load("vista/asistencia.jsp");
  }
   if(op==11){
        $("#crud").load("vista/inscripcion.jsp");
  }
  }


