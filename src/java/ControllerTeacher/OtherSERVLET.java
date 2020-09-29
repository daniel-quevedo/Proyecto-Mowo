
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerTeacher;

import DAOTeacher.OtherDAO;
import VOTeacher.OtherVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "OtherSERVLET", urlPatterns = {"/OtherSERVLET"})
public class OtherSERVLET extends HttpServlet {    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       // try (PrintWriter out = response.getWriter()) {
            /*TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet OtherSERVLET</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet OtherSERVLET at " + request.getParameter("cod")+ "</h1>");
//            out.println("</body>");
//            out.println("</html>");
 //       }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            

        } 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        try(PrintWriter out = response.getWriter()){
            
            int option = Integer.parseInt(request.getParameter("Option"));
            int idProf = Integer.parseInt(request.getParameter("codProfile"));
            int subject;
            int codUsers;
            int courses;
            int cont;
            
            switch(option){
                //Mostrar los cursos segun el profesor
                case 1: 
                    
                    codUsers = Integer.parseInt(request.getParameter("codUser"));

                    OtherVO oVO = new OtherVO(codUsers,idProf,0,0);
                    OtherDAO oDAO = new OtherDAO(oVO);

                    ResultSet valCourses = oDAO.Courses();

                    oDAO.closeConnection();
                    
                    out.println("<input type='hidden' value='"+codUsers+"' name='cod' id='cod'>");   
                    out.println("<select class='form-control' name='course' id='course' onchange='encontrar()'>");
                    out.println("<option value=''>..Cursos..</option>");

                    while(valCourses.next()){

                        out.println("<option value='"+valCourses.getInt(1)+"'>"+valCourses.getString(2)+"</option>");

                    }
                    out.println("</select>"); 
                    
                    codUsers = 0;
                    
                    break;
                    
                    //Mostrar las asignaturas segun el curso selccionado
                    
                case 2: 
                    int course = Integer.parseInt(request.getParameter("Course"));
                    codUsers = Integer.parseInt(request.getParameter("codUser"));

                    OtherVO VAs = new OtherVO(codUsers,idProf,0,course);
                    OtherDAO DAs = new OtherDAO(VAs);

                    ResultSet asig = DAs.Subjects();
                    
                    DAs.closeConnection();

                    out.println("<select>");
                    out.println("<option value='#'>...Asignaturas...</option>");
                    while(asig.next()){
                        out.println("<option value='"+asig.getInt(1)+"'> "+asig.getString(2)+" </option>");    
                    } 
                    out.println("</select>");
                    
                    
                    break;
                    
                    //Mostrar las notas del estuiante
                    
                case 3:
                    
                    subject = Integer.parseInt(request.getParameter("subject"));
                    courses = Integer.parseInt(request.getParameter("Course"));
                    cont =1;
                    
                    
                    OtherVO VStu = new OtherVO(0,idProf,courses,subject);
                    OtherDAO DStu = new OtherDAO(VStu);
                    
                    ResultSet students = DStu.students();
                    
                    DStu.closeConnection();
                    
                    out.println("<table class='table table-hover table-borderless backg '>");
                        out.println("<thead'>");
                            out.println("<tr>");
                            
                                out.println("<th scope='col'>N°</th>");
                                out.println("<th scope='col'>Nombres Completos</th>");
                                out.println("<th scope='col'>Nota 1</th>");
                                out.println("<th scope='col'>Nota 2</th>");
                                out.println("<th scope='col'>Nota 3</th>");
                                out.println("<th scope='col'>Nota 4</th>");
                                out.println("<th scope='col'>Promedio</th>");

                            out.println("<tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        
                        while(students.next()){
                            out.println("<tr>");
                                out.println("<th scope='row'>"+(cont++)+"</th>");
                                out.println("<td><a href='#ventana1' onClick='modal("+students.getInt(2)+")' data-toggle='modal' title='Editar notas'>"+students.getString(1)+"</a></td>");
                                out.println("<td>"+students.getDouble(3)+"</td>");
                                out.println("<td>"+students.getDouble(4)+"</td>");
                                out.println("<td>"+students.getDouble(5)+"</td>");
                                out.println("<td>"+students.getDouble(6)+"</td>");
                                out.println("<td>"+students.getFloat(7)+"</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                    out.println("</table>");

                    
                    break;
                case 4:
                    
                    subject = Integer.parseInt(request.getParameter("subject"));
                    codUsers = Integer.parseInt(request.getParameter("codUser"));
                    courses = Integer.parseInt(request.getParameter("Course"));
                    cont =1;
                    
                    
                    OtherVO VStu2 = new OtherVO(codUsers,idProf,courses,subject);
                    OtherDAO DStu2 = new OtherDAO(VStu2);
                    
                    ResultSet students2 = DStu2.students();
                    
                    DStu2.closeConnection();
                    
                    if(students2.next()){
                    
                        out.println("<div id=\"tableNotes\">"+
                                    "<table class=\"table table-responsive-sm table-light\" id=\"tableNotes\"> \n"+
                                    "<tr> \n" +
                                        "<td>Nota 1</td> \n" +
                                        "<td><input class=\"form-control\" name=\"note1\" id=\"note1\" type=\"number\" min=\"1\" max=\"5\" pattern=\"[1-9]\" step=\"0.1\" value="+students2.getDouble(3)+" required></td>\n" +
                                    "</tr>\n" +
                                    "<tr>\n" +
                                        "<td>Nota 2</td>\n" +
                                        "<td><input class=\"form-control\" name=\"note2\" id=\"note2\" type=\"number\" min=\"1\" max=\"5\"pattern=\"[1-9]\" step=\"0.1\" value="+students2.getDouble(4)+" required></td>\n" +
                                    "</tr>\n" +
                                    "<tr>\n" +
                                        "<td>Nota 3</td>\n" +
                                        "<td><input class=\"form-control\" name=\"note3\" id=\"note3\" type=\"number\" min=\"1\" max=\"5\" pattern=\"[1-9]\" step=\"0.1\" value="+students2.getDouble(5)+" required></td>\n" +
                                    "</tr>\n" +
                                    "<tr>\n" +
                                        "<td>Nota 4</td>\n" +
                                        "<td><input class=\"form-control\" name=\"note4\" id=\"note4\" type=\"number\" min=\"1\" max=\"5\"pattern=\"[1-9]\" step=\"0.1\" value="+students2.getDouble(6)+" required></td>\n" +
                                    "</tr>\n" +
                                    "<tr>\n" +
                                        "<td><button type=\"reset\" class=\"btn btn-secondary\" data-dismiss=\"modal\" >Cerrar</button></td>\n" +
                                        "<td><button type=\"submit\" class=\"btn btn-info\" >Guardar</button></td>\n" +                                        
                                    "</tr>\n" +
                                "</table>"+
                                "</div>");
                        
                    }
                    
                    break;
            }
            
        }catch(Exception ex){
            
            System.out.println("Ocurrio un error al buscar los estudiantes " +ex );
            
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
