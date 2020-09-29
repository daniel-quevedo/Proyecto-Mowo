/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import DAO.LoginDAO;
import VOAdmin.AssocStudentTutorVO;
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
public class AssocStudentTutorDAO extends ClassConnection{
    
    //  VARIABLES DE CONEXION **
    
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet result;
    
    //***************************
    
    private int id_student;
    private int id_tutor;
    
    public AssocStudentTutorDAO(){
        
        try{
            this.conn = this.getConnection();
        }catch(Exception ex){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public AssocStudentTutorDAO(AssocStudentTutorVO aST){
        
        try{
            
            this.conn = this.getConnection();
            
            this.id_student = aST.getId_student();
            this.id_tutor = aST.getId_tutor();
            
        }catch(Exception ex){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public int assoc(){
        
        String sqlAssoc = "";
        
        int resReturn = 0;
        
        try{
            
            sqlAssoc = "SELECT mowo.f_asociar_estu_acu(?,?)";
            
            this.pstm = this.conn.prepareStatement(sqlAssoc);
            this.pstm.setInt(1, id_tutor);
            this.pstm.setInt(2, id_student);
            
            System.out.println(this.pstm);
            
            this.result = this.pstm.executeQuery();
            
            if(this.result.next())
                resReturn = this.result.getInt(1);
                
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error al momento de asociar el estudinte" +ex);
            
        }
        
        
        return resReturn;
    }
    
    
    public ResultSet listParents(){
        
        String sqlList= "";
        
        try{
            
            sqlList = "SELECT nombre||' '||apellido AS nombre, id_usuario FROM mowo.usuario WHERE fk_perfil = ?";
            
            this.pstm = this.conn.prepareStatement(sqlList);
            this.pstm.setInt(1, 4);
            
            this.result = this.pstm.executeQuery();
            
        }catch(SQLException ex){
            System.out.println("ocurrio un erro al listar los acudientes "+ ex );
        }
        
        return this.result;
    }
    
    public ResultSet listStudents(){
        
        String sqlList = "";
        
        try{
            
            sqlList = "SELECT id_usuario, identificacion, nombre||' '||apellido AS nombre, telefono, email \n" + 
                        "FROM mowo.usuario \n"+ 
                        "WHERE fk_perfil = ? \n"+
                        "AND id_acudiente IS NULL";
            
            this.pstm = this.conn.prepareStatement(sqlList);
            this.pstm.setInt(1, 3);
            
            this.result = this.pstm.executeQuery();
            
        }catch(SQLException ex){
            System.out.println("ocurrio un error al listar los estudiantes "+ex);
        }
        
        
        return this.result;
        
    }
    
}
