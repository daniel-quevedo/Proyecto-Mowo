<%-- 
    Document   : index
    Created on : 27/04/2020, 12:24:26 AM
    Author     : Daniel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="./css/styleIndex.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/animate.min.css">
        
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <title>Mowo_o</title>
    </head>
    <body class="container">
        <div class="col-lg-4 col-md-6 col-12 contenedor">            
            <div class="box-content">
                <div class="col-12 login text-center">
                    <img src="./img/login.png" alt="login">
                    <h5>Iniciar Sesión</h5>
                </div>
                <form class="col-12" action="LoginSERVLET" method="post" autocomplete ="off">

                    <div class="form-group">
                        <img src="./img/user.png">
                        <label>Nombre:</label><br>
                        <input type="text" name="user" class="form-control" autofocus placeholder="Nombre de usuario" maxlength="35" required pattern="[A-Za-0-9z.@]{2,30}" >
                    </div>
                    <div class="form-group">
                        <img src="./img/lock.png">

                        <label>Contraseña: <img src="./img/eyeoff.png" id="show"></label><br> 
                        <input type="password" name="passUsu" id="pass" class="form-control" placeholder="Contraseña" maxlength="25"  required pattern="(?=.*\d)(?=.*[A-Z]).{8,}" title="
                               Debe contener al menos un número, una letra mayúscula y al menos 8 o más caracteres">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-info botones col-12" ><img src="./img/fingerprint.png"> Ingresar</button>
                    </div>

                </form>
                <div>
                    <div class="col-12 text-center mb-2">
                        <a href="./pages/validUser/RecoverPass.jsp">¿Olvidaste la Contraseña?</a>
                    </div>
                </div>
            </div>            
        </div>
        <div>
            <%request.getAttribute("error");%> 

            ${error} 

        </div>
        <script src="js/viewPass.js" charset="utf-8"></script>
    </body>

</html>