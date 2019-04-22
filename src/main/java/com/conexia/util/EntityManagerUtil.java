/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author repe
 */
public class EntityManagerUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    
/*
    public static void main(String[] args) {
        EntityManager m = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + m.getClass().getCanonicalName());
        System.out.println("Starting Transaction");
        
        Cliente c = new Cliente();
        MCliente cliente = new MCliente();
        c.setId(1);
        c.setNombre("nombre");
        c.setApellido1("apellido1");
        c.setApellido2("apellido2");
        c.setObservaciones("observaciones");
        
        System.out.println("Saving Cliente to Database");
        m.getTransaction().begin();
        m.persist(c);
        m.getTransaction().commit();
        System.out.println("Save ok");
        m.close();

    }
*/
}
