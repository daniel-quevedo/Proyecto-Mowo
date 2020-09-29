<%-- 
    Document   : calificaciones
    Created on : 23-abr-2020, 23:37:28
    Author     : Daniel
--%>

<%!
    private String id_student;
%>
<%
    id_student = request.getParameter("src");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <title>Calificaciones</title>
        </head>
        <body>
            <main>
                <header>
                <jsp:include page="../../layout/sideBarTutor.jsp"></jsp:include>
                </header>
                <section>
                    <div class="contenido">
                        <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                        <div class="contenedor">
                            <section>
                                <nav class="navbar navbar-expand-sm col-lg-12 col-sm-10 col-12">                                    
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                                        <span>Periodos<i data-feather="chevrons-down"></i></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                                        <div class="navbar-nav">
                                            <a class="nav-link active" href="#" id="period1" onClick="notes(1)">Primer Periodo</a>
                                            <a class="nav-link" href="#" id="period2" onClick="notes(2)">Segundo Periodo</a>
                                            <a class="nav-link" href="#" id="period3" onClick="notes(3)">Tercer Periodo</a>
                                            <a class="nav-link" href="#" id="period4" onClick="notes(4)">Cuarto Periodo</a>
                                        </div>
                                    </div>
                                </nav>
                            </section>
                            <section>
                                <h5 class="text-center mt-3">Calificaciones</h5><br>
                                <input type="hidden" value="<%=id_student%>" id="codUser">
                            <div class="t-fixed col-lg-12 col-md-10 col-12">
                                <table class="table table-borderless backg table-responsive-sm" id="tableNotesStu">
                                    <thead>
                                        <tr>
                                            <th colspan="8" scope="col">Primer Periodo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>N°</th>
                                            <th>Materia</th>
                                            <th>Nota 1</th>
                                            <th>Nota 2</th>
                                            <th>Nota 3</th>
                                            <th>Nota 4</th>
                                            <th>Promedio</th>
                                            <th>Aprobo</th>
                                        </tr>
                                        <tr></tr>
                                    </tbody>
                                </table>
                            </div>
                        </section>
                    </div>
                </div>
            </section>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        <script src="../../js/student/showNotes.js"></script>   
    </body>
</html>

