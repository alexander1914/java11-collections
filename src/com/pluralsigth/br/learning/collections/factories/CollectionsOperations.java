package com.pluralsigth.br.learning.collections.factories;

import com.pluralsigth.br.learning.collections.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsOperations {
    public static Product door = new Product("Wooden Door", 45);
    public static Product floorPanel = new Product("Glass Window", 10);
    public static Product desk = new Product("Desk Gamer", 15);
    public static void main(String[] args) {

        var produts = List.of(door, floorPanel, desk);

        Product ligthtestProduct = Collections.min(produts, Product.BY_WEIGTH);
        Product heavyProduct = Collections.max(produts, Product.BY_WEIGTH);

        var produts2 = new ArrayList<Product>();
        Collections.addAll(produts2, door, floorPanel, desk);
        Collections.shuffle(produts2);

        System.out.println("ligthtestProduct = " + ligthtestProduct);
        System.out.println("heavyProduct = " + heavyProduct);
        System.out.println(produts2);
        System.out.println("produts = " + produts2);
    }
}
