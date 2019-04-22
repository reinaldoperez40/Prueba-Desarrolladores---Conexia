<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${msg != ''}">
    <div class='alert alert-success' role='alert'>${msg}</div>
</c:if>
<div class="well well-sm">
    <h1 class="page-header">
        Registro de Cocinero
    </h1>

    <form id="frm-cocinero" action="app?page=cocinero&op=save" method="post">
        <div class="row">
            <input type="hidden" name="id" value="<c:out value="${cocinero.id}"/>" />
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="nombre" id="nombre" value="<c:out value="${cocinero.nombre}"/>"  class="form-control" placeholder="Ingrese el nombre" required/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>1er Apellido</label>
                    <input type="text" name="apellido1" value="<c:out value="${cocinero.apellido1}"/>" class="form-control" placeholder="Ingrese el 1er Apellido" required/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>2do Apellido</label>
                    <input type="text" name="apellido2" value="<c:out value="${cocinero.apellido2}"/>" class="form-control" placeholder="Ingrese el 2do Apellido" required/>
                </div>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="col-sm-12 text-right"> 
                <button class="btn btn-primary">
                    <span class="glyphicon glyphicon-floppy-disk"></span>
                    <span class="hidden-xs">Guardar</span>
                </button>
                <a class="btn btn-default" href="app?page=cocinero&op=list">
                    <span class="glyphicon glyphicon-share"></span>
                    <span class="hidden-xs">Cerrar</span>
                </a>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#nombre').focus();
    });
</script>        
<%@ include file="/view/footer.jsp" %> 