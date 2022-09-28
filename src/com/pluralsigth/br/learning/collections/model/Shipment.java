package com.pluralsigth.br.learning.collections.model;

import java.util.*;

public class Shipment implements Iterable<Product> {

    private static final int LIGTH_VAN_MAX_WEIGTH = 20;
    private static final int MISSING_PRODUCT = -1;

    private final List<Product> products = new ArrayList<>();
    private List<Product> ligthVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product) {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        int position = products.indexOf(oldProduct);
        if (position == MISSING_PRODUCT) {
            return false;
        } else {
            products.set(position, newProduct);
            return true;
        }
    }

    public void prepare() {
        products.sort(Product.BY_WEIGTH);

        int splitPont = findSplitPoint();

        ligthVanProducts = products.subList(0, splitPont);
        heavyVanProducts = products.subList(splitPont, products.size());
    }

    private int findSplitPoint() {
        int size = products.size();
        for (int i = 0; i < size; i++) {
            Product product = products.get(i);
            if (product.getWeight() > LIGTH_VAN_MAX_WEIGTH) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getHeavyVanProduts() {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProduts() {
        return ligthVanProducts;
    }


    public Iterator<Product> iterator() {
        return products.iterator();
    }

    private class BY_WEIGTH {
    }
}
