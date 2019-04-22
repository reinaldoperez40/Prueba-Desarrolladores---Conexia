<%@ include file="/view/header.jsp" %>
<%@ include file="/view/menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="well well-sm">
    <h1 class="page-header">Cuentas Camarero</h1>
    <form class="form-inline"id="frm-accidente" >
        <div class="form-group">
            <a class="btn btn-default" href="app?page=informes&op=list1">
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
    <div class="row">
        <div class="col-sm-12">
        <h3>Camareros con Facturas</h3>
        </div>
    </div>
    
    <div class="table-responsive">
        <table class="table table-hover" id="tabla">
            <thead>
                <tr>
                
                    <th>Camarero</th>
                    <th>Mes</th>
                    <th>Total Facturado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${inf1}" > 
                    <tr>
                    
                        <td>${r[0].camarero.getNombre()} ${r[0].camarero.getApellido1()} ${r[0].camarero.getApellido2()} </td>
                        <td>${r[1]}</td>
                        <td>${r[2]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </div>
    <div class="row">
        <div class="col-sm-12">
        <h3>Camareros sin Facturas</h3>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-hover" id="tabla">
            <thead>
                <tr>
    
                    <th>Camarero</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${inf12}" > 
                    <tr>
             
                        <td>${r.getNombre()} ${r.getApellido1()} ${r.getApellido2()} </td>
                        <th></th>
                    <th></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </div>
</div>
<%@ include file="/view/footer.jsp" %> 
<script>
$(document).ready(function(){
    $("#Buscar").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tabla tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
    $('a[rel=popover]').popover({
      html: true,
      trigger: 'hover',
      placement: 'bottom',
      content: function(){return '<img class="img-responsive" src="'+$(this).data('img') + '" />';}
    });
});
</script>
