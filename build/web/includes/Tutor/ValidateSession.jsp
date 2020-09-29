<%-- 
    Document   : ValidateSession
    Created on : 1/06/2020, 11:13:13 PM
    Author     : Daniel
--%>

<!--VALIDAR QUE EL USUARIO TENGA LA SESION ACTIVA Y SEA ESTUDIANTE************************-->

<%! 
    
    private String idProfile;
    private int id_profile; 

%>

<%
    
    if (session.getAttribute("nameUser") == null) {
            
       response.sendRedirect("../../index.jsp");
        
    }else{
       
       idProfile = (String) session.getAttribute("idProfile");
       id_profile = Integer.parseInt(idProfile);
       
       if(id_profile != 4){
           
        response.sendRedirect("../../index.jsp");
        
       }
       
    }

%>

