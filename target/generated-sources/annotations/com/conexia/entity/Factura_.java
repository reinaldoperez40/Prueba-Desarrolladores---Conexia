package com.conexia.entity;

import com.conexia.entity.Camarero;
import com.conexia.entity.Cliente;
import com.conexia.entity.Mesa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-17T17:28:58")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Cliente> cliente;
    public static volatile SingularAttribute<Factura, Integer> total;
    public static volatile SingularAttribute<Factura, Mesa> mesa;
    public static volatile SingularAttribute<Factura, Date> fechafactura;
    public static volatile SingularAttribute<Factura, Integer> id;
    public static volatile SingularAttribute<Factura, Camarero> camarero;

}