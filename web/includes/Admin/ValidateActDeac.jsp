<%-- 
    Document   : ValidateActDeac
    Created on : 20/06/2020, 10:29:38 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Validar el valor que se envia por URL (InsertUserSERVLET) insetar usuario
    
    if(request.getParameter("result") != null) {
        %>
        <script type="text/javascript">
            window.location.href = window.location.href.split("?")[0];
        </script>
        <%
        
    }
%>
