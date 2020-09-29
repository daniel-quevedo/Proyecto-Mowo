/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VOStudents;

/**
 *
 * @author Daniel
 */
public class ShowNotesVO {
    
    private int id_student;
    private int period;
    
    public ShowNotesVO(int id_student, int period){
        
        this.id_student = id_student;
        this.period = period;
        
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    
    
    
}
