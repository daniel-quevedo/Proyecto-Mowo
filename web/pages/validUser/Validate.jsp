<%-- 
    Document   : menu
    Created on : 21-abr-2020, 8:17:04
    Author     : Daniel
--%>

<%@page import="EncodeDecode.EncodeDecode"%>
<%! 
    private String mailEncode; 
    private String mailDecode;
    private int result;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link rel="stylesheet" href="../../css/styleIndex.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
       
        
        <title>Crear Contraseña</title>
    </head>
    <body>
        <main class="mt-5 container">
            <div class="col-lg-4 col-md-6 col-12 contenedor">
                <div class="box-content">
                    <div class="col-12 login text-center">
                        <img src="../../img/login.png" width="200" height="200" alt="login">
                        <h5>Crear Contraseña</h5>
                    </div>
                    <form method="post" action="../../credentialsSERVLET" autocomplete="off" id="validatePass">
                        <div class="form-group">
                            <img src="../../img/user.png">
                            <label>Tu Usuario:</label><br>
                            <input type="text" class="form-control" placeholder="" name="user" value="<%=mailDecode%>" readonly>
                        </div>
                        <div class="form-group">
                            <img src="../../img/lock.png">
                            <label>Ingresa una Contraseña:</label><br>
                            <input type="password" id="pass" name="pass" value="" class="form-control" autofocus placeholder="Contraseña" required pattern="(?=.*\d)(?=.*[A-Z]).{8,}" title="
                                   Debe contener al menos un número, una letra mayúscula y al menos 8 o más caracteres">
                        </div>
                        <div class="form-group">
                            <img src="../../img/lock.png">
                            <label>Confirma tu Contraseña:</label><br>
                            <input type="password" id="pass2" class="form-control" value="" placeholder="Confirmar Contraseña" required pattern="(?=.*\d)(?=.*[A-Z]).{8,}" title="
                                   Debe contener al menos un número, una letra mayúscula y al menos 8 o más caracteres">
                        </div>
                        <div class="text-center mb-2">
                            <button type="submit" class="btn btn-success botones" >Confirmar</button>
                        </div>
                    </form>
                </div> 
            </div>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        <script src="../../js/validatePass.js"></script>
        
        
        <%
        //VALIDAR RETORNO DEL SERVLET ******************************+

            if(request.getParameter("res") != null) {

                result = Integer.parseInt(request.getParameter("res"));

                if(result == 1){

                    %>

                        <script type="text/javascript">

                            Swal.fire({

                                title: "Registro Credenciales",
                                text: "Las credenciales se registraron correctamente",
                                icon: "success",
                                timer: 5000

                            }).then((value)=>{

                                window.location.href = window.location.href.split("?")[0];

                                window.location.href = "../../index.jsp";

                            });

                        </script>  

                    <%

                }else{
                    %>

                        <script type="text/javascript">

                            Swal.fire({

                                title: "Error",
                                text: "Ocurrio un error al momento de ingresar las credenciales",
                                icon: "error",
                                timer: 5000

                            }).then((value)=>{

                                window.location.href = window.location.href.split("?")[0];
                                window.location.href = "../../index.jsp";

                            });

                        </script>  

                    <%
                }

            }else{

                //VALIDAR EL MAIL ****************************

                if(request.getParameter("m41r") != null) {

                    mailEncode = request.getParameter("m41r");

                    //decodificar el email****************

                    EncodeDecode encoDe = new EncodeDecode();

                    mailDecode =  encoDe.decode(mailEncode);

                }else{

                 response.sendRedirect("../../index.jsp");

                }

            }

        %>
        
        
    </body>
</html>

