/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PhotoDAO;
import VO.PhotoVO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author daniel
 */
@WebServlet(name = "PhotoUserSERVLET", urlPatterns = {"/PhotoUserSERVLET"})
@MultipartConfig
public class PhotoUserSERVLET extends HttpServlet {

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
            
            try {
                
                String option = request.getParameter("option");
                
                //RECUPERAR VALORES DE LA IMAGEN***********************
                String namePhoto = request.getParameter("nameFile");
                String currentName = request.getParameter("currentName");
                Part file = request.getPart("file");
                
                String destiPath = "", destiPathDelete = "";
                
                //ELIMIAR LA FOTO ANTERIOR DEL USUARIO CORRESPONDIENTE (SI EXISTE)***
                destiPathDelete = "C:\\Users\\Daniel\\Documents\\PROYECTO\\Actualizado\\Mowo_o\\web\\photos\\" + currentName;
                
                File filePhoto = new File(destiPathDelete);
                
                if (filePhoto.exists()) {
                    
                    if (filePhoto.delete())
                        System.out.println("El archivo se ha eliminado");
                    else
                        System.err.println("Ocurrio un error al eliminar el archivo");                    
                
                }else
                    System.err.println("El archivo no existe");
                
                String idUsetS = (String) request.getSession().getAttribute("codUser");
                
                namePhoto = idUsetS+namePhoto;
                
                destiPath = "C:\\Users\\Daniel\\Documents\\PROYECTO\\Actualizado\\Mowo_o\\web\\photos\\" + namePhoto;
                
                InputStream inputS = file.getInputStream();

                //RUTA EN LA QUE QUEDARA GUARDADA LA IMAGEN **********
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
                               
                
                //INSERTAR EL NOMBRE DE LA FOTO EN LA BASE DE DATOS

                String idUserString = (String)request.getSession().getAttribute("codUser");
                int idUser = Integer.parseInt(idUserString);
                
                PhotoVO pVO = new PhotoVO(namePhoto, idUser);
                PhotoDAO pDAO = new PhotoDAO(pVO);
                int result = pDAO.insertPhoto();
                
                switch(option){
                    case "1":
                        response.sendRedirect("pages/Admin/perfil.jsp?src="+result);
                        break;
                    case "2":
                        response.sendRedirect("pages/Teacher/perfil.jsp?src="+result);
                        break;
                    case "3":
                        response.sendRedirect("pages/Students/perfil.jsp?src="+result);
                        break;
                    case "4":
                        response.sendRedirect("pages/Tutor/perfil.jsp?src="+result);
                        break;
                }
                
                
                
            } catch (IOException | ServletException e) {
                
                System.err.println(" Error -> "+ e.getMessage());
                
            }catch (SecurityException ex){
                
                ex.printStackTrace();
                
            }
        }catch(Exception ex){
            
            System.err.println(" Error2 -> "+ ex.getMessage());
            
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
