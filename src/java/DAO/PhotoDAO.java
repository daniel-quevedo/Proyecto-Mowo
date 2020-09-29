/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.PhotoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class PhotoDAO extends ClassConnection{
    
    private Connection con;
    private int res =0;
    private PreparedStatement pstm;
    
    private String namePhoto;
    private int idUser;
    
    
    public PhotoDAO(PhotoVO pVO){
        
       try{
        
            this.con = this.getConnection();
            
            this.namePhoto = pVO.getNamePhoto();
            this.idUser = pVO.getIdUser();
        
        }catch(Exception ex){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        
    }
    
    public int insertPhoto(){
        
        String sqlUpdate = "UPDATE mowo.usuario SET foto = ? WHERE id_usuario = ?";
        
        try {
            
            this.pstm = this.con.prepareStatement(sqlUpdate);
            this.pstm.setString(1, this.namePhoto);
            this.pstm.setInt(2, this.idUser);
            
            this.res = this.pstm.executeUpdate();
            
            
        } catch (SQLException e) {
            
            System.err.println(" Error -> " + e.getMessage());
            
        }
        
        return this.res;
    }
    
    
    
    
}
