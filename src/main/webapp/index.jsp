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
            .small{
                margin: 0 auto;
                max-width: 800px;
                margin-top: 30px;
            }
        </style>
    </head>
    <body>

        <div class="container" style="width: 500px;padding-top: 30px;">
            <div class="row">
                <div class="col-12" style="height: 60px; background-color: blue; color: white;border-radius: 5px; font-size: 30px; padding-top: 5px;">
                    Ventas
                </div>
                <div class="col-12"  style="height: 300px; border: 1px solid skyblue;border-radius: 5px; padding-top: 30px;">

                    <div class="form-group col-12">

                        <select class="form-control" id="sucursal">
                            <option value=0>Seleccione Sucursal</option>

                        </select>
                    </div>
                    <div class="form-group col-12">

                        <select class="form-control" id="cliente">
                            <option value="0">Seleccione Cliente</option>

                        </select>
                    </div>
                    <div class="form-group col-6">

                        <input type="date" class="form-control" id="fecha" placeholder="Fecha">
                    </div>
                    <div class="form-group col-12">

                        <select class="form-control" id="boleta">
                            <option value=0>Seleccione Tipo</option>
                            <option value="BOLETA">BOLETA</option>
                            <option value="FACTURA">FACTURA</option>
                        </select>
                    </div>
                    <button type="button" class="btn btn-primary" id="boton2" style="margin-left: 350px">REGISTRAR</button>

                </div>
            </div>
             </div>
            <input type="hidden" class="form-control col-7"	id="id" value="0" />
            <div class="container small" >
                <table class="table" id="tablita">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">SUCURSAL</th>
                            <th scope="col"  style="text-align: ">CLIENTE</th>
                            <th scope="col">FECHA</th>
                            <th scope="col">DOCUMENTO</th>


                            <th scope="col" colspan="2">Acción</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>



            <script src="recursos/js/jquery-3.6.0.min.js"></script>
            <script src="recursos/js/bootstrap.min.js"></script>

            <script >
                $(document).ready(function () {
                    listar();
                    listarc();
                    listarw();
                    limpiar();

                });

                function listar() {
                    $.get("pc", {"opc": 1}, function (data) {
                        var x = JSON.parse(data);
                        $("#tablita tbody tr").remove();
                        for (var i = 0; i < x.length; i++) {

                            $("#tablita").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].sucursal + "</td><td>" + x[i].nombrec + " "+x[i].apellido+"</td><td>" + x[i].fecha + "</td><td>" + x[i].doc + "</td><td><a href='#' onclick='editar(" + x[i].idventa + ")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idventa + ")'><i class='fas fa-trash-alt'></i></a></td></tr>");

                        }
                    });
                }
                function listarc() {
                    $.get("cc", {"opc": 1}, function (data) {
                        var x = JSON.parse(data);

                        for (var i = 0; i < x.length; i++) {

                            $("#sucursal").append("<option value=" + x[i].idsucursal + ">" + x[i].nombre + "</option>");

                        }
                    });
                }
                function listarw() {
                    $.get("ec", {"opc": 1}, function (data) {
                        var x = JSON.parse(data);

                        for (var i = 0; i < x.length; i++) {

                            $("#cliente").append("<option value=" + x[i].idcliente + ">" + x[i].nombre + " " + x[i].apellido + "</option>");

                        }
                    });
                }

                $("#boton2").click(function () {
                    var idr = $("#id").val();

                    if (idr == 0) {

                        var param = {"s": $("#sucursal").val(), "c": $("#cliente").val(), "f": $("#fecha").val(), "b": $("#boleta").val(), "opc": 2};

                        $.ajax({
                            beforeSend: function () {
                                $('#resultado').html('Esperando...!');
                            },
                            data: param,
                            url: 'pc',
                            type: 'POST',
                            success: function (response) {

                                limpiar();
                                listar();
                            },
                            error: function (jqXHR, estado, error) {
                                console.log(estado)
                                console.log(error)
                            },
                            complete: function (jqXHR, estado) {
                                console.log(estado)
                            }
                        });
                    } else {

                        $.post("pc", {"id": $("#id").val(), "nombre": $("#nombre").val(), "precio": $("#precio").val(), "stock": $("#stock").val(), "ca": $("#categoria").val(), "opc": 4}, function (data) {
                            listar();
                            limpiar();
                        });
                    }
                });

                function limpiar() {
                    $("#sucursal").val(0);
                    $("#cliente").val(0);
                    $("#fecha").val("");
                    $("#boleta").val(0);

                    $("#id").val(0);

                }
                function eliminar(id) {
                    $.get("pc", {"id": id, "opc": 5}, function () {
                        listar();
                    });
                }

            </script>
    </body>
</html>
