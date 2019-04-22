/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Detallefactura;
import com.conexia.entity.Factura;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author repe
 */
public class MDetallefactura {
   
    EntityManager em;


    public MDetallefactura() {

        em = EntityManagerUtil.getEntityManager();
       
    }

    public Detallefactura getById(int id) {
        return em.find(Detallefactura.class, id);
    }

    public List getAll() {
        String sql = "select c from Detallefactura c";
        return em.createQuery(sql, Detallefactura.class).getResultList();
    }
    
    public List getAllBy(Factura factura) {
      
        Query sql = em.createQuery("select distinct d from Detallefactura d join d.cocinero c where d.factura.id = :f");
        sql.setParameter("f", factura.getId());

        return sql.getResultList();
    }

    public Detallefactura create(Detallefactura c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Detallefactura update(Detallefactura c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Detallefactura c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    } 
    
}
