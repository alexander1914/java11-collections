package com.pluralsigth.br.learning.collections.common;

import com.pluralsigth.br.learning.collections.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private final String name;
    private final List<Product> products = new ArrayList<>();

    public Supplier(String name){
        this.name = name;
    }

    public List<Product> getProducts(){
        return products;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
