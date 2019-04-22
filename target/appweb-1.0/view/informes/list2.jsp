<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="well well-sm">
    <h1 class="page-header">Clientes VIP : Facturas Superiores a ($ 100.000)</h1>
    <form class="form-inline"id="frm-accidente" >
        <div class="form-group">
            <a class="btn btn-default" href="app?page=informes&op=list2">
                <span class="glyphicon glyphicon-refresh"></span>
            </a>
        </div>
        <div class="form-group">    
            <div class="input-group">
                <input type="text" name="Buscar" id="Buscar" class="form-control" placeholder="Buscar...">
                <span class="input-group-btn">
                    <button class="btn btn-info" type="button"><span class="glyphicon glyphicon-search"></span></button>
                </span>
            </div>
        </div>
    </form>  
    
    <div class="table-responsive">
        <table class="table table-hover" id="tabla">
            <thead>
                <tr>
     
                    <th>Cliente</th>
                    <th>Factura No </th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${inf2}" > 
                    <tr>
                        <td>${r.cliente.getNombre()} ${r.cliente.getApellido1()} ${r.cliente.getApellido2()} </td>
                        <td>${r.getId()}</td>
                        <td>${r.getTotal()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </div>
</div>
<%@ include file="/view/footer.jsp" %> 
<script>
    $(document).ready(function () {
        $("#Buscar").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#tabla tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
        $('a[rel=popover]').popover({
            html: true,
            trigger: 'hover',
            placement: 'bottom',
            content: function () {
                return '<img class="img-responsive" src="' + $(this).data('img') + '" />';
            }
        });
    });
</script>