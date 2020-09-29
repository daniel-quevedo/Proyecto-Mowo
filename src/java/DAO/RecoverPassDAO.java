/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class RecoverPassDAO extends ClassConnection {
    
    
    //VARIABLES DE CONEXION*********+
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    
    //VARIABLE RETORNO*******
    
    private boolean returned = false;
       
    
    
    public RecoverPassDAO(){
        this.conn = this.getConnection();        
    }
    
    public boolean sendEmail(String email){
        try {
            String sql = ("SELECT email FROM mowo.usuario WHERE email = ? ");
            
            this.pstm = this.conn.prepareStatement(sql);
            
            this.pstm.setString(1, email);                       
            System.out.println(this.pstm);
            this.res = this.pstm.executeQuery();
            
            if (this.res.next()) {
                
                this.returned = true;
                
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al enviar el email " + e);
        }
        return this.returned;
    }
    
    
//    public static void main(String[] args) {
//        
//       try{                      
//            
//            RecoverPassDAO cDAO = new RecoverPassDAO(); 
//            
//            System.out.println(cDAO.sendEmail("juanRRamirez159753@gmail.com"));
//
//       }catch(Exception ex){
//           
//           
//       }              
//    }
       
}
