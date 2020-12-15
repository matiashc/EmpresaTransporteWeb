/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.List;
import modelo.EmpresaDTO;

/**
 *
 * @author Matias
 */
public interface EmpresaDAO {
    public List<EmpresaDTO> consultar(); 
    public int crear(EmpresaDTO empresaDTO);
    public int actualizar(EmpresaDTO empresaDTO);
    public int eliminar(EmpresaDTO empresaDTO);
    
}
