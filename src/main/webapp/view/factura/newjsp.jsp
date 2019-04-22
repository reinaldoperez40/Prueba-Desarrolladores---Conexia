<td width="5%">
                            <a class="btn btn-primary" href="app?page=factura&op=showedit&id=${r.getId()}">
                                <span class="glyphicon glyphicon-edit"></span>
                            </a>
                        </td>
                        <td>${r[0].getId()}</td>
                        <td><fmt:formatDate value="${r[0].getFechafactura()}" pattern="yyyy-MM-dd" /></td>
                        <td>${r[1].getNombre()} ${r[1].getApellido1()} ${r[1].getApellido2()} </td>
                        <td>${r[2].getNombre()} ${r[2].getApellido1()} ${r[2].getApellido2()}</td>
                        <td>U-${r[3].getUbicacion()}-N-${r[3].getNummaxcomensal()}</td>
                        <td>${r[0].getTotal()}</td>