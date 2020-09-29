<%-- 
    Document   : asigStudent
    Created on : 9/08/2020, 04:39:44 PM
    Author     : Daniel
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAOAdmin.AssocStudentTutorDAO"%>

<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ADMINISTRADOR************************-->

<%@include file="../../includes/Admin/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->
<%!    private ResultSet resultParents, resultStudents;
%>
<%    AssocStudentTutorDAO astDAO = new AssocStudentTutorDAO();

    resultParents = astDAO.listParents();

    resultStudents = astDAO.listStudents();

%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <meta charset="UTF-8">
            <title>Asignar Estudiantes</title>
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
                            <h5 class="mb-5 text-center">Asignar Estudiantes</h5>                                                                        
                            <form action="../../AssocStudentTutorSERVLET" method="POST">
                                <div class="row justify-content-center">
                                    <div class="">                                    
                                        <label>Seleccione el acudiente</label>                                    
                                        <select class="form-control" name="id_tutor" id="id_tutor" autofocus required>
                                            <option selected disabled>--SELECCIONE--</option>
                                        <%                                            while (resultParents.next()) {
                                                out.println("<option value='" + resultParents.getInt(2) + "'>" + resultParents.getString(1) + "</option>");
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <table class="table table-borderless backg col-lg-12 col-md-10 col-12">
                                <thead>
                                    <tr>
                                        <th scope="col"><i data-feather="check"></i></th>
                                        <th scope="col">Identificación</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Teléfono</th>
                                        <th scope="col">Correo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        while (resultStudents.next()) {
                                            out.println("<tr>");
                                            out.println("<td>\n"
                                                    + "<input type='checkbox' name='students' value='" + resultStudents.getInt(1) + "'>\n"
                                                    + "</td>");
                                            out.println("<td>" + resultStudents.getLong(2) + "</td>");
                                            out.println("<td>" + resultStudents.getString(3) + "</td>");
                                            out.println("<td>" + resultStudents.getLong(4) + "</td>");
                                            out.println("<td>" + resultStudents.getString(5) + "</td>");
                                            out.println("</tr>");
                                        }
                                        astDAO.closeConnection();
                                    %>  
                                </tbody>
                            </table>
                            <div class="table mt-3 pb-5">                                    
                                <button type="submit" name="send" id="send" class="btn btn-info"> Aceptar </button>
                            </div>                           
                        </form>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="../../layout/scripts.jsp"></jsp:include>

            <!-- Validar si se asociaron correctemente los estudiantes-->
        <jsp:include page="../../includes/Admin/ValidateAssocUser.jsp"></jsp:include>   

        <!--implementar select2********-->
        <script>

            $(document).ready(function () {
                $('#id_tutor').select2();
            });

        </script>

    </body>
</html>
