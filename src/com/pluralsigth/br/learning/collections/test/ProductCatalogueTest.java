package com.pluralsigth.br.learning.collections.test;

import com.pluralsigth.br.learning.collections.common.Supplier;
import com.pluralsigth.br.learning.collections.model.Product;
import com.pluralsigth.br.learning.collections.sets.ProductCatalogue;
import com.pluralsigth.br.learning.collections.sets.WeigthAwareProductCatalogue;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductCatalogueTest {
    private static Product door = new Product("Wooden Door", 35);
    private static Product floorPanel = new Product("Floor Panel", 25);
    private static Product window = new Product("Glass Window", 10);

    @Test
    public void shouldNotRecordDuplicateProducts(){
        //Cenário
        Supplier alexanderOliveira = new Supplier("Alexander Oliveira");
        alexanderOliveira.getProducts().add(floorPanel);

        Supplier allPurpose = new Supplier("All Purppse Supplies Ltd.");
        Collections.addAll(allPurpose.getProducts(), door, floorPanel, window);

        ProductCatalogue catalogue = new ProductCatalogue();
        catalogue.addSuplier(alexanderOliveira);
        catalogue.addSuplier(allPurpose);

        //Validação
        assertThat(catalogue, hasItems(door, floorPanel, window));
    }

    @Test
    public void shouldFindLighterProducts(){
        //Cenário
        Supplier alexanderOliveira = new Supplier("Alexander Oliveira");
        alexanderOliveira.getProducts().add(floorPanel);

        Supplier allPurpose = new Supplier("All Purppse Supplies Ltd.");
        Collections.addAll(allPurpose.getProducts(), door, floorPanel, window);

        WeigthAwareProductCatalogue catalogue = new WeigthAwareProductCatalogue();
        catalogue.addSupplier(alexanderOliveira);
        catalogue.addSupplier(allPurpose);

        Set<Product> lighterProducts = catalogue.findLighterProducts(door);

        //Validação
        assertThat(lighterProducts, hasItems(window, floorPanel));
    }
}
