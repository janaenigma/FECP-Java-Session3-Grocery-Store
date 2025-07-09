package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static HashMap<String, Integer> groceryInventory;

    @BeforeEach
    void setup(){
        groceryInventory = new HashMap<>();
    }

    // Add Product Test Cases
    @Test
    void shouldAddProduct(){
        String result = Main.addProduct("Banana", 30);
        assertEquals("Product is added!", result);
    }

    @Test
    void shouldOverwriteExistingProduct(){
        Main.addProduct("Milk", 20);
        String result = Main.addProduct("Milk", 50);
        assertEquals("Product replaced.", result);
    }

    @Test
    void shouldNotAddProductIfQuantityIsZero(){
        String result = Main.addProduct("Mango", 0);
        assertEquals("Quantity must be more than 0.", result);
    }

    // Check Product Test Cases
    @Test
    void shouldCheckExistingProduct(){
        String result = Main.checkProduct("Milk");
        assertEquals("Item is in stock.", result);
    }

    @Test
    void shouldNotCheckProductIfNonExistent(){
        Main.addProduct("Milk", 20);
        String result = Main.checkProduct("Ice Cream");
        assertEquals("Product not found.", result);
    }

    // Update Product Test Cases
    @Test
    void shouldUpdateProductWithValidQuantity(){
        Main.addProduct("Bread", 30);
        String result = Main.updateProduct("Bread", 25);
        assertEquals("Product updated!", result);
    }

    @Test
    void shouldNotUpdateProductIfNonExistent(){
        String result = Main.updateProduct("Tofu", 50);
        assertEquals("Product not found.", result);
    }

    // Remove Product Test Cases
    @Test
    void shouldRemoveProductWithValidQuantity(){
        Main.addProduct("Eggs", 30);
        String result = Main.removeProduct("Eggs");
        assertEquals("Product removed.", result);
    }

    @Test
    void shouldNotRemoveProductIfNonExistent(){
        Main.addProduct("Chicken", 80);
        String result = Main.removeProduct("Pizza");
        assertEquals("Product not found.", result);
    }

}