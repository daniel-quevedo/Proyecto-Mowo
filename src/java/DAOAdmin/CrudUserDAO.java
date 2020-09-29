/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import DAO.LoginDAO;
import VOAdmin.CrudUserVO;
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
public class CrudUserDAO extends ClassConnection{
    
    //variables de conexion *************
    
    private Connection con; 
    private PreparedStatement pstm;
    private ResultSet res;
    
    //variables con datos de usuario********
    
    private String typeDoc;
    private long nDocument;
    private String name;
    private String lname;
    private int typeUser;
    private long phone;
    private String dir;
    private String date;
    private String mail;
    private int active;
    
    
    
    public CrudUserDAO(){
        this.con = this.getConnection();
    }
    
    public CrudUserDAO(CrudUserVO uVO){
        
        try{

            this.con = this.getConnection();
            
            this.typeDoc = uVO.getTypeDoc();
            this.nDocument = uVO.getnDocument();
            this.name = uVO.getName();
            this.lname = uVO.getLname();
            this.typeUser = uVO.getTypeUser();
            this.phone = uVO.getPhone();
            this.dir = uVO.getDir();
            this.date = uVO.getDate();
            this.mail = uVO.getMail();
            this.active = uVO.getActive();      
            
        }catch(Exception ex){
            
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
    }
    
    public int insertUser(){
        
        int result = 0;
        String sqlUser = "SELECT mowo.f_insert_usu(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try{
            this.pstm = this.con.prepareStatement(sqlUser);
            
            this.pstm.setString(1, this.typeDoc);
            this.pstm.setLong(2, this.nDocument);
            this.pstm.setString(3, this.name);
            this.pstm.setString(4, this.lname);
            this.pstm.setInt(5, this.typeUser);
            this.pstm.setLong(6, this.phone);
            this.pstm.setString(7, this.dir);
            this.pstm.setString(8, this.date);
            this.pstm.setString(9, this.mail);
            this.pstm.setInt(10, this.active);
            
            
            
            this.res = this.pstm.executeQuery();
            
            
            if (this.res.next()) {
                result = res.getInt(1);
            }
            
            
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al insertar el usuario " + ex);
        }
        
        return result;
        
    }
    
    public ResultSet dataUsers(){
        
        
        //MOSTRAR LOS DATOS DEL USUARIO EN EL MODAL SEGUN SU IDENTIFICACION PARA MODIFICAR***********
        String where = ";";
        
        if(this.nDocument != 0){
            where = "WHERE identificacion = ?;";
        }
        //************************************************************************
        
        try{                                    
            String sqlDataUser = "SELECT activo\n" +
                                    ",nombre\n" +
                                    ",apellido\n" +
                                    ",tipo_iden\n" +
                                    ",identificacion\n" +
                                    ",fk_perfil\n" +
                                    ",telefono\n" +
                                    ",direccion\n" +
                                    ",fecha_nacimiento\n" +
                                    ",email\n" +
                                    ",id_usuario\n"+
                            "FROM mowo.usuario \n" +
                            where;
            
            this.pstm = this.con.prepareStatement(sqlDataUser);
            
            
            //EN CASO DE QUE SE QUIERA MOSTRAR LOS DATOS EN EL MODAL*****************
            if(this.nDocument != 0){
                this.pstm.setLong(1, this.nDocument);
            }
            //*******************************************************************
            
            this.res = this.pstm.executeQuery();
            
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al mostrar los usuarios " + ex);
        }
            
        return this.res;
        
    }
    
    public int modifyUser(int id_usuario){
        
        int result = 0;
        
        String sqlModify = "";
        
        
        try{
            
            sqlModify = "SELECT mowo.f_modificar_usuario(?,?,?,?,?,?,?,?,?,?,?);";
            
            this.pstm = this.con.prepareStatement(sqlModify);
            this.pstm.setInt(1, id_usuario);
            this.pstm.setString(2, this.name);
            this.pstm.setString(3, this.lname);
            this.pstm.setLong(4,this.phone);
            this.pstm.setString(5, this.dir);
            this.pstm.setString(6, this.date);
            this.pstm.setString(7, this.mail);
            this.pstm.setString(8, this.typeDoc);
            this.pstm.setLong(9, this.nDocument);
            this.pstm.setInt(10, 0);
            this.pstm.setInt(11, 0);
            
            System.out.println(this.pstm);
            
            this.res = this.pstm.executeQuery();
            
            if(this.res.next()){
                
                result = this.res.getInt(1);
                
            }

            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un erro al modificar los usuario: " + ex);
            
        }
        
        
        return result;
        
    }   
    
    public ResultSet infProfile(int iduser){
        
        String sql = "SELECT    tipo_iden\n"
                                +",identificacion\n"
                                +",nombre\n"
                                +",apellido\n"
                                +",telefono\n"
                                +",fk_perfil\n"
                                +",direccion\n"
                                +",fecha_nacimiento\n"
                                +",email\n"
                                +",C.codigo\n" 
                                +",C.nombre_curso\n" 
                                +",foto\n"
                    + "FROM mowo.usuario U\n"
                    + "LEFT OUTER JOIN mowo.curso C\n"
                    + "ON U.fk_curso = C.id_curso WHERE id_usuario = ?";
        
        try {
        
            this.pstm = this.con.prepareStatement(sql);
            this.pstm.setInt(1, iduser);      
            
            this.res = this.pstm.executeQuery();
            
        } catch (SQLException e) {
            
            System.err.println(" Error -> " + e.getMessage());
            
        }
        
        return this.res;
    }
    
    
    
//    public static void main(String[] args) {
//        
//       
//        
//       try{
//           
//            CrudUserVO uVO = new CrudUserVO("CC", 44455555, "Blaadooooo", "Bldooooo", 0, 151551, "cra 14 a este", "2020-01-01", "ju@gmail.com",1);
//
//            CrudUserDAO objP = new CrudUserDAO(uVO);
//            
//            System.out.println(objP.modifyUser());
//
//       }catch(Exception ex){
//           
//           
//       }
//       
//       
//    }
    
}
