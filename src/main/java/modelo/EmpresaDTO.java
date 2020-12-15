/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Matias
 */
public class EmpresaDTO {
    private String nombre;
    private String nit;
    private String correo;
    private String clave;

    public EmpresaDTO() {
    }

    public EmpresaDTO(String nombre, String nit, String correo, String clave) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.clave = clave;
    }

    public EmpresaDTO(String nit) {
        this.nit = nit;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", nit=" + nit + ", correo=" + correo + ", clave=" + clave + '}';
    }
    
     
    
}
