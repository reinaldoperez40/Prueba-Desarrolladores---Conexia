/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Camarero;
import com.conexia.entity.Mesa;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author repe
 */
public class MMesa {
        
    EntityManager em;

    public MMesa() {

        em = EntityManagerUtil.getEntityManager();
    }

    public Mesa getById(int id) {
        return em.find(Mesa.class, id);
    }

    public List getAll() {
        TypedQuery<Mesa> sql = em.createNamedQuery("Mesa.findAll", Mesa.class);
        return sql.getResultList();
    }

    public Mesa create(Mesa c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Mesa update(Mesa c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Mesa c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
