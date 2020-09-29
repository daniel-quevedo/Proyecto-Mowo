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
public class AssocStudentTutorVO {
    
    private int id_student;
    private int id_tutor;
    
    public AssocStudentTutorVO(int id_student, int id_tutor){
        
        this.id_student = id_student;
        this.id_tutor = id_tutor;
        
    }
    
    public int getId_student(){
        return this.id_student;
    }

    public int getId_tutor() {
        return id_tutor;
    }
    
    public void setId_student(int id_student){
        this.id_student = id_student;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }
    
}
