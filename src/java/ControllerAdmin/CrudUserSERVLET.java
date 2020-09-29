/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerAdmin;

import DAOAdmin.CrudUserDAO;
import EncodeDecode.EncodeDecode;
import VOAdmin.CrudUserVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.Mail;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "CrudUserSERVLET", urlPatterns = {"/CrudUserSERVLET"})
public class CrudUserSERVLET extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            
            int option = Integer.parseInt(request.getParameter("option"));
            
            //VARIABLES PARA VALIDAR EL ESTADO Y TIPO DE USUARIO************
            String state;
            String button;
            String typeUs = "";
            //*******************************************
            
            try{
                
                switch (option) {
                    case 1:
                    {

                        //ENVIAR EL EMAIL CON EL LINK PARA CAMBIAR EL PASSWOIRD POR DEFECTO**********

                        String mailEncode = request.getParameter("mail");
                        
                        //DECODIFICAR EL EMAIL RECIBIDO****************
                        EncodeDecode coDe = new EncodeDecode();
                        String mailDecode = coDe.decode(mailEncode);
                        
                        //ENVIAR CORREO AL CORREO CORRESPONDIENTE*************
                        Mail objMail = new Mail(mailDecode);
                        objMail.sendMail();
                        break;
                    }
                    case 2:
                    {
                        //INSERTAR USUARIO ******************************
                        String mail = request.getParameter("mail");
                        String name = request.getParameter("name");
                        String lname = request.getParameter("lname");
                        String typeDoc = request.getParameter("typeDoc");
                        long nDocument = Long.parseLong(request.getParameter("nDocument"));
                        int typeUser = Integer.parseInt(request.getParameter("typeUser"));
                        long phone = Long.parseLong(request.getParameter("phone"));
                        String dir = request.getParameter("dir");
                        String date = request.getParameter("date");
                        
                        CrudUserVO uVO = new CrudUserVO(typeDoc, nDocument, name, lname, typeUser, phone, dir, date, mail, 1);
                        CrudUserDAO uDAO = new CrudUserDAO(uVO);
                        
                        int res = uDAO.insertUser();
                        uDAO.closeConnection();
                        
                        
                        
                        //CODIFICAR EL EMAIL PARA ENVIARLO POR URL********
                        EncodeDecode coDe = new EncodeDecode(mail);
                        String mailEncode = coDe.encode();
                        response.sendRedirect("pages/Admin/insertUser.jsp?result="+res+"&resm="+mailEncode+"");

                        break;
                    } 
                    case 3:
                    {
                        //MOSTRAR LOS USUARIOS EN LA TABLA PARA MODIFICAR*****************

                        CrudUserDAO uDAO = new CrudUserDAO(); 

                        ResultSet result = uDAO.dataUsers();

                        out.println("<script src=\"../../js/feather.min.js\" charset=\"utf-8\"></script>\n" +
                                    "<script> feather.replace(); </script>" +
                                    "<script src='../../js/dataTable.js' charset='utf-8'></script>");

                        out.println("<table class='table table-hover table-borderless table-responsive nowrap mt-5 mydataTable' width='100%' id='dataUser'>");
                            out.println("<thead>");

                            out.println("<tr>" +
                                            "<th>Estado</th> \n" +
                                            "<th>Nombres</th>\n" +
                                            "<th>Apellidos</th>\n" +
                                            "<th>Tipo de Documento</th>\n" +
                                            "<th>No. Documento</th>\n" +
                                            "<th>Tipo de Usuario</th>\n" +
                                            "<th>T&eacutelefono</th>\n" +
                                            "<th>Direcci&oacuten</th>\n" +
                                            "<th>Fecha de Nacimiento</th>\n" +
                                            "<th>Correo</th>\n" +
                                            "<th colspan='2'>Acciones</th>\n" +
                                            "<th></th>\n"+
                                        "</tr>");

                            out.println("</thead>");
                            out.println("<tbody>");

                            


                            while(result.next()){

                                //VALIDAR QUE EL USUARIO ESTA ACTIVO Y COLOCAR UN BOTON PARA ACTIVAR O DESACTIVAR
                                //DEPENDIENDO EL CASO

                                if (result.getInt(1) == 1){ 
                                    state = "Activo";

                                    button = "<button type='submit' name='adButton' id='adButton' class='btn btn-outline-danger' onclick='adUser(2,"+result.getInt(11)+")'><i data-feather='user-minus'></i></button>";

                                }else{
                                    state = "Inactivo";

                                    button = "<button type='submit' name='adButton' id='adButton' class='btn btn-outline-success' onclick='adUser(1,"+result.getInt(11)+")'><i data-feather='user-plus'></i></button>";


                                }
                                
                                //VALIDAR EL TIPO DE USUARIO ********************
                                int typeOpt = result.getInt(6);

                                switch(typeOpt){
                                    case 1:
                                        typeUs = "Administrador";
                                        break;
                                    case 2:
                                        typeUs = "Profesor";
                                        break;
                                    case 3:
                                        typeUs = "Estudiante";
                                        break;
                                    case 4:
                                        typeUs = "Acudiante";
                                        break;
                                }


                                out.println("<tr>");

                                    out.println("<td>"+state+"</td>");
                                    out.println("<td>"+result.getString(2)+"</td>");
                                    out.println("<td>"+result.getString(3)+"</td>");
                                    out.println("<td>"+result.getString(4)+"</td>");
                                    out.println("<td>"+result.getInt(5)+"</td>");
                                    out.println("<td>"+typeUs+"</td>");
                                    out.println("<td>"+result.getString(7)+"</td>");
                                    out.println("<td>"+result.getString(8)+"</td>");
                                    out.println("<td>"+result.getString(9)+"</td>");
                                    out.println("<td>"+result.getString(10)+"</td>");
                                    out.println("<td><a href='#ventana1' data-toggle='modal' onclick='modalUser("+result.getInt(5)+")'><button type='button' class='btn btn-info'><i data-feather='edit-3'></i></button></a></td>");                                    
                                    out.println("<td>"+button+"</td>");
                                    out.println("<td></td>");
                                out.println("</tr>");
                            }

                            out.println("</tbody>");
                        out.println("</table>");

                        break;   
                        
                    }
                    case 4:
                    {
                        
                        //MOSTRAR LOS DATOS DEL USUARIO EN EL MODAL PARA MODIFICAR***************
                        
                        Calendar calendario = Calendar.getInstance();
                        int an = calendario.get(Calendar.YEAR);
                        int minyear = an - 6;
                        int maxyear = an - 58;
                        
                        int nDocument = Integer.parseInt(request.getParameter("nDocument"));
                        
                        CrudUserVO uVO = new CrudUserVO(nDocument);
                        CrudUserDAO uDAO = new CrudUserDAO(uVO);
                        ResultSet result = uDAO.dataUsers();
                        
                        if(result.next()){
                            out.println("<div id='tableUsers'>\n"+
                                        "<input type='hidden' name='cod_user' value="+result.getInt(11)+" > \n" +
                                        "<input type='hidden' value='5' name='option'>"+
                                        "<input type='hidden' value="+result.getInt(5)+" name='nDocument'>");
                                out.println("<table class='table table-responsive-sm table-light'>");
                                    out.println("<tr>\n" +
                                                    "<th><label>Nombre:</label></th>\n" +
                                                    "<td><input type='text' class='form-control' name='name' value='"+result.getString(2)+"' minlength='3' maxlength='25' pattern='[A-Za-zñ ]{3,25}'></td>\n" +
                                                "</tr>");
                                    out.println("<tr>\n" +
                                                    "<th><label>Apellido:</label></th>\n" +
                                                    "<td><input type='text' class='form-control' name='lname' value='"+result.getString(3)+"' minlength='3' maxlength='25' pattern='[A-Za-zñ ]{3,25}'></td>\n" +
                                                "</tr>");
                                
                                    out.println("<tr>\n"+
                                                    "<th><label>Tipo de Documento:</label></th>\n" +
                                                        "<td>\n"+
                                                            "<select class='form-control' name='typeDoc' required>\n" +
                                                                "<option value=''>Seleccione...</option>\n" +
                                                                "<option value='CC'>CC</option>\n" +
                                                                "<option value='TI' focus>TI</option>\n" +
                                                                "<option value='CE'>CE</option>\n" +
                                                            "</select>\n"+
                                                        "</td>"+
                                                "</tr>");                                    
                                    out.println("<tr>\n" +
                                                    "<th><label>T&eacutelefono:</label></th>\n" +
                                                    "<td>\n"+
                                                        "<input type='text' class='form-control' name='phone' value='"+result.getString(7)+"' minlength='7' maxlength='10' pattern='[0-9]{3,15}' title='No se admiten letras'>\n"+
                                                    "</td>\n" +
                                                "</tr>\n" +
                                                "<tr>\n" +
                                                    "<th><label>Direcci&oacuten:</label></th>\n" +
                                                    "<td>\n"+
                                                        "<input type='text' class='form-control' name='dir' value='"+result.getString(8)+"' minlength='10' maxlength='100'>\n"+
                                                    "</td>\n" +
                                                "</tr>\n" +
                                                "<tr>\n" +
                                                    "<th><label>Fecha de Nacimiento:</label></th>\n" +
                                                    "<td>\n"+
                                                        "<input type='date' class='form-control' name='date' value='"+result.getString(9)+"' min='"+maxyear+"-01-01' max='"+minyear+"-01-01'>\n"+
                                                    "</td>\n" +
                                                "</tr>\n" +
                                                "<tr>\n" +
                                                    "<th><label>Correo:</label></th>\n" +
                                                    "<td>\n"+
                                                        "<input type='email' class='form-control' name='mail' value='"+result.getString(10)+"' pattern='[a-zA-Z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,}$'>\n"+
                                                    "</td>\n" +
                                                "</tr>");
                                    out.println("<tr>\n"+
                                                    "<td><button class='btn btn-secondary' data-dismiss='modal'>Cerrar</button></td>\n" +
                                                    "<td><button class='btn btn-info'>Guardar</button></td>\n" +
                                                "</tr>");
                                out.println("</table>");
                            out.println("</div>");

                            
                        }
                        break;
                    }
                    case 5: 
                    {
                        
                        //ACTUALIZAR EL USUARIO ***********************************
                        int result =0;
                        
                        int id_user = Integer.parseInt(request.getParameter("cod_user"));
                        
                       
                        String mail = request.getParameter("mail");
                        String name = request.getParameter("name");
                        String lname = request.getParameter("lname");
                        String typeDoc = request.getParameter("typeDoc");
                        long nDocument = Long.parseLong(request.getParameter("nDocument"));
                        long phone = Long.parseLong(request.getParameter("phone"));
                        String dir = request.getParameter("dir");
                        String date = request.getParameter("date");
                        
                        CrudUserVO uVO = new CrudUserVO(typeDoc, nDocument, name, lname, 0, phone, dir, date, mail, 1);
                        CrudUserDAO uDAO = new CrudUserDAO(uVO);
                        
                        result = uDAO.modifyUser(id_user);
                        
                        response.sendRedirect("pages/Admin/modifyUser.jsp?res="+result+"");
                        
                        
                        
                        break;
                    }
                }

            }catch(SQLException ex){
                
                out.println("<script>");
                    
                        out.println("alert('Ocurrio un error al mostrar los usuarios"+ ex +" ');");
                    
                out.println("</script>");
                
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
