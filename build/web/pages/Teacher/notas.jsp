<%--
    Document   : notas
    Created on : 21-abr-2020, 8:21:38
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
        <title>Notas</title>
    </head>
    <body>
        <main>
            <section>
            <jsp:include page="../../layout/sideBarPro.jsp"></jsp:include>
            </section>
            <section>
                <div class="contenido">
                <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                    <div class="contenedor">                      
                        <h3 class="mb-4 text-center">Notas</h3><br>
                        <form onsubmit="" method="post">
                            <input type="hidden" value="<%=session.getAttribute("codUser")%>" name="cod" id="cod">
                            <input type="hidden" value="<%=session.getAttribute("idProfile")%>" name="idProfile" id="idProfile">
                            <div class="row text-center justify-content-center">
                                <div class="col-lg-5 col-md-10 col-12 ">

                                    <div id='Course'>
                                        <select class='form-control'>
                                            <option value=''>..Cursos..</option>
                                        </select>
                                        <!-- Lista en la que se muestran los cursos -->                                        
                                    </div>

                                </div>

                                <div class="col-lg-5 col-md-10 col-12">
                                    <select  class="form-control" name="subjects" id="subjects" disabled onchange='students()'>
                                        <!-- Lista en la que se muestran las asignaturas -->
                                        <option>...Asignaturas...</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <div class="t-fixed table table-borderless col-lg-12 col-md-10 col-12 mt-5" id='notes'>
                            <!-- Tabla en la que se muestran las notas -->
                        </div>                        
                    </div>
                </div> 

                <div id="sup"></div>
            </section>
            <!-- Ventana Modal -->
            <jsp:include page="../../layout/modalNotas.jsp"></jsp:include>
        </main>
        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        <script src="../../js/teacher/insertNotes.js"></script>
        <!-- Validar si las notas fueron ingresadas correctamente y mostrar el mensaje correspondiente-->
        <jsp:include page="../../includes/Teacher/ValidateInsertNotes.jsp"></jsp:include>   
    </body>
</html>
