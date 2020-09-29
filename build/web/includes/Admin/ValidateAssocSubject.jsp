<%-- 
    Document   : ValidateAssocSubject
    Created on : 17/08/2020, 03:31:41 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! 
    private int result, opt; 
%>
<%
    
    if(request.getParameter("src") != null) {
    
        result = Integer.parseInt(request.getParameter("src"));
        
        opt = Integer.parseInt(request.getParameter("opt"));

        if (opt == 1) {
            %>

            <script type="text/javascript">

                    Swal.fire({

                        title: "Asociar asignaturas a docentes",
                        text: "Se asociaron: <%=Math.abs(result)%> asignaturas al docente correspondiente",
                        icon: "success",
                        timer: 5000
                    }).then((value)=>{

                        window.location.href = window.location.href.split("?")[0];

                    });

            </script>

            <%
        }else if(opt == 2){
            %>

            <script type="text/javascript">

                    Swal.fire({

                        title: "Asociar asignaturas a cursos",
                        text: "Se asociaron: <%=Math.abs(result)%> asignaturas al curso correspondiente",
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
