package com.pluralsigth.br.learning.collections.model;

import java.util.Comparator;

public class Product {

    private final String name;
    private final int weight;

    public Product (String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return  "Product{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        '}';
    }

    public static final Comparator<Product> BY_WEIGTH = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    };
}
