package com.pluralsigth.br.learning.collections;

import com.pluralsigth.br.learning.collections.model.Product;
import com.pluralsigth.br.learning.collections.model.Shipment;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Glass Window", 10);
    public static Product desk = new Product("Desk Gamer", 15);

    public static void main(String[] args) {
        System.out.printf("Starting learning about Collections: " + System.lineSeparator());

        //TODO MAP: Implementing
        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, door);
        idToProduct.put(2, floorPanel);
        idToProduct.put(3, desk);

        //TODO Methods with MAP
        Set<Integer> ids = idToProduct.keySet();
        ids.remove(3);
        ///ids.add(5);

        //TODO Implementing a Entry
//        Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
//        for (Map.Entry<Integer, Product> entry : entries){
//            System.out.println(entry);
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        //Product[] products = { door , floorPanel };

         Collection<Product> products= idToProduct.values();
         products.remove(floorPanel);

        //System.out.printf(Arrays.toString(products));

        //TODO ADD
//        products = add(desk, products);
//        System.out.printf(Arrays.toString(products));

        //TODO Duplicate
//        products = add(door, products);
//        System.out.printf(Arrays.toString(products));

          Collection<Product> productCollection = new ArrayList<>();
//          productCollection.add(door);
//          productCollection.add(floorPanel);
//          productCollection.add(desk);
//
//        Iterator<Product> iterator = productCollection.iterator();
//        while (iterator.hasNext()){
//            Product product = iterator.next();
//            if (product.getWeight() > 20){
//                iterator.remove();
//            }
//        }
        List<Product> productList = new ArrayList<>();
        productList.add(door);
        productList.add(floorPanel);
        productList.add(desk);

        implementingSteamsProducts(productList);
        implementingSteamsProductsWithCollections(productList);

        Shipment shipment = new Shipment();
        shipment.add(door);
        shipment.add(floorPanel);
        shipment.add(door);
        shipment.add(floorPanel);
        shipment.add(desk);

        shipment.prepare();

        List<Product> lightVanProducts = shipment.getLightVanProduts();
        lightVanProducts.remove(floorPanel);
        shipment.forEach(product -> System.out.println(product));

        //TODO Out results
        System.out.printf("Finishied learning about Collections: " + System.lineSeparator());
        System.out.printf("ligthVanProducts = " + lightVanProducts);
        System.out.printf("Shipment = " + shipment.getLightVanProduts());
//        System.out.printf(String.valueOf(ids) + System.lineSeparator());
//        System.out.printf(String.valueOf(idToProduct) + System.lineSeparator());
//        System.out.printf(String.valueOf(productCollection.size()) + System.lineSeparator());
//        System.out.printf(String.valueOf(productCollection.isEmpty()) + System.lineSeparator());

//        System.out.printf(String.valueOf(productCollection.contains(desk)) + System.lineSeparator());
//        System.out.printf(String.valueOf(productCollection.remove(door)) + System.lineSeparator());
//        System.out.printf(String.valueOf(productCollection.contains(door)) + System.lineSeparator());
    }

    private static void implementingSteamsProducts(final List<Product> productList) {
        productList
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .map(Product:: getName)
                .forEach(System.out::println);
    }

    private static void implementingSteamsProductsWithCollections(final List<Product> productList) {
        productList
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .collect(Collectors.toList())
                //TODO groupingBy
                //.collect(Collectors.groupingBy(Product::getName))
                .forEach(System.out::println);
    }

    private static Product[] add(Product product, Product[] array){
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
