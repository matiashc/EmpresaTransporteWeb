/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transporte;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class TestJdbc {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresatransporte?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Connection con = DriverManager.getConnection(url, "root", "12345678");
            Statement sentencia = con.createStatement();
            String sql = "SELECT nombre,nit,correo,clave FROM empresa";
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                System.out.println("Nombre de la empresa" + resultado.getString("nombre"));
                System.out.println("Nit de la empresa" + resultado.getString("nit"));
            }
            resultado.close();
            sentencia.close();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(TestJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
