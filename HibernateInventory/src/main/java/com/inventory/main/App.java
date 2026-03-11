package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class App {

   
    public static void main(String[] args) {

    	    ProductDAO dao = new ProductDAO();

    	    Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
    	    Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);

    	    dao.saveProduct(p1);
    	    dao.saveProduct(p2);
    	    System.out.println("Program executed successfully");

    	    System.out.println("p2 id = " + p2.getId());
    	   
    	    System.out.println("Program executed successfully");
    	    dao.deleteProduct(p2.getId());

    	    System.out.println("Program executed successfully");
    	}
}