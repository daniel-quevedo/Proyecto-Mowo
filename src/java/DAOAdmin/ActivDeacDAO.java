/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import VOAdmin.ActivDeacVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class ActivDeacDAO extends ClassConnection{
    
    //VARIABLES DE CONEXION ************
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet res;
    
    
    //VARIABLES PARA ACTIVAR O DESACTIVAR EL USUARIO***
    
    private int id_user;
    private int id_course;
    private String opt;
    
    private int result;
    
    public ActivDeacDAO(){
        
    }
    
    public ActivDeacDAO(ActivDeacVO adVO){
        
        this.con = this.getConnection();
        
        this.id_user = adVO.getId_user();
        this.opt = adVO.getOpt();
        this.id_course = adVO.getId_course();
    }
    
    public int activDeac(){
        
        result = 0;
        
        String sqlActDea = "SELECT mowo.f_activar_desacti_usu(?,?);";
        
        try{
            
            this.pstm = this.con.prepareStatement(sqlActDea);
            
            this.pstm.setInt(1, this.id_user);
            this.pstm.setString(2, this.opt);
            
            this.res = this.pstm.executeQuery();

            if (this.res.next()) {
                
                result = this.res.getInt(1);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error inesperado al activar o desactivar el usuario: " + ex);
            
        }
        
        return result;
    }
    public int actDeacCourse(){
        result = 0;        
        
        String sqlActDeaCourse = "SELECT mowo.f_activar_desacti_Course(?,?);";
        
        try{
            
            this.pstm = this.con.prepareStatement(sqlActDeaCourse);
            
            this.pstm.setInt(1, this.id_course);
            this.pstm.setString(2, this.opt);
                        
            System.out.println(this.pstm);
            
            this.res = this.pstm.executeQuery();
            
            if (this.res.next()) {
                
                result = this.res.getInt(1);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error inesperado al activar o desactivar el usuario: " + ex);
            
        }
        
        return result;
    }
    
    
//      public static void main(String[] args) {
//        
//          //opcion B es para desactivar el usuario y A para activar***********
//          
//        try{
//            
//            ActivDeacVO adVO = new ActivDeacVO(45,"B"); 
//
//            ActivDeacDAO objP = new ActivDeacDAO(adVO);
//            
//            System.out.println(objP.activDeac());
//
//       }catch(Exception ex){
//           
//           
//       }
//        
//    }
    
    
}
