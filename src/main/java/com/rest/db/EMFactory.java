package com.rest.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum  EMFactory {
    EM;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("tr-test");
        em = emf.createEntityManager();
    }
    public EntityManager  getEntityManager() {
        return em;
    }

}
