<%-- 
    Document   : menu
    Created on : 21-abr-2020, 8:17:04
    Author     : Daniel
--%>

<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA PROFESOR************************-->

<%@include file="../../includes/Teacher/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <title>Menu</title>
        </head>
        <body>
            <main>
                <header>
                <jsp:include page="../../layout/sideBarPro.jsp"></jsp:include>
                </header>
                <section>
                    <div class="contenido">
                    <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                        <div class="contenedor">                                                        
                    </div>
                </div>
            </section>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
    </body>
</html>



