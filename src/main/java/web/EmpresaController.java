/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Datos.EmpresaDAOJDBC;
import java.io.IOException;
import java.util.List;
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
@WebServlet("/empresas")
public class EmpresaController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String accion = request.getParameter("accion");
       if (accion != null){
       switch(accion){
           case "editar":
               this.editar(request, response);
               break;
           case "eliminar":
               this.eliminar(request, response);
               break;
           default:
               this.listarEmpresa(request, response);
       }
       }
       else
         this.listarEmpresa(request, response); 
       
    }
    
    private void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       EmpresaDAOJDBC empresa = new EmpresaDAOJDBC();
       List<EmpresaDTO> empresas = empresa.consultar();
       HttpSession session = request.getSession();
       session.setAttribute("empresas", empresas);
       //request.getRequestDispatcher("vista/listaEmpresas.jsp").forward(request, response);
       response.sendRedirect("vista/listaEmpresas.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String accion = request.getParameter("accion");
       if (accion != null){
       switch(accion){
           case "crear":
               this.crear(request, response);
               break;
           case "modificar":
               this.modificar(request, response);
               break;
           default:
               this.listarEmpresa(request, response);
       }
       }
       else
         this.listarEmpresa(request, response);       
       
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String nit = request.getParameter("nit");
       String nombre = request.getParameter("nombre");
       String correo = request.getParameter("correo");
       String clave = request.getParameter("clave");
       EmpresaDTO empresa = new EmpresaDTO(nombre, nit, correo, clave);
       int registros = new EmpresaDAOJDBC().crear(empresa);     
       this.listarEmpresa(request, response);
        
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nit =request.getParameter("nit");
        EmpresaDTO empresaDto = new EmpresaDAOJDBC().encontrar(new EmpresaDTO(nit));
        request.setAttribute("empresadto", empresaDto);
        //String jspEditar = "../WEB-INF/empresas/editarEmpresa.jsp";
        request.getRequestDispatcher("/WEB-INF/empresas/editarEmpresa.jsp").forward(request, response);
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nit =request.getParameter("nit");
        int registros = new EmpresaDAOJDBC().eliminar(new EmpresaDTO(nit));
        this.listarEmpresa(request, response);
        
        
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String nit = request.getParameter("nit");
       String nombre = request.getParameter("nombre");
       String correo = request.getParameter("correo");
       String clave = request.getParameter("clave");
       EmpresaDTO empresa = new EmpresaDTO(nombre, nit, correo, clave);
       int registros = new EmpresaDAOJDBC().actualizar(empresa);     
       this.listarEmpresa(request, response);
    }
 }
