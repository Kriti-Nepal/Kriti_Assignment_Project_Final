package org.example.models;

import java.util.Arrays;

public class Book {
    String name;
    int id;

    int price;
    String brand;

    String des;

    public Book(String name, int id, int price) {//constructor
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {//getter for item name
        return name;
    }

    public void setName(String name) {//setter for item name
        this.name = name;
    }

    public int getId() {//getter for product code
        return id;
    }

    public void code(int id) {//setter for product code
        this.id = id;
    }

    public int getPrice() {//getter for price
        return price;
    }

    public void setPrice(int price) {//setter for price
        this.price = price;
    }


    public void product_info(){//function to display item information
        String name = this.name;
        int id = this.id;
        int price = this.price;

        System.out.println("Item name:"+this.name);
        System.out.println("Price:"+this.price);
        System.out.println("Product_code:"+this.getId());
        System.out.println("\n\n");
    }
}