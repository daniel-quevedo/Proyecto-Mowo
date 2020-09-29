/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTeacher;

import DAO.LoginDAO;
import VOTeacher.OtherVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class OtherDAO extends ClassConnection{
    
    //VARIABLES CONEXION A LA BASE DE DATOS
    
    private Connection conn = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet res = null;
    
    //VARIABLES DE RETORNO******
    private boolean returns = false;
    
    //VARIABLE TRAER LOS CURSOS DEL PROFESOR**********
    private int idPro;
    
    //VARIABLE TRAER LOS CURSOS ************
    private int codCourse;
    
    //VARIABLE TRAER LAS ASIGNATURAS**********
    
    private int codAsig;
    
    
    public OtherDAO(){
    }
    
    public OtherDAO(OtherVO oVO){
        
        
        try{
            
            this.conn = this.getConnection();
        
            this.idPro = oVO.getIdPro();
            
            this.codCourse = oVO.getCodC();
            
            this.codAsig = oVO.getCodAs();
            
        }catch(Exception ex){
            
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }
    
    public ResultSet Courses(){
        
        String sqlCours =   "SELECT C.id_curso, (C.codigo||' '||C.nombre_curso) AS nombre\n" +
                            "FROM mowo.curso C \n" +
                                "INNER JOIN mowo.prof_curso CP ON C.id_curso = CP.fk_prof_curso\n" +
                                "INNER JOIN mowo.usuario U ON U.id_usuario = CP.fk_curso_prof\n" +
                            "WHERE U.id_usuario = ? \n"+
                            "AND U.fk_perfil = 2\n"+
                            "AND C.estado = 1";
        try{
            
            
            this.pstm = this.conn.prepareStatement(sqlCours);
            
            this.pstm.setInt(1, this.idPro);
            
            this.res = this.pstm.executeQuery();
            
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error al verificar el curso " + ex);
            
        }
        
        return this.res;
        
    }
    
    public ResultSet Subjects(){
        
        String sqlAsig =    "SELECT A.id_asignatura \n" +
                                    ",A.nombre \n" +
                            "FROM mowo.asignaturas A \n" +
                                "INNER JOIN mowo.curso_asignatura CA ON A.id_asignatura = CA.fk_curso_asig \n" +
                                "INNER JOIN mowo.prof_curso PC ON PC.fk_prof_curso = CA.fk_asig_curso \n" +
                                "INNER JOIN mowo.usuario U ON PC.fk_curso_prof = U.id_usuario \n" +
                                "INNER JOIN mowo.prof_asig PA ON PA.fk_prof_asig = A.id_asignatura \n" +
                            "WHERE CA.fk_asig_curso = ? \n" +
                            "AND U.id_usuario = ?" +
                            "AND PA.fk_asig_prof = ?" +
                            "AND U.fk_perfil = 2";
        
        try{
            
            this.pstm = this.conn.prepareStatement(sqlAsig);
            this.pstm.setInt(1,this.codAsig);
            this.pstm.setInt(2, this.idPro);
            this.pstm.setInt(3, idPro);
            
            this.res = this.pstm.executeQuery();
            
            
        }catch(SQLException ex){
            
            System.out.println("Ocurrio un error al traer las asignaturas " +ex);
            
        }
        
        return this.res;
        
    }
    
    public ResultSet students(){
        
        int periodo =0;
        
        
        //MOSTRAR LAS NOTAS EN EL MODAL PARA MODIFICARLAS**********
        String where = ";";
        if(this.idPro != 0){
            
            where = "AND U.id_usuario = ?;";
            
        }
        //***********************************************
        
        try{
            
            String sqlPeriodo = "SELECT mowo.f_periodo();";
            this.pstm = this.conn.prepareStatement(sqlPeriodo);
            this.res = this.pstm.executeQuery();
            
            if (this.res.next()) {
                
                periodo = this.res.getInt(1);
                
            }
            
            this.pstm = null;
            this.res = null;
            
            
            String sqlStudents =   "SELECT (U.nombre ||' '|| U.apellido) AS nombre \n" +
                                            ",U.id_usuario \n" +
                                            ",N.nota1 \n" +
                                            ",N.nota2 \n" +
                                            ",N.nota3 \n" +
                                            ",N.nota4  \n" +
                                            ",((N.nota1+N.nota2+N.nota3+N.nota4)/4) AS promedio \n" +
                                    "FROM mowo.notas N \n" +
                                        "INNER JOIN mowo.usuario U ON U.id_usuario = N.fk_estudiante \n" +
                                    "WHERE N.fk_asignatura = ? \n" +
                                    "AND U.fK_curso = ? \n" +
                                    "AND N.periodo = ? \n" +
                                    where;
            
            this.pstm = this.conn.prepareStatement(sqlStudents);
            
            this.pstm.setInt(1, this.codAsig);
            this.pstm.setInt(2, this.codCourse);
            this.pstm.setInt(3, periodo);
            
            
            //opcion en caso de que sea mostrar las notas en el modal***************
            if(this.idPro != 0){
            
                this.pstm.setInt(4, this.idPro);
            
            }
            //*****************************************************************
            System.out.println(this.pstm);
            
            this.res = this.pstm.executeQuery();
            
            
        }catch(SQLException ex){
            
            System.out.println("ocurrio un error al momento de traer los estudiantes " +ex);
            
        }
        
        return this.res;
        
    }
    
}
