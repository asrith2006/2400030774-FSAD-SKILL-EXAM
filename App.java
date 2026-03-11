package com.klu.skill2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Product p = new Product();
        p.setId(1);
        p.setName("Laptop");
        p.setDescription("HP Laptop");
        p.setPrice(50000);
        p.setQuantity(5);

        session.persist(p);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Product Inserted Successfully!");
    }
}
