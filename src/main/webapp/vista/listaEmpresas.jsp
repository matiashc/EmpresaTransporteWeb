<%-- 
    Document   : listaEmpresas
    Created on : 10 dic. 2020, 08:37:03
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Empresas</h1>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Agregar</button>
        <table class="table">
            <thead>
                <tr>    
                    <th>Nit</th> 
                    <th>Nombre</th> 
                    <th>Correo</th> 
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>    
                <c:forEach var="empresa" items="${empresas}" >
                    <tr>
                        <td>${empresa.nit}</td>
                        <td>${empresa.nombre}</td>
                        <td>${empresa.correo}</td>
                        <td><a href="${pageContext.request.contextPath}/empresas?accion=eliminar&nit=${empresa.nit}" class="btn btn-secondary" >
                            Eliminar
                            </a>
                        <a href="${pageContext.request.contextPath}/empresas?accion=editar&nit=${empresa.nit}" class="btn btn-secondary" >
                            Editar
                            </a>
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../WEB-INF/empresas/agregarEmpresa.jsp"/>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
