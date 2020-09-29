<%-- 
    Document   : ValidateURL
    Created on : 25/05/2020, 12:07:35 AM
    Author     : Daniel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! 

    private int result; 
    private String mailEncode;
%>

<%

    //Validar el valor que se envia por URL (CrudUserSERVLET) insetar usuario
    
    if(request.getParameter("result") != null) {
        
        result = Integer.parseInt(request.getParameter("result"));
        mailEncode = request.getParameter("resm");
        
        %> <input type="hidden" value="<%=mailEncode%>" id="mailEncode"> <%
        
        if(result == 3){
            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Registro Usuario",
                    text: "El usuario se registro correctamente",
                    icon: "success",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];
                    
                    $.ajax({
                        type:"post",
                        url:"../../CrudUserSERVLET",
                        data:{option:1, mail:$("#mailEncode").val()}
                        
                    });

                });

            </script>  

            <%
        }else if(result == 2){
            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Registro Usuario",
                    text: "El usuario se registro correctamente, con unos problemas",
                    icon: "warning",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];
                    
                    $.ajax({
                        type:"post",
                        url:"../../CrudUserSERVLET",
                        data:{option:1, mail:$("#mailEncode").val()}
                        
                    });

                });

            </script>  

            <%
        }else if(result == 1){
            
            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Error",
                    text: "La identificacion o el email ya existen",
                    icon: "error",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];

                });

            </script>  

            <%
        
        }else{

            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Error",
                    text: "Ocurrio un error inesperado",
                    icon: "error",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];

                });

            </script>  

            <%

        }
        
    }


%>
