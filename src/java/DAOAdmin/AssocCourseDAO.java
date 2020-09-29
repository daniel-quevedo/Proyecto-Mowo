/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import DAO.LoginDAO;
import VOAdmin.AssocCourseVO;
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
public class AssocCourseDAO extends ClassConnection {

    //variables de conexion 
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;

    //variables para asociar el curso al usuario
    private int id_course;
    private int id_user;
    private String opt;

    //variable para validar retorno de consulta insert y update
    private int resultQuery = 0;
    private int result = 0;

    public AssocCourseDAO() {
        try {
            this.conn = this.getConnection();

        } catch (Exception e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public AssocCourseDAO(AssocCourseVO acVO) {

        try {
            this.conn = this.getConnection();

            this.id_course = acVO.getId_course();
            this.id_user = acVO.getId_user();
            this.opt = acVO.getOpt();

        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int assoc() {

        int result = 0;

        String sqlAssoc = "SELECT mowo.f_asociar_curso(?,?,?);";

        try {

            this.pstm = this.conn.prepareStatement(sqlAssoc);
            this.pstm.setInt(1, this.id_user);
            this.pstm.setInt(2, this.id_course);
            this.pstm.setString(3, this.opt);

            System.out.println(this.pstm);

            this.res = this.pstm.executeQuery();

            if (this.res.next()) {

                result = this.res.getInt(1);

            }

        } catch (SQLException ex) {

            System.out.println("ocurrio un error al asociar el usuario" + ex);

        }

        return result;

    }

    public ResultSet listTutor() {

        try {

            String sqlList = "SELECT id_usuario, nombre, apellido, identificacion,telefono,email FROM mowo.usuario\n"
                    + "WHERE fk_perfil = ? \n"
                    + "AND    (id_usuario NOT IN(SELECT fk_curso_prof \n"
                    + "FROM mowo.prof_curso \n"
                    + "WHERE fk_prof_curso = ?)\n"
                    + "OR NOT EXISTS (SELECT fk_curso_prof \n"
                    + "FROM mowo.prof_curso \n"
                    + "WHERE fk_prof_curso = ?)\n"
                    + ")\n"
                    + "AND activo = ?"
                    + "ORDER BY nombre ASC";

            this.pstm = this.conn.prepareStatement(sqlList);
            this.pstm.setInt(1, 2);
            this.pstm.setInt(2, id_course);
            this.pstm.setInt(3, id_course);
            this.pstm.setInt(4, 1);
            this.res = this.pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al mostrar los usuarios " + e);
        }

        return this.res;
    }

    public ResultSet listStudent() {

        try {

            String sqlList = "SELECT id_usuario, nombre, apellido, identificacion,telefono,email, fk_curso\n"
                    + "FROM mowo.usuario \n"
                    + "WHERE fk_perfil = ? \n"
                    + "AND activo = ? \n"
                    + "AND fk_curso IS NULL ";
            this.pstm = this.conn.prepareStatement(sqlList);
            this.pstm.setInt(1, 3);
            this.pstm.setInt(2, 1);

            this.res = this.pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al mostrar los usuarios " + e);
        }

        return this.res;
    }

    public ResultSet listCourse(int view) {

        String where = "";

        try {

            if (view == 1) {
                where = "WHERE estado = 1";
            }
            if (this.id_course != 0) {
                where = "WHERE id_curso=?";
            }

            String sqlListC = "SELECT id_curso, (codigo||' '||nombre_curso)AS nombre, nombre_curso ,codigo, estado "
                    + "FROM mowo.curso "
                    + where
                    + "ORDER BY nombre_curso ASC";

            this.pstm = this.conn.prepareStatement(sqlListC);

            if (this.id_course != 0) {
                this.pstm.setInt(1, this.id_course);
            }

            System.out.println(this.pstm);

            this.res = this.pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al mostrar los cursos " + e);
        }

        return this.res;
    }

    public int insertCourse(String pamname, int pamcode) {

        String sqlInsCourser = "INSERT INTO mowo.curso(nombre_curso,codigo,estado) VALUES(?,?,1) ";

        try {
            this.pstm = this.conn.prepareStatement(sqlInsCourser);
            this.pstm.setString(1, pamname);
            this.pstm.setInt(2, pamcode);

            resultQuery = this.pstm.executeUpdate();

            if (resultQuery == 1) {
                result = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Ocurrio un error al insertar el curso " + ex);
        }

        return result;
    }

    public int modifyCourse(String pamNCourse, int pamcode, int pamid) {

        String sqlModify = "";
        try {
            sqlModify = "UPDATE mowo.curso SET nombre_curso=?, codigo=?, estado=1\n"
                    + "WHERE id_curso=?";
            this.pstm = this.conn.prepareStatement(sqlModify);
            this.pstm.setString(1, pamNCourse);
            this.pstm.setInt(2, pamcode);
            this.pstm.setInt(3, pamid);

            resultQuery = this.pstm.executeUpdate();

            if (resultQuery == 1) {
                result = 1;
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un erro al modificar los usuario: " + e);
        }

        return result;
    }

//    public static void main(String[] args) {
//        
//        try{
//           //primera opcion:id_usu segunda opcion:id_curso tercera opcion: (A)estudiante (B)profesor
//            //AssocCourseVO acVO = new AssocCourseVO(67,4,"A");
//
//            AssocCourseDAO objP = new AssocCourseDAO();
//            
//            System.out.println(objP.listTutor(1));
//
//       }catch(Exception ex){
//           
//           
//       }
//        
//    }
}
