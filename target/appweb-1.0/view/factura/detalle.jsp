<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${msg != ''}">
    <div class='alert alert-success' role='alert'>${msg}</div>
</c:if>
<div class="well well-sm">
    <h1 class="page-header">
        Registro del Detalle Factura
    </h1>

    <form id="frm-factura" action="app?page=factura&op=detalle_save" method="post">
        <div class="row">
            <div class="col-sm-4">
                <input type="hidden" name="id" value="<c:out value="${dfactura.getId()}"/>"/>
                <input type="hidden" name="idfactura" value="<c:out value="${factura.getId()}"/>"/>
                <div class="form-group">
                    <label>Factura No</label>
                    <input type="text" name="nofactura" value="<c:out value="${factura.getId()}"/>" class="form-control" readonly="readonly"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Cocinero</label>
                    <select name="idcocinero" id="idcocinero" class="form-control selectpicker" data-show-subtext="true" data-live-search="true" required/>
                        <option value="">Seleccione</option>
                        <c:forEach var="r" items="${cocinero}" > 
                            <c:choose>
                                <c:when test="${r.getId() == dfactura.cocinero.getId()}">
                                    <option selected='selected' value="${r.getId()}">${r.getNombre()} ${r.getApellido1()} ${r.getApellido2()}</option>
                                </c:when>    
                                <c:otherwise>
                                    <option value="${r.getId()}">${r.getNombre()} ${r.getApellido1()} ${r.getApellido2()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Plato</label>
                    <input type="text" name="plato" value="<c:out value="${dfactura.getPlato()}"/>" class="form-control" required/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Importe</label>
                    <input type="number" name="importe" value="<c:out value="${dfactura.getImporte()}"/>" class="form-control" required/>
                </div>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col-sm-12 text-right"> 
                <button class="btn btn-primary">
                    <span class="glyphicon glyphicon-floppy-disk"></span>
                    <span class="hidden-xs">Guardar</span>
                </button>
                <a class="btn btn-default" href="app?page=factura&op=form?id=<c:out value="${factura.getId()}"/>">
                    <span class="glyphicon glyphicon-share"></span>
                    <span class="hidden-xs">Cerrar</span>
                </a>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#idcocinero').focus();
    });
</script>        
<%@ include file="/view/footer.jsp" %> 