<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nueva Empresa</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="${pageContext.request.contextPath}/empresas?accion=crear"
                method="POST" class="was-validated">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nit:</label>
            <input type="text" name="nit" class="form-control" id="recipient-name" required>
          </div>
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nombre:</label>
            <input type="text" name="nombre" class="form-control" id="recipient-name" required>
          </div>
            
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Correo:</label>
            <input type="text" name="correo" class="form-control" id="recipient-name" required>
          </div>
            
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Clave:</label>
            <input type="text" name="clave" class="form-control" id="recipient-name" required>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            <input type="submit" class="btn btn-primary" value="Guardar"/>
            </div>
        </form>
      </div>
      
    </div>
  </div>
</div>