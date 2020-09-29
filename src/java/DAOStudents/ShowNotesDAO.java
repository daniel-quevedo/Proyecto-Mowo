/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOStudents;

import DAO.LoginDAO;
import VOStudents.ShowNotesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class ShowNotesDAO extends ClassConnection{
    
    //VARIABLES DE CONEXION*******************
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet res = null;
    
    
    //VARIABLES PARA LAS NOTAS***************
    private int id_student;
    private int period;
    
    public ShowNotesDAO(ShowNotesVO snVO){
        
        try{
         
            this.conn = this.getConnection();
        
            this.id_student = snVO.getId_student();
            this.period = snVO.getPeriod();
            
        }catch(Exception ex){
            
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
    }
    
    public ResultSet notesStudents(){
        
        try{
            
            String sqlNotes =   "SELECT A.nombre \n" +
                                        ",N.nota1 \n"+
                                        ",N.nota2 \n"+
                                        ",N.nota3 \n"+
                                        ",N.nota4 \n"+
                                        ",((N.nota1+N.nota2+N.nota3+N.nota4)/4) AS promedio \n"+
                                        ",(SELECT ((N.nota1+N.nota2+N.nota3+N.nota4)/4) >= 3.0) AS aprobar \n"+
                                "FROM mowo.usuario U \n" +
                                    "INNER JOIN mowo.notas N ON U.id_usuario = N.fk_estudiante \n" +
                                    "INNER JOIN mowo.asignaturas A ON A.id_asignatura = N.fk_asignatura \n" +
                                "WHERE N.periodo = ? \n" +
                                "AND U.id_usuario = ? ";
            
            this.pstm = this.conn.prepareStatement(sqlNotes);
            this.pstm.setInt(1, this.period);
            this.pstm.setInt(2, this.id_student);
            
            System.out.println(this.pstm);
            
            this.res = this.pstm.executeQuery();
            
            
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al insertar el usuario " + ex);
        }
        
        return this.res;
        
    }
    
    public static void main(String[] args) {
        
       
        
       try{
           
            ShowNotesVO uVO = new ShowNotesVO(18,1);

            ShowNotesDAO objP = new ShowNotesDAO(uVO);
            
            System.out.println(objP.notesStudents());

       }catch(Exception ex){
           
           
       }
       
       
    }
    
    
}
