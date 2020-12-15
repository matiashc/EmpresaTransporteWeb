/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transporte;

import Datos.EmpresaDAO;
import Datos.EmpresaDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresaDTO;

/**
 *
 * @author Matias
 */
public class Test {
    public static void main(String[] args) {
        
        EmpresaDAO d = new EmpresaDAOJDBC();
        List<EmpresaDTO> empresas = new ArrayList<>();
        empresas = d.consultar();
        for(EmpresaDTO empres : empresas){
            System.out.println(empres);
        }
    }
    
}
