<%-- 
    Document   : calificaciones
    Created on : 23-abr-2020, 23:37:28
    Author     : Daniel
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="DAOTutor.ShowEstutorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    private String id_tutor_rec;
    private int id_tutor;
%>
<%

    id_tutor_rec = (String) session.getAttribute("codUser");

    id_tutor = Integer.parseInt(id_tutor_rec);

%>
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
                                <div class="index">
                                <%                        
                                    ShowEstutorDAO shwetDAO = new ShowEstutorDAO();
                                    ResultSet result = shwetDAO.listUser(id_tutor);

                                    shwetDAO.closeConnection();

                                    while (result.next()) {

                                        out.println("<div class='card '>\n"
                                                + "<div class='imgBx'>\n"
                                                + "<img src='../../img/InsUs.png'>\n"
                                                + "</div>\n"
                                                + "<div class='content'>\n"
                                                + "<div>\n"                                                  
                                                + "<h3>" + result.getString(3) + "</h3>\n"
                                                + "<p>CC: " + result.getLong(2) + "</p>\n"     
                                                + "<a href='notes.jsp?src=" + result.getInt(1) + "'>Ver Notas</a>\n"                                                
                                                + "</div>\n"
                                                + "</div>\n"
                                                + "</div>\n"
                                        );
                                    }
                                %>
                            </div>
                        </section>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="../../layout/scripts.jsp"></jsp:include>
    </body>
</html>

