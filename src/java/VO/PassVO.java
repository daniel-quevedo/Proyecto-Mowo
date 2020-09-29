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
public class PassVO {
    
    private String passUser;
    
    public PassVO(String passUser){
        
        this.passUser = passUser;
        
    }
    
    public String getPassUser(){
        return this.passUser;
    }
    
    public void setPassUser(String passUser){
        this.passUser = passUser;
    }
    
}
