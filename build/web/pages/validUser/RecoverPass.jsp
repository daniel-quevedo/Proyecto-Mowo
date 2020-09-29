<%-- 
    Document   : menu
    Created on : 21-abr-2020, 8:17:04
    Author     : Daniel
--%>

<%@page import="EncodeDecode.EncodeDecode"%>
<%! 
    //private String mailEncode; 
    //private String mailDecode;
    //private int result;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link rel="stylesheet" href="../../css/styleIndex.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
       
        
        <title>Recuperar Contraseña</title>
    </head>
    <body>
        <main class="mt-5">
            <div class="col-lg-4 col-md-6 col-12 contenedor">
                <div class="box-content">
                    <div class="col-12 text-center mb-4">
                        <img src="../../img/logo-mowo-lateral.png" width="250" height="130" class="p-3" alt="logo">
                        <h3>Recupera tu Contraseña</h3>
                    </div>
                    <form class="col-12 " method="post" action="../../RecoverPassSERVLET" autocomplete="off" id="">                        
                        <div class="form-group">
                            <img src="../../img/mail.png">
                            <label>Ingresa aqui tu Email</label><br>                           
                            <input type="email" id="email" name="email" value="" class="form-control" autofocus placeholder="ejemplo@correo.com" required pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" tittle="Correo Electronico">
                            <p class="text-center mt-3">Enviaremos un correo a tu Email para que puedas cambiar tu contraseña</p>
                        </div>
                        <div class="text-center mb-2">
                            <button type="submit" class="btn btn-info botones col-12" >Confirmar</button>
                        </div>
                    </form>
                </div> 
            </div>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        <jsp:include page="../../includes/Admin/RecoPass.jsp"></jsp:include>
        <script src="../../js/validatePass.js"></script>                
    </body>
</html>

