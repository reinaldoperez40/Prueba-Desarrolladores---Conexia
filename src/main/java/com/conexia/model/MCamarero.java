/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Camarero;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author repe
 */
public class MCamarero {
    
    EntityManager em;

    public MCamarero() {

        em = EntityManagerUtil.getEntityManager();
    }

    public Camarero getById(int id) {
        return em.find(Camarero.class, id);
    }

    public List getAll() {
        TypedQuery<Camarero> sql = em.createNamedQuery("Camarero.findAll", Camarero.class);
        return sql.getResultList();
    }

    public Camarero create(Camarero c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Camarero update(Camarero c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Camarero c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
