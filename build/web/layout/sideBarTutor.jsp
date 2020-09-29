<%-- 
    Document   : sideBarEst
    Created on : 28/04/2020, 12:39:22 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="sidebar">
    <h3 class="sticky-top"><a href="index.jsp" title="inicio"><img src="../../img/logo-mowo-lateral.png" width="130px" height="60px"></a></h3>
    <div class="perfil">
        <h5 class="text-center pt-4"><%=session.getAttribute("nameUser")%></h5>
        <h6 class="text-center"><%=session.getAttribute("email")%></h6>
    </div>
    <a href="perfil.jsp" title="Ver Perfil"><img src="../../img/avatar.jpg" ></a>
    <div class="logo">
        <a href="../../index.jsp" title="Salir"><img src="../../img/salir.png" alt="Salir" ></a>
    </div>
    <ul>
          <li><a href="index.jsp">Inicio</a></li>
          <li><a href="revisarNotas.jsp">Revisar Notas</a></li>
         <!-- <li><a href="asistencia.jsp">Revisar Asistencia</a></li>
          <li><a href="asignaturas.jsp">Revisar Asignaturas</a></li>
          <li><a href="observaciones.jsp">Revisar Observaciones</a></li> -->
    </ul>
</div>
