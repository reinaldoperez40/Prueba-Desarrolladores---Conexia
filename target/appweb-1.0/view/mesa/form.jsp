<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${msg != ''}">
    <div class='alert alert-success' role='alert'>${msg}</div>
</c:if>
<div class="well well-sm">
    <h1 class="page-header">
        Registro de Mesa
    </h1>

    <form id="frm-cliente" action="app?page=mesa&op=save" method="post">
        <div class="row">
            <input type="hidden" name="id" value="<c:out value="${mesa.id}"/>" />
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Ubicación</label>
                    <input type="text" name="ubicacion" id="ubicacion" value="<c:out value="${mesa.ubicacion}"/>"  class="form-control" placeholder="Ubicación" required/>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>No Max. Comensales</label>
                    <input type="text" name="nummaxcomensal" value="<c:out value="${mesa.nummaxcomensal}"/>" class="form-control" placeholder="Numero Maximo de Comensales" required/>
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
                <a class="btn btn-default" href="app?page=cliente&op=list">
                    <span class="glyphicon glyphicon-share"></span>
                    <span class="hidden-xs">Cerrar</span>
                </a>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#ubicacion').focus();
    });
</script>        
<%@ include file="/view/footer.jsp" %> 