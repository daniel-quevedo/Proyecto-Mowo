<%-- 
    Document   : observaciones
    Created on : 21-abr-2020, 8:30:36
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
        <title>Observaciones</title>
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
                        <h5>Datos de la Anotacion</h5><br>
                        <form action="">
                            <table class="table table-dark table-borderless">
                                <tbody>
                                    <tr>
                                        <td><label>Seleccione un Salon</label></td>
                                        <td>
                                            <select class="form-control" name="" id="">
                                                <option value="">Seleccione...</option>
                                                <option value="">Curso 10-01</option>
                                                <option value="">Curso 10-02</option>
                                                <option value="">Curso 11-01</option>
                                                <option value="">Curso 11-02</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td><label>Seleccione un Alumno</label></td>
                                        <td>
                                            <select class="form-control " name="" id="" >
                                                <option value="">Seleccione...</option>
                                                <option value="">Daniel Quevedo</option>
                                                <option value="">Eduardo Ruiz</option>
                                                <option value="">Mauricio Gonzales</option>
                                                <option value="">David Quevedo</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td><label>Anotacion</label></td>
                                        <td><textarea class="form-control " name="" cols="20" rows="2"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td><label>Compromiso del Alumno</label></td>
                                        <td><textarea class="form-control " name="" cols="20" rows="2"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td><label for="">Tipo de Anotacion</label></td>
                                        <td>
                                            <select class="form-control" name="">
                                                <option value="">Seleccione...</option>
                                                <option value="">Llamado de Atencion</option>
                                                <option value="">Incumplimiento Trabajos</option>
                                                <option value="">Indiciplina</option>
                                                <option value="">Mal comportamiento</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><button type="submit"class="btn btn-success">Enviar</button>
                                            <button type="submit" class="btn btn-danger" reset>Cancelar</button></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </section>
        </main>
        
        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
    </body>
</html>

