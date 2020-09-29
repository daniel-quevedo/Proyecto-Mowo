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
public class CredentialsVO {
    
    private String user;
    private String pass;
    private String opt;
    
    public CredentialsVO(String user, String pass, String opt){
        
        this.user = user;
        this.pass = pass;
        this.opt = opt;
        
    }

    public String getOpt(){
        return this.opt;
    }
    
    public void setOpt(String opt){
        this.opt = opt;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
