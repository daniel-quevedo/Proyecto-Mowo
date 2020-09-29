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
<!DOCTYPE html>
<html lang="es">
    <head>
       <jsp:include page="../../layout/head.jsp"></jsp:include>
        <title>Asistencia</title>
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
                        <h5 class="mb-4">Asistencia</h5>
                            <form action="">
                            <select  class="form-control" name="">
                                <option value="">Seleccione...</option>
                                <option value="">Curso 11-01</option>
                                <option value="">Curso 11-02</option>
                                <option value="">Curso 10-01</option>
                                <option value="">Curso 12-02</option>
                            </select><bt>
                                <div class="table-responsive-sm">
                                    <table class="table table-hover table-borderless table-success mt-2">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Nombres Completos</th>
                                                <th scope="col">19-may</th>
                                                <th scope="col">20-may</th>
                                                <th scope="col">21-may</th>
                                                <th scope="col">22-may</th>
                                                <th scope="col">23-may</th>
                                                <th scope="col">24-may</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Daniel Quevedo</td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>Eduardo Ruiz</td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>Juan Rodriguez</td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">4</th>
                                                <td>Mauricio Gonzales</td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">5</th>
                                                <td>Juana Hernandez</td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
                                                <td><select class="form-control">
                                                        <option value=""></option>
                                                        <option value="">A</option>
                                                        <option value="">R</option>
                                                        <option value="">F</option>
                                                    </select></td>
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

