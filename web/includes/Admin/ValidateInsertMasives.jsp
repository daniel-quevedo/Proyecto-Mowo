<%-- 
    Document   : ValidateURL
    Created on : 25/05/2020, 12:07:35 AM
    Author     : Daniel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! 

    private int result;
%>

<%

    //Validar el valor que se envia por URL (CrudUserSERVLET) insetar usuario
    
    if(request.getParameter("records") != null) {
        
        result = Integer.parseInt(request.getParameter("records"));
        
        %>

            <script type="text/javascript">

                Swal.fire({

                    title: "Registro Usuarios masivos",
                    text: "Se subieron <%=result%> usuarios correctamente",
                    icon: "success",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];

                });

            </script>
<%  }   %>