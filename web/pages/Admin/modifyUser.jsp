<%-- 
    Document   : insertUser
    Created on : 30-abr-2020, 22:49:36
    Author     : Daniel
--%>

<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ADMINISTRADOR************************-->

<%@include file="../../includes/Admin/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <title>Modificar Usuarios</title>
        </head>
        <body>
            <main>
                <header>
                <jsp:include page="../../layout/sideBarAdm.jsp"></jsp:include>
                </header>
                <section>
                    <div class="contenido">
                        <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                        <div class="contenedor mt-4">
                            <div class=" backg col-lg-12 col-md-10 mb-2 pb-2">
                            <h3 class="mb-5 pt-3 text-dark">Modificar Usuarios</h3>
                                <form action="../../ActivDeacSERVLET" method="POST" id="adUser">
                                    <input type="hidden" value="" name="opt" id="opt">
                                    <input type="hidden" value="" name="cod" id="cod">
                                    <div id="dataUser"></div>
                                </form>
                            </div>
                        </div>
                </section>
                <!--Ventana Modal -->
            <jsp:include page="../../layout/modalUser.jsp"></jsp:include>
            </main>



        <jsp:include page="../../layout/scripts.jsp"></jsp:include>

            <script src="../../js/Admin/ShowUsers.js"></script>


            <!-- Validar si el usuario fue activado, desactivado o modificado***********-->
        <jsp:include page="../../includes/Admin/ValidateActDeac.jsp"></jsp:include> 

    </body>
</html>
