<%-- 
    Document   : insertUser
    Created on : 30-abr-2020, 22:49:36
    Author     : Daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="DAOAdmin.AssocCourseDAO"%>

<%

    //traer los datos de los estudianes y los cursos*** 
    AssocCourseDAO DocEst = new AssocCourseDAO();

    ResultSet resUser = DocEst.listStudent();

    ResultSet resCourse = DocEst.listCourse(1);


%>


<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ADMINISTRADOR************************-->

<%@include file="../../includes/Admin/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
        <meta charset="UTF-8">
            <title>Asignar Cursos</title>
        </head>
        <body>
            <main>
                <header>
                <jsp:include page="../../layout/sideBarAdm.jsp"></jsp:include>
                </header>
                <section>
                    <div class="contenido ">
                        <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                        <div class="contenedor ">
                            <h5 class="mb-4 text-center">Asignar Cursos a Estudiantes</h5>                           
                            <form action="../../AssocCourseSERVLET" method="POST">
                                <input type="hidden" name="opt" value="A">  
                                <input type="hidden" name="option" value="1">
                                <div class="row justify-content-center">
                                    <div>
                                        <label>Seleccione un curso </label>
                                        <select class="form-control" name="idCourse" id="idCourse" autofocus required>
                                            <option selected disabled>--SELECCIONE--</option> 
                                        <%                                            
                                            while (resCourse.next()) {
                                                out.println("<option value='" + resCourse.getInt(1) + "'>" + resCourse.getString(2) + "</option>");
                                            }
                                        %>
                                    </select> 

                                </div>
                            </div>
                            <table class="table table-borderless backg col-lg-12 col-md-10 col-12">
                                <thead>
                                    <tr>
                                        <th><i data-feather="check"></i></th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>No. Documento</th>
                                        <th>Teléfono</th>
                                        <th>Correo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        while (resUser.next()) {
                                            out.println("<tr>");
                                            out.println("<td>\n"
                                                    + "<input type='checkbox' name='user' value='" + resUser.getInt(1) + "'>\n"
                                                    + "</td>");
                                            out.println("<td> " + resUser.getString(2) + " </td>");
                                            out.println("<td> " + resUser.getString(3) + " </td>");
                                            out.println("<td> " + resUser.getLong(4) + " </td>");
                                            out.println("<td> " + resUser.getLong(5) + " </td>");
                                            out.println("<td> " + resUser.getString(6) + " </td>");

                                            out.println("</tr>");
                                        }
                                        DocEst.closeConnection();
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
            <!--Ventana Modal -->
            <jsp:include page="../../layout/modalUser.jsp"></jsp:include>
            </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>

            <!-- Validar si se asociaron correctemente los estudiantes-->
        <jsp:include page="../../includes/Admin/ValidateAssocUser.jsp"></jsp:include> 


        <!--implementar select2********-->
        <script>

            $(document).ready(function () {
                $('#idCourse').select2();
            });

        </script>

    </body>
</html>
