/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerAdmin;

import DAOAdmin.AssocSubjectDAO;
import VOAdmin.AssocSubjectVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "AssocSubjectSERVLET", urlPatterns = {"/AssocSubjectSERVLET"})
public class AssocSubjectSERVLET extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AssocAsigSERVLET</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AssocAsigSERVLET at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        
        try (PrintWriter out = response.getWriter()) {

            int result;
            
            try{
                
                int option = Integer.parseInt(request.getParameter("option"));
                int id_course = Integer.parseInt(request.getParameter("idCourse"));
                int id_teacher = Integer.parseInt(request.getParameter("idTeacher"));
                
                int res = 0;
                
                
                switch(option){
                    
                    case 1:
                        
                        
                        //ASOCIAR ASIGNATURAS AL CURSO O AL PROFESOR****************
                        try{
                            
                            String[] subjects = request.getParameterValues("subject");
                            String opt = request.getParameter("opt");
                           
                            
                            for(int i = 0; i < subjects.length; i++){
                                
                                int id_subject = Integer.parseInt(subjects[i]);

                                AssocSubjectVO acVO = new AssocSubjectVO(id_teacher,id_subject,id_course,opt);
                                AssocSubjectDAO objP = new AssocSubjectDAO(acVO);

                                result = objP.assoc();

                                if (result == -1) {
                                    res--;
                                } else if (result == 1) {
                                    res++;
                                }

                                objP.closeConnection();

                            }

                            if (res > 0) {
                                response.sendRedirect("pages/Admin/assocSubjectTeacher.jsp?src=" + res + "&opt=1");
                            } else if (res < 0) {
                                response.sendRedirect("pages/Admin/assocSubjectCourse.jsp?src=" + res + "&opt=2");
                            }
                            
                        }catch(SQLException ex){
                            System.out.println("ocurrio un error al asociar la asignatura " + ex);
                        }
                       
                        
                        break;
                        
                    case 2:
                        
                        AssocSubjectVO asSubjectVO = new AssocSubjectVO(id_teacher,0,id_course,"");
                        AssocSubjectDAO asSubjectDAO = new AssocSubjectDAO(asSubjectVO);

                        ResultSet listSubjects = asSubjectDAO.listSubjects();
                        
                        asSubjectDAO.closeConnection();
                        
                        out.println("<thead>\n" +
                                        "<tr>\n" +
                                            "<th><i data-feather=\"check\"></i></th>\n" +
                                            "<th>Nombre</th>\n" +
                                            "<th>Salon</th>\n" +
                                        "</tr>\n" +
                                    "</thead>");
                        
                        out.println("<tbody>");
                        
                        while (listSubjects.next()) {
                            out.println("<tr>");
                                out.println("<td>\n"
                                        + "<input type='checkbox' name='subject' value='" + listSubjects.getInt(1) + "'>\n"
                                        + "</td>");
                                out.println("<td> " + listSubjects.getString(2) + " </td>");
                                out.println("<td> " + listSubjects.getString(3) + " </td>");
                            out.println("</tr>");
                        }
                        
                        out.println("</tbody>");
                        out.println("<script src=\"../../js/feather.min.js\" charset=\"utf-8\"></script>\n" +
                                    "<script> feather.replace(); </script>");       
                        break;
                }
            }catch(Exception ex){

                out.println("ocurrio un error inesperado "+ ex);

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
