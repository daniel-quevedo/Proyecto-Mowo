<%-- 
    Document   : insertUser
    Created on : 30-abr-2020, 22:49:36
    Author     : Daniel
--%>

<%@page import="java.util.Calendar"%>
<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ADMINISTRADOR************************-->

<%@include file="../../includes/Admin/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
    Calendar calendario = Calendar.getInstance();
    int an = calendario.get(Calendar.YEAR);
    int minyear = an - 6;
    int maxyear = an - 58;
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <title>Insertar Usuarios</title>
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
                            <ul class="nav nav-tabs justify-content-center" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="users-tab" data-toggle="tab" href="#users" role="tab" aria-controls="home" aria-selected="true"> <h5> Insertar usuarios </h5> </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><h5> Insertar usuarios masivos </h5></a>
                                </li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="users" role="tabpanel" aria-labelledby="home-tab">                                    
                                    <form action="../../CrudUserSERVLET" method="POST" autocomplete="off">
                                        <input type="hidden" name="option" value="2">
                                        <table class="table backg table-borderless table-responsive-sm col-lg-12 col-md-10 mt-3">
                                            <tr><td><h3>Insertar Usuarios</h3></td></tr>
                                            <tr>
                                                <th>Nombre:
                                                    <input type="text" class="form-control" name="name" id="name" value="" minlength="3" maxlength="25" pattern="[A-Za-zñ ]{3,25}" autofocus required></th>


                                            <th>Apellido:
                                                <input type="text" class="form-control" name="lname" id="lname" value="" minlength="3" maxlength="25" pattern="[A-Za-zñ ]{3,25}" required></th>
                                        </tr>
                                        <tr>
                                            <th>Tipo de Documento:
                                                <select class="form-control" name="typeDoc" id="typeDoc" required>
                                                    <option value="#">Seleccione...</option>
                                                    <option value="CC">CC.</option>
                                                    <option value="TI">TI.</option>
                                                    <option value="CE">CE.</option>
                                                </select></th>

                                            <th>N° Documento:
                                                <input type="text" class="form-control" name="nDocument" id="nDocument" value="" minlength="7" maxlength="10" pattern="[0-9]{3,11}" required></th>
                                        </tr>
                                        <tr>
                                            <th>Tipo de Usuario:
                                                <select class="form-control" name="typeUser" id="typeUser" required>
                                                    <option value="#">Seleccione...</option>
                                                    <option value="1">Administrador</option>
                                                    <option value="2">Docente</option>
                                                    <option value="3">Estudiante</option>
                                                    <option value="4">Acudiente</option>
                                                </select></th>

                                            <th>Teléfono:
                                                <input type="text" class="form-control" name="phone" id="phone" value="" minlength="7" maxlength="10" pattern="[0-9]{3,10}"  required></th>
                                        </tr>
                                        <tr>
                                            <th>Dirección:
                                                <input type="text" class="form-control" name="dir" id="dir" value="" minlength="10" maxlength="100" required></th>

                                            <th>Fecha de Nacimiento:
                                                <input type="date" class="form-control" name="date" id="date" value="" min="<%=maxyear%>-01-01" max="<%=minyear%>-12-31" required>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Correo:
                                                <input type="email" class="form-control" name="mail" id="mail" value="" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required></th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">
                                                <button type="submit" name="save" class="btn btn-info">Guardar</button>
                                                <button class="btn btn-secondary mb-2" type="reset">Cancelar</button>
                                            </th>
                                        </tr>                                           
                                    </table>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <div class="backg mt-3">
                                    <h3 class="pt-3 mb-3 ml-3 text-dark">Insertar Usuarios Masivos</h3><br>                                
                                    <form class="mb-4 ml-3" enctype="multipart/form-data" action="../../FileUsersSERVLET" method="POST" autocomplete="off">

                                        <label>Seleccione un archivo csv</label><br>
                                        <input type="file" class="text-dark" name="file" id="file" accept=".csv">
                                        <input type="hidden" name="nameFile" id="nameFile" value=""><br><br>
                                        <button type="submit" class="btn btn-info mb-4"> Enviar </button>

                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        <script>
            $("#file").change(function(){
                var file = (this).files[0];
                $("#nameFile").val(file.name);
            });
        </script>
        <!-- Validar si el usuario fue ingresado correctamente y mostrar el mensaje correspondiente-->
        <jsp:include page="../../includes/Admin/ValidateInsertUsu.jsp"></jsp:include>   
        <jsp:include page="../../includes/Admin/ValidateInsertMasives.jsp"></jsp:include>   
    </body>
</html>