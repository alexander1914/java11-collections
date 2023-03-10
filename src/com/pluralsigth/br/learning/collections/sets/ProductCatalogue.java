package com.pluralsigth.br.learning.collections.sets;

import com.pluralsigth.br.learning.collections.common.Supplier;
import com.pluralsigth.br.learning.collections.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCatalogue implements Iterable<Product> {

    private final List<Product> products = new ArrayList<>();

    public void addSuplier(final Supplier supplier) {
        //TODO First solution
        //products.addAll(supplier.getProducts());

        List<Product> supplierProducts = supplier.getProducts();
        supplierProducts.forEach(
                product -> {
                    if (!products.contains(product)) {
                        products.add(product);
                    }
                }
        );
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
