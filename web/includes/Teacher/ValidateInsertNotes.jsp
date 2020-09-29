<%-- 
    Document   : ValidateInsertNotes
    Created on : 1/06/2020, 10:26:06 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 

    private int result;

%>

<%

    //Validar el valor que se envia por URL (CrudUserSERVLET) insetar usuario
    
    if(request.getParameter("result") != null) {
        
        result = Integer.parseInt(request.getParameter("result"));
        
        if(result == 1){
            %>
        
                <script type="text/javascript">

                    Swal.fire({

                        title: "Registro Notas",
                        text: "la(s) Nota(s) se ingresaron correctamente",
                        icon: "success",
                        timer: 5000

                    }).then((value)=>{

                        window.location.href = window.location.href.split("?")[0];

                    });

                </script>  

             <%
        }else if(result == 2){

            %>
        
                <script type="text/javascript">

                    Swal.fire({

                        title: "Error",
                        text: "Ocurrio un erro al ingresar la(s) Nota(s)",
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