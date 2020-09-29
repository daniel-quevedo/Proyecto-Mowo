<%-- 
    Document   : validatePhotoChange
    Created on : 27/09/2020, 12:35:27 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
    private int result; 
%>

<%
    //Validar el valor que se envia por URL (InsertUserSERVLET) insetar usuario
    
    if(request.getParameter("src") != null) {
        result = Integer.parseInt(request.getParameter("src"));
        if(result != 0){
            %>
            <script type="text/javascript">
                Swal.fire({
                    title: "Cambio de foto",
                    text: "Se cambio la foto correctemente, es necesario que recargue la pagina",
                    icon: "success",
                    timer: 8000
                }).then((value)=>{
                    window.location.href = window.location.href.split("?")[0];
                });
            </script>
            <%
        }else{
            %>
             <script type="text/javascript">
                Swal.fire({
                    title: "Cambio de foto",
                    text: "Ocurrio un error al cambiar la foto",
                    icon: "success",
                    timer: 5000
                }).then((value)=>{
                    window.location.href = window.location.href.split("?")[0];
                });
            </script>
        <%
        }
        
    }
%>