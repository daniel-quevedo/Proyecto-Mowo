<%-- 
    Document   : perfil
    Created on : 23-abr-2020, 18:48:39
    Author     : Daniel
--%>

<%@page import="DAOAdmin.CrudUserDAO"%>
<%@page import="VOAdmin.CrudUserVO"%>
<%@page import="java.sql.ResultSet"%>



<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA TUTOR************************-->

<%@include file="../../includes/Tutor/ValidateSession.jsp"%> 

<!--*****************************************************************************************-->
<%! private String pathPhoto; %>
<%
    String varSession = (String) session.getAttribute("codUser");
    int id_user = Integer.parseInt(varSession);
    //traer los datos del tutor***
    CrudUserVO uVO = new CrudUserVO(0);
    CrudUserDAO uDAO = new CrudUserDAO(uVO);
    ResultSet dataUser = uDAO.infProfile(id_user);
    String typeUs = "";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="../../layout/head.jsp"></jsp:include>
            <title>Mi Perfil</title>
            <style type="text/css">
                
                .buttonInput > input
                {
                    display: none;
                }
                
            </style>
        </head>
        <body>
            <main>
                <header>
                </header>

                <section>
                <jsp:include page="../../layout/sideBarTutor.jsp"></jsp:include>
                </section>
                <section>
                    <div class="contenido">
                        <jsp:include page="../../layout/line-top.jsp"></jsp:include>
                        <div class="contenedor col-9">
                            <h5>Mi perfil</h5>
                        <%                            
                            if (dataUser.next()) {
                                pathPhoto = "../../photos/"+dataUser.getString(12);
                                out.print("<form id='formPhoto' enctype='multipart/form-data' action='../../PhotoUserSERVLET' method='post'>");
                                    out.print("<table class='table table-dark col-12'/>");
                                    out.print("<tr>");
                                        out.print("<td> <label>Tipo de documento:</label> </td>");
                                        out.print("<td><input type='text' class='form-control' value='" + dataUser.getString(1) + "' disabled></td>");
                                        out.print("<td><label>N° de documento:</label></td>");
                                        out.print("<td><input type='text' class='form-control' value='" + dataUser.getLong(2) + "' disabled></td>");
                                        out.print("<td rowspan='3'> "
                                                + "<div id='img'>"
                                                    + "<div class='buttonInput'>"
                                                       + "<label for='file'><i data-feather='edit' id='icon'></i></label>"
                                                        + "<input type='file' id='file' name='file'>"
                                                        + "<label for='button'><i data-feather='save' id='btnEnvi'></i></label>"
                                                        + "<input type='submit' id='button' name='button'>"
                                                    + "</div>"
                                                    + "<input type='hidden' name='nameFile' id='nameFile' value=''>"
                                                    + "<input type='hidden' name='currentName' id='currentName' value='"+dataUser.getString(12)+"'>"
                                                    + "<input type='hidden' name='option' id='option' value='4'>"
                                                + "</div> </td>");
                                    out.print("</tr>");
                                    out.print("<tr>");
                                        out.print("<td><label>Correo:</label></td>");
                                        out.print("<th colspan='3'><input type='text' class='form-control text-center' value='" + dataUser.getString(9) + "' disabled></th>");
                                    out.print("</tr>");
                                    out.print("</table>");
                                    out.print("<table class='table backg table-borderless table-responsive-sm col-12 mt-2'>");
                                    out.print("<tr><td colspam='2'></td><td></td></tr>");
                                    //VALIDAR EL TIPO DE USUARIO ********************
                                    int typeOpt = dataUser.getInt(6);
                                    switch (typeOpt) {
                                        case 1:
                                            typeUs = "Administrador";
                                            break;
                                        case 2:
                                            typeUs = "Profesor";
                                            break;
                                        case 3:
                                            typeUs = "Estudiante";
                                            break;
                                        case 4:
                                            typeUs = "Acudiante";
                                            break;
                                    }
                                    out.print("<tr>");
                                    out.print("<th>Nombre:<input type='text' class='form-control text-center' value='" + dataUser.getString(3) + "' disabled></th>");
                                    out.print("<th>Apellido:<input type='text' class='form-control text-center' value='" + dataUser.getString(4) + "' disabled></th>");
                                    out.print("</tr>");
                                    out.print("<tr>");
                                    out.print("<th>Tipo de usuario:<input type='text' class='form-control text-center' value='" + typeUs + "' disabled></th>");
                                    out.print("<th>Teléfono:<input type='text' class='form-control text-center' value='" + dataUser.getLong(5) + "' disabled></th>");
                                    out.print("</tr>");
                                    out.print("</tr>");
                                    out.print("<th>Dirección:<input type='text' class='form-control text-center' value='" + dataUser.getString(7) + "' disabled></th>");
                                    out.print("<th>Fecha de Nacimiento:<input type='text' class='form-control text-center' value='" + dataUser.getString(8) + "' disabled></th>");
                                    out.print("</tr>");
                                    out.print("<tr><td colspam='2'></td><td></td></tr>");
                                    out.print("</table>");
                                out.print("</form>");
                            }
                        %>                        
                    </div>
                </div>
            </section>
        </main>

        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
        
        <script src="../../js/photoUser.js"></script>
        <!-- VALIDAR CAMBIO DE FOTO -->
        <jsp:include page="../../includes/validatePhotoChange.jsp"></jsp:include>
        
        <script>
                
            $( document ).ready(function(){
               $("#img").css("background-image", "url('<%=pathPhoto%>')");
            });
                
        </script>
    </body>
</html>