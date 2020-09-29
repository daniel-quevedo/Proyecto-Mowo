/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class ClassConnection {
    
     //variables de conexion************************ 
    private String driver, urldb, user, pass, db;
    private Connection connection;
    
    public ClassConnection(){
        
        driver = "org.postgresql.Driver";
        user = "postgres";
        pass = "B@W5p~%\\Z@mCGRt";
        db = "mowo_o";
        urldb = "jdbc:postgresql://localhost:5432/"+db;            
        
        try{
            
    
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(urldb,user,pass);
            
            System.out.println("Se conecto correctamente a la base de datos");
   
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
    
            System.out.println("Ocurrio un erro al conectarse a la base de datos: "+ e.getMessage());   
            
        }
        
    }
    
    //retornar la conexion establecida 
    
    public Connection getConnection(){
        
        return connection;
        
    }
    
    //cerrar conexion *************
    public Connection closeConnection() throws SQLException{
        
        connection.close();
        connection = null;
        return connection;
        
    }
    
    public static void main(String[] args){
        
        new ClassConnection();
        
    }
}
