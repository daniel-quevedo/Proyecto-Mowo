/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerAdmin;

import DAOAdmin.AssocCourseDAO;
import VOAdmin.AssocCourseVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "AssocCourseSERVLET", urlPatterns = {"/AssocCourseSERVLET"})
public class AssocCourseSERVLET extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
            int id_course = Integer.parseInt(request.getParameter("idCourse"));
            int res = 0;

            switch (option) {

                case 1:
                    
                    //ASOCIAR CURSO A ESTUDIANTE O PROFESOR**********************
                    
                    try {
                        
                        String[] users = request.getParameterValues("user");

                        String opt = request.getParameter("opt");

                        for (int i = 0; i < users.length; i++) {

                            int id_user = Integer.parseInt(users[i]);

                            AssocCourseVO acVO = new AssocCourseVO(id_user, id_course, opt);

                            AssocCourseDAO acDAO = new AssocCourseDAO(acVO);

                            int result = acDAO.assoc();

                            if (result == -1) {
                                res--;
                            } else if (result == 1) {
                                res++;
                            }

                            acDAO.closeConnection();

                        }

                        if (res < 0) {
                            response.sendRedirect("pages/Admin/assocCourseTeacher.jsp?src=" + res + "&opt=2");
                        } else if (res > 0) {
                            response.sendRedirect("pages/Admin/assocCourseStu.jsp?src=" + res + "&opt=3");
                        }

                    } catch (Exception ex) {

                        out.println("Ocurio un error al momento de asociar el usuario " + ex);

                    }

                    break;
                    
                case 2:
                    
                    AssocCourseVO DcoStuV = new AssocCourseVO(0,id_course,"");
    
                    AssocCourseDAO TuStu = new AssocCourseDAO(DcoStuV);

                    ResultSet resUser = TuStu.listTutor();
                    
                    try{
                        
                        out.println("<thead>\n" +
                                        "<tr>\n" +
                                            "<th><i data-feather=\"check\"></th>\n" +
                                            "<th>Nombre</th>\n" +
                                            "<th>Apellido</th>\n" +
                                            "<th>No Documento</th>\n" +
                                            "<th>Telefono</th>\n" +
                                            "<th>Correo</th>\n" +
                                        "</tr>\n" +
                                    "</thead>");
                        
                        out.println("<tbody>");
                        
                        while (resUser.next()) {
                            out.println("<tr>");
                            out.println("<td>\n"
                                    + "<input type='checkbox' name='user' value='" + resUser.getInt(1) + "'>\n"
                                    + "</td>");
                            out.println("<td> " + resUser.getString(2) + " </td>");
                            out.println("<td> " + resUser.getString(3) + " </td>");
                            out.println("<td> " + resUser.getLong(4) + " </td>");
                            out.println("<td> " + resUser.getLong(5) + " </td>");
                            out.println("<td> " + resUser.getString(6) + " </td>");

                            out.println("</tr>");
                        }
                        
                        out.println("</tbody>");
                        
                    }catch(SQLException ex){
                        System.out.println("ocurrio un error al listar los profesores" + ex);
                    }
                    
                    TuStu.closeConnection();
                    out.println("<script src=\"../../js/feather.min.js\" charset=\"utf-8\"></script>\n" +
                                    "<script> feather.replace(); </script>");
                    break;
                    
            }
        } catch (Exception ex) {
            Logger.getLogger(AssocCourseSERVLET.class.getName()).log(Level.SEVERE, null, ex);
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
