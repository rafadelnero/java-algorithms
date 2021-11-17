package com.algorithms.shortestpath;

import com.algorithms.Furniture;

import java.util.HashMap;

public class Test {
    HashMap<Furniture, Integer> furnitures;

    public float getTotalOrderCost() {
        float totalOrderCost = 0F;
        for (Furniture furnitureKey : furnitures.keySet()) {
            totalOrderCost += furnitureKey.cost() * furnitures.get(furnitureKey);
        }
        return totalOrderCost;
    }
}
