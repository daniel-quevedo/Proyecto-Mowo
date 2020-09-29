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

    //Validar el valor que se envia por URL (AssocCourseSERVLET) insertar curso
    
    if(request.getParameter("src") != null) {
        
        result = Integer.parseInt(request.getParameter("src"));        
                
        
        if(result == 1){
            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Registro Curso",
                    text: "El curso se registro correctamente",
                    icon: "success",
                    timer: 5000

                }).then((value)=>{

                    window.location.href = window.location.href.split("?")[0];
                    
                    $.ajax({
                        type:"post",
                        url:"../../AssocCourseSERVLET",
                        data:{option:3}
                        
                    });

                });

            </script>  

            <%
        }else if(result == 0){
            
            %>
        
            <script type="text/javascript">

                Swal.fire({

                    title: "Error",
                    text: "El nombre del curso ya existe",
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
