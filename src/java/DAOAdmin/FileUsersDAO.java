/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ClassConnection;

/**
 *
 * @author Daniel
 */
public class FileUsersDAO extends ClassConnection {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    
    
    public FileUsersDAO() {

        this.conn = this.getConnection();

    }

    public ResultSet insertUsers(String pathFile, int option) {

        String sql = "SELECT mowo.f_usuarios_masivos(?,?)";

        try {

            this.pstm = this.conn.prepareStatement(sql);

            this.pstm.setString(1, pathFile);
            this.pstm.setInt(2, option);

            System.out.println(this.pstm);

            this.res = this.pstm.executeQuery();
            

        } catch (SQLException e) {

            System.out.println("Ocurrio un error al insertar usuarios masivos " + e.getMessage());

        }

        return this.res;

    }

}

