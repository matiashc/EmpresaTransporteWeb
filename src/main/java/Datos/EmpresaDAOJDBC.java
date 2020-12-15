/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EmpresaDTO;

/**
 *
 * @author Matias
 */
public class EmpresaDAOJDBC implements EmpresaDAO{

    public static final String SQL_CONSULTA = "SELECT nombre,nit,correo,clave FROM empresa";
    public static final String SQL_INSERTAR = "INSERT INTO empresa (nombre, nit, correo, clave) VALUES (?,?,?,?)";
    public static final String SQL_ACTUALIZAR = "UPDATE empresa SET nombre = ?, correo = ?, clave = ? WHERE nit = ?";
    public static final String SQL_ELIMINAR = "DELETE FROM empresa WHERE nit = ?";
    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombre, nit,correo, clave FROM empresa WHERE nit = ?";
    
    public List<EmpresaDTO> consultar() {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        EmpresaDTO empresa = null;
        List<EmpresaDTO> empresas = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTA);
            res = sen.executeQuery();
            while (res.next()) {
                String nombre = res.getString("nombre");
                String nit = res.getString("nit");
                String correo = res.getString("correo");
                String clave = res.getString("clave");
                empresa = new EmpresaDTO(nombre, nit, correo, clave);
                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return empresas;
    }

    public int crear(EmpresaDTO p) {
        Connection con = null;
        PreparedStatement sen= null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_INSERTAR);
            sen.setString(1, p.getNombre());
            sen.setString(2, p.getNit());
            sen.setString(3, p.getCorreo());
            sen.setString(4, p.getClave());
            registros = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {               
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizar(EmpresaDTO p) {
        Connection con = null;
        PreparedStatement sen= null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_ACTUALIZAR);
            sen.setString(1, p.getNombre());
            sen.setString(2, p.getCorreo());
            sen.setString(3, p.getClave());
            sen.setString(4, p.getNit());
            registros = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {               
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int eliminar(EmpresaDTO p) {
        Connection con = null;
        PreparedStatement sen= null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_ELIMINAR);
            sen.setString(1, p.getNit());
            registros = sen.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {               
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public EmpresaDTO encontrar(EmpresaDTO p) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID);
            sen.setString(1, p.getNit());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombre = res.getString("nombre");
            String correo = res.getString("correo");
            String clave = res.getString("clave");
            p.setNombre(nombre);
            p.setCorreo(correo);
            p.setClave(clave);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return p;

    }
    
    

}
