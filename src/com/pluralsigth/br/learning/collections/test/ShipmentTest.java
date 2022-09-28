package com.pluralsigth.br.learning.collections.test;

import com.pluralsigth.br.learning.collections.model.Product;
import com.pluralsigth.br.learning.collections.model.Shipment;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ShipmentTest {
    Product door = new Product("Wooden Door", 35);
    Product floorPanel = new Product("Glass Window", 10);
    Product desk = new Product("Desk Gamer", 15);

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems(){
        shipment.add(door);
        shipment.add(floorPanel);

        assertNotNull(shipment);
    }

    @Test
    public void shouldReplaceItems(){
        shipment.add(door);
        shipment.add(floorPanel);

        assertTrue(shipment.replace(door, floorPanel));
    }

    @Test
    public void shouldNotReplaceItems(){
        shipment.add(desk);

        assertFalse(shipment.replace(door, floorPanel));
    }

    @Test
    public void shouldIdentifyVanRequirements(){
        shipment.add(door);
        shipment.add(floorPanel);
        shipment.add(desk);

        shipment.prepare();

        assertNotNull(shipment.getHeavyVanProduts());
        assertNotNull(shipment.getLightVanProduts());
    }
}
