/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Camarero;
import com.conexia.entity.Detallefactura;
import com.conexia.entity.Factura;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author repe
 */
public class MFactura {

    EntityManager em;

    public MFactura() {

        em = EntityManagerUtil.getEntityManager();
    }
   
    public Factura getById(int id) {
        return em.find(Factura.class, id);
    }

    public List getAll() {
        TypedQuery<Factura> sql = em.createNamedQuery("Factura.findAll", Factura.class);
        return sql.getResultList();
    }

    public List getByTotalForCamarero() {
        TypedQuery<Factura> sql = em.createNamedQuery("Factura.findByTotalForCamarero", Factura.class);
        return sql.getResultList();    
    }
    
    public List getByTopCliente() {
        TypedQuery<Factura> sql = em.createNamedQuery("Factura.findByTopCliente", Factura.class);
        return sql.getResultList();    
    }
                
    public List getByWithOutTotalForCamarero() {
        TypedQuery<Factura> sql = em.createNamedQuery("Factura.findByWithOutTotalForCamarero", Factura.class);
        return sql.getResultList();    
    }
    
    public Factura create(Factura c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Factura update(Factura c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Factura c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
