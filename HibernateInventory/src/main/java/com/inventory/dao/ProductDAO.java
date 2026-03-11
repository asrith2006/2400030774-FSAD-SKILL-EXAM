package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;
import java.util.List;

public class ProductDAO {

    public void saveProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    public Product getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public void deleteProduct(int id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {
                session.remove(product); // or session.delete(product) for old versions
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not found");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public void updateProduct(int id, double price, int quantity) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {

                product.setPrice(price);
                product.setQuantity(quantity);

                session.update(product);

                System.out.println("Product updated successfully");

            } else {

                System.out.println("Product not found");

            }

            tx.commit();

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);

        dao.saveProduct(p1);
        dao.saveProduct(p2);

        System.out.println("p2 id = " + p2.getId());

        dao.deleteProduct(p2.getId());

        System.out.println("Program executed successfully");
    }
}