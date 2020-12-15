/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author Matias
 */
public class ConexionBD {

    public static final String JDBC_URL = "jdbc:mysql://35.175.102.52:3306/empresatransporte?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String BD_USUARIO = "empresa";
    public static final String BD_CLAVE = "12345678";
    
    public static DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(BD_USUARIO);
        bs.setPassword(BD_CLAVE);
        bs.setInitialSize(5);
        return bs;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
        
    }    
    public static void close(Connection con) throws SQLException {
        con.close();      
    }
    
    public static void close(ResultSet res) throws SQLException{
        res.close();        
    }
    
    public static void close(Statement sen) throws SQLException{
        sen.close();
    }
    
    public static void close(PreparedStatement psen) throws SQLException{
        psen.close();
    }
    
    
    
    
    
    

}
