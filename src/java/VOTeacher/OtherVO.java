/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOTeacher;

/**
 *
 * @author Daniel
 */
public class OtherVO {
    
    private int idPro;
    private int codCourse;
    private int codAsig;
    private int idProfile;
    
    public OtherVO(int pamIdPro, int idProfile, int pamCodC, int pamAsig){
        
        this.idPro = pamIdPro;
        this.codCourse = pamCodC;
        this.codAsig = pamAsig;
        this.idProfile = idProfile;
        
    }
    
    public int getIdprofile(){
            
        return this.idProfile;
        
    }
    
    public void setIdProfile(int idProfile){
        
        this.idProfile = idProfile;
        
    }
    
    public int getIdPro(){
        
        return this.idPro;
        
    }
    
    public void setIdPro(int pamIdPro){
        
        this.idPro = pamIdPro;
        
    }

    public int getCodC(){
        
        return this.codCourse;
        
    }
    
    public void setCodC(int pamCodCO){
        
        this.codCourse = pamCodCO;
        
    }
    
    public void setCodAs(int pamAsig){
        
        this.codAsig = pamAsig;
        
    }
    
    public int getCodAs(){
        
        return this.codAsig;
        
    }
    
}
