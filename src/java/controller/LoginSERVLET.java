/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LoginDAO;
import DAO.PassDAO;
import VO.LoginVO;
import VO.PassVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "LoginSERVLET", urlPatterns = {"/LoginSERVLET"})
public class LoginSERVLET extends HttpServlet {

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
        
        int logout =  Integer.parseInt(request.getParameter("logout"));
        
        if (logout == 1) {
            
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
            
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
        try (PrintWriter out = response.getWriter()) {
            
            String user = request.getParameter("user");
            String passUsu = request.getParameter("passUsu");
            
            
            //ENCRIPTAR LA CONTRASEÑA ****************************
            
            PassVO pVO = new PassVO(passUsu);
            
            PassDAO pDAO = new PassDAO(pVO);
            
            String passEncryp = pDAO.getMD5();
            
            //VALIDAR EL USUARIO **********************************

            LoginVO VUser = new LoginVO(user, passEncryp);
            LoginDAO DUser = new LoginDAO(VUser);
            
            boolean result = DUser.verifyUser();
            
            String[] valuesUsu;
            valuesUsu = DUser.nomUser();
            
            if (result) {
                
                
                HttpSession mySession = request.getSession(true);
                
                mySession.setMaxInactiveInterval(60*10);
                mySession.setAttribute("codUser", valuesUsu[0]);
                mySession.setAttribute("nameUser", valuesUsu[1]);
                mySession.setAttribute("idProfile", valuesUsu[2]);
                mySession.setAttribute("email", valuesUsu[3]);
                
                int id_profile = Integer.parseInt(valuesUsu[2]);
                
                switch(id_profile){
                    case 1:
                        response.sendRedirect("pages/Admin/index.jsp");
                        break;
                    case 2:
                        response.sendRedirect("pages/Teacher/index.jsp");
                        break;
                    case 3:
                        response.sendRedirect("pages/Students/index.jsp");
                        break;
                    case 4:
                        response.sendRedirect("pages/tutor/index.jsp");
                        break;
                    default :
                        break;
                }
            }else{
                
                
                request.setAttribute("error", "<script> swal({title:'Error', text:'Usuario y/o contraseña incorrectas', icon:'error', timer:5000}); </script>");
                
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                
            }
            
            
        }catch(Exception ex){
            
            
            
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
