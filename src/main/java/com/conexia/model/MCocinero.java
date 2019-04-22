/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Cliente;
import com.conexia.entity.Cocinero;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author repe
 */
public class MCocinero {

    EntityManager em;

    public MCocinero() {
        em = EntityManagerUtil.getEntityManager();
    }

    public Cocinero getById(int id) {
        return em.find(Cocinero.class, id);
    }

    public List getAll() {
        //String sql = "select c from Cocinero c";
        //return em.createQuery(sql, Cocinero.class).getResultList();
        TypedQuery<Cocinero> sql = em.createNamedQuery("Cocinero.findAll", Cocinero.class);
        return sql.getResultList();
    }

    public Cocinero create(Cocinero c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Cocinero update(Cocinero c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Cocinero c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
