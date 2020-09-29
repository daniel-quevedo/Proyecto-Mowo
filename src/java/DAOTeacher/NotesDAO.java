/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTeacher;

import DAO.LoginDAO;
import VOTeacher.NotesVO;
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
public class NotesDAO extends ClassConnection{
    
    //VARIABLES DE CONEXION *************************
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet res;
    
    //VARIABLE DE RETORNO
    
    private int result;
    
    
    //VARIABLES PARA INSERTAR LAS NOTAS ********************
    
    private double note1;
    private double note2;
    private double note3;
    private double note4;
    private int id_user;
    private int id_subject;
    
    public NotesDAO(NotesVO nVO){
        
        try{
            
            this.con = this.getConnection();

            this.note1 = nVO.getNote1();
            this.note2 = nVO.getNote2();
            this.note3 = nVO.getNote3();
            this.note4 = nVO.getNote4();
            this.id_user = nVO.getId_user();
            this.id_subject = nVO.getId_subject();
            
        }catch(Exception ex){
            
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public int notes(){
        
        String sqlInsert = "SELECT mowo.f_insert_notas(?,?,?,?,?,?);";
        
        result = 0;
        
        try{
            
            this.pstm = this.con.prepareStatement(sqlInsert);
            this.pstm.setDouble(1, this.note1);
            this.pstm.setDouble(2, this.note2);
            this.pstm.setDouble(3, this.note3);
            this.pstm.setDouble(4, this.note4);
            this.pstm.setInt(5, this.id_user);
            this.pstm.setInt(6, this.id_subject);
            
            this.res = this.pstm.executeQuery();

            if (this.res.next()) {
                
                result = this.res.getInt(1);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error al momento de insertar las notas " + ex);
            
        }
        
        return this.result;
        
    }
    
    
     public static void main(String[] args) {
        
        try{
           
            
            
            NotesVO nVO = new NotesVO(1.5,3.5,4.5,5.0,10,1);
        
            NotesDAO objP = new NotesDAO(nVO);
            
            System.out.println(objP.notes());

       }catch(Exception ex){
           
           
       }
        
    }
    
    
}
