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
public class CrudUserVO {
    
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

    
    public CrudUserVO(int nDocument){
        this.nDocument = nDocument;
    }

    public CrudUserVO(String typeDoc, long nDocument, String name, String lname, int typeUser, long phone, String dir, String date, String mail, int active) {
        this.typeDoc = typeDoc;
        this.nDocument = nDocument;
        this.name = name;
        this.lname = lname;
        this.typeUser = typeUser;
        this.phone = phone;
        this.dir = dir;
        this.date = date;
        this.mail = mail;
        this.active = active;
    }
    
    public int getActive(){
        return this.active;
    }
    
    public void setActive(int active){
        this.active = active;
    }
    
    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public long getnDocument() {
        return nDocument;
    }

    public void setnDocument(int nDocument) {
        this.nDocument = nDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
   
   
    
    
}
