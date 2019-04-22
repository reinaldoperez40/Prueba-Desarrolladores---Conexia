<div id="menu">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Menu</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav">
                    <li class="dropdown" >
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administrador <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li >
                                <a href="app?page=cocinero&op=list">Cocineros</a>
                            </li>
                            <li >
                                <a href="app?page=camarero&op=list">Camareros</a>
                            </li>
                            <li >
                                <a href="app?page=mesa&op=list">Mesas</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown" >
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Informes <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li >
                                <a href="app?page=informes&op=list1">Cuentas Camareros</a>
                            </li>
                            <li >
                                <a href="app?page=informes&op=list2">Clientes VIP</a>
                            </li>

                        </ul>
                    </li>
                    <li class="dropdown" >
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ventas <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li >
                                <a href="app?page=cliente&op=list">Clientes</a>
                            </li>
                            <li >
                                <a href="app?page=factura&op=list">Facturas</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>