<%-- 
    Document   : editarEmpresa
    Created on : 15 dic. 2020, 11:32:15
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="modal-body">
          <form action="${pageContext.request.contextPath}/empresas?accion=modificar"
                method="POST" class="was-validated">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nit:</label>
            <input type="text" name="nit" value="${empresadto.nit}" class="form-control" id="recipient-name" required>
          </div>
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nombre:</label>
            <input type="text" name="nombre" value="${empresadto.nombre}" class="form-control" id="recipient-name" required>
          </div>
            
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Correo:</label>
            <input type="text" name="correo" value="${empresadto.correo}" class="form-control" id="recipient-name" required>
          </div>
            
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Clave:</label>
            <input type="text" name="clave" value="${empresadto.clave}" class="form-control" id="recipient-name" required>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            <input type="submit" class="btn btn-primary" value="Editar"/>
            </div>
        </form>
      </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
