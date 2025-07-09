package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> groceryInventory = new HashMap<>();

    public static void main(String[] args) {
        String opt;
        do {
            opt = displayMenu();
            switch (opt){
                case "1": // View Inventory
                    viewInventory(groceryInventory);
                    break;
                case "2": // Add Product
                    System.out.print("Enter product name: ");
                    String item = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    String qtyString = sc.nextLine();
                    int qty = Integer.parseInt(qtyString);
                    addProduct(item,qty);
                    break;
                case "3": // Check Product
                    System.out.print("Enter product name to check: ");
                    String newItem = sc.nextLine();
                    checkProduct(newItem);
                    break;
                case "4": // Update Product
                    System.out.print("Enter product name to update: ");
                    String itemToUpdate = sc.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    String newQtyString = sc.nextLine();
                    int newQty = Integer.parseInt(newQtyString);
                    updateProduct(itemToUpdate, newQty);
                    break;
                case "5": // Remove Product
                    System.out.print("Enter product name to remove: ");
                    String itemToRemove = sc.nextLine();
                    removeProduct(itemToRemove);
                    break;
                case "6": // Exit System
                    System.out.println("Exiting system . . .");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while (!opt.equals("6"));
    }

    // Display Menu
    static String displayMenu(){
        System.out.println("\n--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product ");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock ");
        System.out.println("5. Remove Product ");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        return sc.nextLine();
    }

    // View Inventory
    public static String viewInventory(HashMap<String, Integer> groceryInventory){
        System.out.println("\nCurrent Inventory:");
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No items to display.");
            return "Inventory is empty. No items to display.";
        }
        else {
            groceryInventory.forEach((key, value) ->
                    System.out.println(key + " - " + value + " pcs"));
            return "Inventory display.";
            }
    }

    // Add Product
    public static String addProduct(String item, int qty){
        if (groceryInventory.containsKey(item)){
            System.out.println("Product already exists. Overwriting . . .");
                groceryInventory.replace(item, qty);
                System.out.println("Product replaced.");
                return "Product replaced.";
        }
        else {
            if (qty <= 0){
                System.out.println("Quantity must be more than 0. Returning to menu . . .");
                return "Quantity must be more than 0.";
            }
            else {
                groceryInventory.put(item, qty);
                System.out.println("Product is added!");
                return "Product is added!";
            }
        }
    }

    // Check Product
    public static String checkProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");
            return "Inventory is empty. No stock to check.";
        }
        else {
            if (groceryInventory.containsKey(item)){
                Integer qty = groceryInventory.get(item);
                System.out.println(item + " is in stock: " + qty);
                return "Item is in stock.";
                }
            else {
                System.out.println("Product not found.");
                return "Product not found.";
            }
        }
    }

    // Update Product
    public static String updateProduct(String item, int qty){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");
            return "Inventory is empty. No stock to check.";
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.replace(item, qty);
                System.out.println("Product updated!");
                return "Product updated!";
            }
            else {
                System.out.println("Product not found.");
                return "Product not found.";
            }
        }
    }

    // Remove Product
    public static String removeProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");
            return "Inventory is empty. No stock to check.";
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.remove(item);
                System.out.println("Product removed.");
                return "Product removed.";
            }
            else {
                System.out.println("Product not found.");
                return "Product not found.";
            }
        }
    }

}