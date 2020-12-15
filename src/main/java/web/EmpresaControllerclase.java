/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Datos.EmpresaDAO;
import Datos.EmpresaDAOJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.EmpresaDTO;

/**
 *
 * @author Matias
 */
@WebServlet("/empresa")
public class EmpresaControllerclase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           
//1. podemos capturar información del cliente.
        //2. crear un objeto modelo Java Beans
        EmpresaDAO ej= new EmpresaDAOJDBC();  
       List<EmpresaDTO> empresas = ej.consultar();
        //3. devolver resultados al cliente
        //tres formas atraves de un request, session, application
        request.setAttribute("empresas", empresas);
         
         //HttpSession session = request.getSession();
         //  session.setAttribute("rectangulo", rectangulo); 
           //session.setAttribute("alumno", this);
           
        //4. redireccionar la petición a la vista
        request.getRequestDispatcher("vista/empresas.jsp").forward(request, response);
       // dp.forward(request, response);
        
    }
    
    
}


