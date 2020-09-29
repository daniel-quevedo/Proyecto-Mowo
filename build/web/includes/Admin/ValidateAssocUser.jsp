<%-- 
    Document   : VlidateAssocStudent
    Created on : 9/08/2020, 08:22:56 PM
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

                        title: "Asociar estudiantes",
                        text: "Se asociaron: <%=Math.abs(result)%> estudiantes al acudiente correspondiente",
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

                        title: "Asociar Docentes",
                        text: "Se asociaron: <%=Math.abs(result)%> docentes al curso correspondiente",
                        icon: "success",
                        timer: 5000
                    }).then((value)=>{

                        window.location.href = window.location.href.split("?")[0];

                    });

            </script>

            <%
        }else if(opt == 3){
            %>

            <script type="text/javascript">

                    Swal.fire({

                        title: "Asociar Estudiantes",
                        text: "Se asociaron: <%=Math.abs(result)%> Estudiantes al curso correspondiente",
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