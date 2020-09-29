/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Daniel
 */
public class LoginVO {
    
    //VARIABLES DE INICIO DE SESION
  
    private String user;
    private String passUsu;
    
    public LoginVO(){
        
    }
    
    public LoginVO(String pamUser, String pamPass){
        
        this.user = pamUser;
        this.passUsu = pamPass;
        
    }
    
    //METODOS GET************
    
    public String getUser(){
        
        return this.user;
        
    }
    
    public String getPass(){
        
        return this.passUsu;
        
    }
    
    //METODOS SET************
    
    public void setUser(String pamUser){
        
        this.user = pamUser;
        
    }
    
    public void setPass(String pamPass){
        
        this.passUsu = pamPass;
        
    }
    
}
