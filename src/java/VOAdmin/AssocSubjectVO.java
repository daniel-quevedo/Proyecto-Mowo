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
public class AssocSubjectVO{
 
    private int id_prof;
    private int id_subject;
    private int id_course;
    private String opt;

    public AssocSubjectVO(int id_prof, int id_subject, int id_course, String opt) {
        this.id_prof = id_prof;
        this.id_subject = id_subject;
        this.id_course = id_course;
        this.opt = opt;
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public int getId_asig() {
        return id_subject;
    }

    public void setId_asig(int id_subject) {
        this.id_subject = id_subject;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
    
    
    
    
    
}
