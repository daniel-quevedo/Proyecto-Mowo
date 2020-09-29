<%-- 
    Document   : menu
    Created on : 21-abr-2020, 8:17:04
    Author     : Daniel
--%>

<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ADMINISTRADOR************************-->

<%@include file="../../includes/Admin/ValidateSession.jsp"%> 

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
                <jsp:include page="../../layout/sideBarAdm.jsp"></jsp:include>
                </header>
                <section>
                    <div class="contenido">
                    <jsp:include page="../../layout/line-top.jsp"></jsp:include>                   
                        <div class="contenedor">
                            <div class="index">
                                <div class="card">
                                    <div class="imgBx">
                                        <img src="../../img/InsUs.png" alt="">
                                    </div>
                                    <div class="content">
                                        <div>
                                            <h3>Insertar Usuarios</h3>                                            
                                            <a href="insertUser.jsp">Ir al sitio</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="imgBx">
                                        <img src="../../img/InsCou.png" alt="">
                                    </div>
                                    <div class="content">
                                        <div>
                                            <h3>Insertar Cursos</h3>                                            
                                            <a href="insertCourse.jsp">Ir al sitio</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="imgBx">
                                        <img src="../../img/AsoPro.png" alt="">
                                    </div>
                                    <div class="content">
                                        <div>
                                            <h3>Asignar curso a un Profesor</h3>                                            
                                            <a href="assocCourseTeacher.jsp">Ir al sitio</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="imgBx">
                                        <img src="../../img/AsoEst.png" alt="">
                                    </div>
                                    <div class="content">
                                        <div>
                                            <h3>Asignar curso a un Estudiante</h3>
                                            <a href="assocCourseStu.jsp">Ir al sitio</a>
                                        </div>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                </section>
            </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>

    </body>
</html>

