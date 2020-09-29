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
public class NotesVO {
    
    private double note1;
    private double note2;
    private double note3;
    private double note4;
    private int id_user;
    private int id_subject;

    public NotesVO(double note1, double note2, double note3, double note4, int id_user, int id_subject) {
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.id_user = id_user;
        this.id_subject = id_subject;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getNote3() {
        return note3;
    }

    public void setNote3(double note3) {
        this.note3 = note3;
    }

    public double getNote4() {
        return note4;
    }

    public void setNote4(double note4) {
        this.note4 = note4;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }
    
    
}
