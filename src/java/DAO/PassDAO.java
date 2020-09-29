/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.PassVO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class PassDAO extends ClassConnection{
    
    //VARIABLES DE CONEXION ****************
    
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet res;
    
    private String passUser;
    
    //variable para encriptar el password***********
    
    private String passEncryp;
    
    public PassDAO(PassVO pVO){
        
        try{
        
            this.con = this.getConnection();
        
            this.passUser = pVO.getPassUser();
        
        }catch(Exception ex){
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public String getMD5(){
        
        try{
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encryBytes = md.digest(this.passUser.getBytes());

            BigInteger number = new BigInteger(1, encryBytes);

            this.passEncryp =  number.toString(16);

            while(passEncryp.length() < 32){

                this.passEncryp = "0" + this.passEncryp;

            }
            
            return this.passEncryp;
        
        }catch(NoSuchAlgorithmException ex){
         
            throw new RuntimeException(ex);
            
        }
    
    }
    
}
