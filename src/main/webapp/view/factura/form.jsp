<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${msg != ''}">
    <div class='alert alert-success' role='alert'>${msg}</div>
</c:if>
<div class="well well-sm">
    <h1 class="page-header">
        Registro de Factura 
    </h1>

    <form id="frm-factura" action="app?page=factura&op=save" method="post">
        <div class="row">
            <div class="col-sm-12 text-right"> 
                <button class="btn btn-primary">
                    <span class="glyphicon glyphicon-floppy-disk"></span>
                    <span class="hidden-xs">Guardar</span>
                </button>
                <a class="btn btn-default" href="app?page=factura&op=list">
                    <span class="glyphicon glyphicon-share"></span>
                    <span class="hidden-xs">Cerrar</span>
                </a>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Factura No</label>
                    <input type="text" name="id" value="<c:out value="${factura.getId()}"/>" class="form-control" readonly="readonly"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Fecha</label>
                    <input type="date" name="fechafactura" id="fechafactura" value="<fmt:formatDate value="${factura.getFechafactura()}" pattern="yyyy-MM-dd"/>"  class="form-control" placeholder="Ingrese el nombre" required/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Cliente</label>
                    <select name="idcliente" class="form-control selectpicker" data-show-subtext="true" data-live-search="true">
                        <option value="">Seleccione</option>
                        <c:forEach var="r" items="${cliente}" > 
                            <option value="${r.getId()}" ${r.getId() == factura.getCliente().getId() ? "selected='selected'" : ""}>
                                ${r.getNombre()} ${r.getApellido1()} ${r.getApellido2()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Camarero</label>
                    <select name="idcamarero" class="form-control selectpicker" data-show-subtext="true" data-live-search="true">
                        <option value="">Seleccione</option>
                        <c:forEach var="r" items="${camarero}" > 
                            <option value="${r.getId()}" ${r.getId() == factura.getCamarero().getId() ? "selected='selected'" : ""}>
                                ${r.getNombre()} ${r.getApellido1()} ${r.getApellido2()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group">
                    <label>Mesa</label>
                    <select name="idmesa" class="form-control selectpicker" data-show-subtext="true" data-live-search="true" >
                        <option value="">Seleccione</option>
                        <c:forEach var="r" items="${mesa}" > 
                            <option value="${r.getId()}" ${r.getId() == factura.getMesa().getId() ? "selected='selected'" : ""}>
                                U-${r.getUbicacion()}-N-${r.getNummaxcomensal()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group">
                    <label>Total</label>
                    <input type="text" name="total" id="total" value="<c:out value="${factura.getTotal()}"/>" class="form-control" readonly="readonly">
                </div>
            </div>
        </div>
        <hr/> 
    </form>
    <c:if test="${factura.getId() > 0}">
        <div class="table-responsive">
            <table class="table table-hover" id="tabla">
                <thead>
                    <tr>
                        <th></th>
                        <th>Cocinero</th>
                        <th>Plato</th>
                        <th>Importe</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="d" items="${detallefactura}" > 
                        <tr>
                            <td width="5%">
                                <a class="btn btn-primary" href="app?page=factura&op=detalle_showedit&id=${d.getId()}">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                            </td>
                            <td>${d.cocinero.getNombre()} ${d.cocinero.getApellido1()} ${d.cocinero.getApellido2()}</td>
                            <td>${d.getPlato()}</td>
                            <td>${d.getImporte()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td></td>
                        <td>
                            <a class="btn btn-success" href="app?page=factura&op=detalle_showedit&factura=${factura.getId()}">
                                <span class="glyphicon glyphicon-plus"></span>
                                <span class="hidden-xs">Ingresar</span>
                            </a>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                </tfoot>
            </table> 
        </div>
    </c:if>
</div>
<script>
    $(document).ready(function () {
        $('#fechafactura').focus();

    });
</script>        
<%@ include file="/view/footer.jsp" %> 