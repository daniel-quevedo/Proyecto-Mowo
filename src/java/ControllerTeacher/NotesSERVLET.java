/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerTeacher;

import DAOTeacher.NotesDAO;
import VOTeacher.NotesVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "NotesSERVLET", urlPatterns = {"/NotesSERVLET"})
public class NotesSERVLET extends HttpServlet {

    
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
            
            try{
                
                double note1, note2, note3, note4;
                int id_user, id_subj, result, returned;
                
                note1 = Double.parseDouble(request.getParameter("note1"));
                note2 = Double.parseDouble(request.getParameter("note2"));
                note3 = Double.parseDouble(request.getParameter("note3"));
                note4 = Double.parseDouble(request.getParameter("note4"));
                id_user = Integer.parseInt(request.getParameter("id_user"));
                id_subj = Integer.parseInt(request.getParameter("id_subject"));

                
                NotesVO nVO = new NotesVO(note1, note2, note3, note4, id_user, id_subj); 
                
                NotesDAO nDAO = new NotesDAO(nVO);
                
                result = nDAO.notes();

                switch (result) {
                    case 5:
                        returned = 1;
                        break;
                    case 1:
                        returned = 2;
                        break;
                    default:
                        returned = 0;
                        break;
                }
                
                
                response.sendRedirect("pages/Teacher/notas.jsp?result="+returned+"");
                
            }catch(Exception ex){
                
                out.println("Ocurrio un error al insertar las notas "+ ex);
                
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
