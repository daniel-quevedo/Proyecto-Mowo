/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerAdmin;

import DAOAdmin.FileUsersDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import mail.MailMassives;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "FileUsersSERVLET", urlPatterns = {"/FileUsersSERVLET"})
@MultipartConfig
public class FileUsersSERVLET extends HttpServlet {

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
            
            
            int records =0; //cantidad de usuarios insertados *************
            
            try {
                
                
                //RECUPERAR VALORES DEL ARCHIVO***********************
                String name = request.getParameter("nameFile");
                Part file = request.getPart("file");
                
                String destiPath = "C:\\Users\\Daniel\\Documents\\PROYECTO\\Actualizado\\Mowo_o\\web\\files\\"+name;
                
                
                InputStream inputS = file.getInputStream();


                //RUTA EN LA QUE QUEDARA GUARDADO EL ARCHIVO **********
                File destiDirectory = new File(destiPath);

                FileOutputStream fileOut = new FileOutputStream(destiDirectory);


                //ESCRIBIR TODO EL ARCHIVO EN EL DIRECTORIO DADO ******
                int date = inputS.read();
                while (date != -1) {

                    fileOut.write(date);
                    date = inputS.read();

                }

                inputS.close();
                fileOut.close();
                
                //INSERTAR USUARIOS DEL ARCHIVO A LA DB ****************************
                
                FileUsersDAO insertUsers = new FileUsersDAO();
                
                ResultSet res = insertUsers.insertUsers(destiPath, 1); //SUBE LOS REGISTROS A UNA TABLA TEMPORAL (USUARIOS_MASIVOS)
                
                while (res.next()) { //enviar los correos a los usuarios masivos en segundo plano ********
                    
                    Runnable mm = new MailMassives(res.getString(1));
                    
                    Thread t = new Thread(mm);
                    
                    t.start();
                    
                }
                
                res = insertUsers.insertUsers(destiPath, 2); //SUBE LOS REGISTROS A LA TABLA USUARIO
                while (res.next()) 
                    records ++;
                
                //ELIMINAR ARCHIVO DEL SERVIDOR*************************
                
                File delete = new File(destiPath);
                
                if (delete.delete()) 
                    System.out.println("El archivo se elimino por locas");
                else
                    System.out.println("Ocurrio un error al eliminar el archivo");
                
                
            } catch (FileNotFoundException  e) {
            
                System.err.println("Error -> " + e.getMessage());
                
            } catch (IOException e) {
                
                System.err.println("Error -> " + e.getMessage());
                
            } catch (SQLException ex) {
                Logger.getLogger(FileUsersSERVLET.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("pages\\Admin\\insertUser.jsp?records="+records);
            
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
