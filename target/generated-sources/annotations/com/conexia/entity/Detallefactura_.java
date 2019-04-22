package com.conexia.entity;

import com.conexia.entity.Cocinero;
import com.conexia.entity.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-17T17:28:58")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, Factura> factura;
    public static volatile SingularAttribute<Detallefactura, Cocinero> cocinero;
    public static volatile SingularAttribute<Detallefactura, Integer> id;
    public static volatile SingularAttribute<Detallefactura, String> plato;
    public static volatile SingularAttribute<Detallefactura, Integer> importe;

}