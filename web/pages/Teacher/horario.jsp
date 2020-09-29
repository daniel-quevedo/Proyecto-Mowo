<%--
    Document   : horario
    Created on : 21-abr-2020, 10:15:50
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
        <title>Horario</title>
    </head>
    <body>
        <main>
            <header>
            </header>
            <section>
                <jsp:include page="../../layout/sideBarPro.jsp"></jsp:include>
            </section>
            <section>
                <div class="contenido">
                    <img src="../../img/menu.png" alt="" class="menu-bar">
                    <div class="contenedor animated zoomIn">
                        <h5>Mi Horario</h5><br
                            <form action="">
                            <div class="table-responsive-sm">
                                <table class="table table-success table-borderless table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th colspan="2" scope="col">Asignatura: Matematicas</th>
                                            <th scope="col">Salon: 405</th>
                                            <th colspan="4" scope="col">Jornada Mañana</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Dia</th>
                                            <td>11°(Undecimo)</td>
                                            <td>10°(Decimo)</td>
                                            <td>9°(Noveno)</td>
                                            <td>8°(Octavo)</td>
                                            <td>7°(Septimo)</td>
                                            <td>6°(Sexto)</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Lunes</th>
                                            <td>8:00am-10:00am</td>
                                            <td></td>
                                            <td>10:00am-12:00am</td>
                                            <td>6:00am-8:00am</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Martes</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Miercoles</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Jueves</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Viernes</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
    </body>
</html>
