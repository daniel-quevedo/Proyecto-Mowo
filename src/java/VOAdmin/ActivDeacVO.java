/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOAdmin;

/**
 *
 * @author Daniel
 */
public class ActivDeacVO {
    
    private int id_user;    
    private String opt;
    private int id_course;
    
    
    
    
    public ActivDeacVO(int id_user, String opt,int id_course){
        
        this.id_user = id_user;
        this.opt = opt;
        this.id_course = id_course;
        
    }
      

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }          

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
    
    
    
}
