package com.pluralsigth.br.learning.collections.sets;

import com.pluralsigth.br.learning.collections.common.Supplier;
import com.pluralsigth.br.learning.collections.model.Product;

import java.util.*;

public class WeigthAwareProductCatalogue implements Iterable<Product> {
    private final NavigableSet<Product> products = new TreeSet<>(Product.BY_WEIGTH);

    public void addSupplier(final Supplier supplier){
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Set<Product> findLighterProducts(final Product product){
        return products.headSet(product, false);
    }
}
