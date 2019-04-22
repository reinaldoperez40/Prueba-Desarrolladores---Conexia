/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.model;

import com.conexia.entity.Cliente;
import com.conexia.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author repe
 */
public class MCliente {

    EntityManager em;

    public MCliente() {

        em = EntityManagerUtil.getEntityManager();
    }

    public Cliente getById(int id) {
        return em.find(Cliente.class, id);
    }

    public List getAll() {
        TypedQuery<Cliente> sql = em.createNamedQuery("Cliente.findAll", Cliente.class);
        return sql.getResultList();
    }
    
    public List getByCliente() {
        Query sql = em.createQuery("");
        return sql.getResultList();
    }

    public Cliente create(Cliente c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public Cliente update(Cliente c) {
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    public void delete(Cliente c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }
}
