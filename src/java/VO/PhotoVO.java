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
public class PhotoVO {
    
    private String namePhoto;
    private int idUser;
    
    public PhotoVO(String namePhoto, int idUser){
        
        this.namePhoto = namePhoto;
        this.idUser = idUser;
        
    }
    
    public void setNamePhoto(String namePhoto){
        this.namePhoto = namePhoto;
    }

    public String getNamePhoto() {
        return this.namePhoto;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
    
    
}
