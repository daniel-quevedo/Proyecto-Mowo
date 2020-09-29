/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTutor;

import DAO.LoginDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class ShowEstutorDAO extends ClassConnection{
    
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    
    public ShowEstutorDAO(){
        
        try{
        
            this.conn = this.getConnection();
            
        }catch(Exception ex){
            
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }
    
    public ResultSet listUser(int id_tutor){
        
        try{
            
            String sql= "SELECT id_usuario, identificacion, (nombre||' '||apellido)nombre \n"+
                        "FROM mowo.usuario \n"+
                        "WHERE id_acudiente = ?";
            
            this.pstm = this.conn.prepareStatement(sql);
            this.pstm.setInt(1, id_tutor);
            
            System.out.println(pstm);
            
            this.res = pstm.executeQuery();
            
        }catch(SQLException ex){
            System.out.println("ocurrio un error al listar los estudiantes del acudiente " + ex);
        }
        
        return this.res;
        
    }
    
}
