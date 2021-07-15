/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
	
})
function login(){
  
	$.get("uc",{"user":$("#username").val(), "pass":$("#password").val(), "opc": 2},function (data) {
		var x = JSON.parse(data);
                var o=x.nombre;
                if(o==null){
                     
                           alert("Lo sentimos no podemos encontrar su usuario")
                         window.location = 'http://localhost:8080/ProyectoIntegrador/index.jsp'; 
                         
			}else{
                            alert("Bienvenido: "+x.nombre+ " "+x.apellido1);
                             var user=x.nombre+ " "+x.apellido1;
                             var x=x.nombre_rol;
                             sessionStorage.setItem('user',user);
                              sessionStorage.setItem('rol',x);
            if (x=="ADMIN") {
              window.location = 'http://localhost:8080/ProyectoIntegrador/main.jsp';
            }else{
            if (x=="COORDINADOR") {
              window.location = 'http://localhost:8080/ProyectoIntegrador/main_2.jsp';
            } else{
             if (x==null) {
              window.location = 'http://localhost:8080/ProyectoIntegrador/main_1.jsp';
            }else{
                window.location = 'http://localhost:8080/ProyectoIntegrador/main1.jsp';
            }
            }  
            }
            
                          
			
			}
        
    });
	
}
