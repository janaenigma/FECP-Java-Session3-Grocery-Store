package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> groceryInventory = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String opt;
        do {
            opt = displayMenu();
            switch (opt){
                case "1":
                    viewInventory(groceryInventory);
                    break;
                case "2":
                    System.out.print("Enter product name: ");
                    String newItem = sc.next();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    addProduct(newItem,qty);
                    break;
                case "3":
                    System.out.print("Enter product name to check: ");
                    String itemToCheck = sc.next();
                    checkProduct(itemToCheck);
                    break;
                case "4":
                    System.out.print("Enter product name to update: ");
                    String itemToUpdate = sc.next();
                    System.out.print("Enter new stock quantity: ");
                    int newQty = sc.nextInt();
                    updateProduct(itemToUpdate, newQty);
                    break;
                case "5":
                    System.out.print("Enter product name to remove: ");
                    String itemToRemove = sc.next();
                    removeProduct(itemToRemove);
                    break;
                case "6":
                    System.out.println("Exiting system . . .");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while (!opt.equals("6"));
    }

    static String displayMenu(){
        System.out.println("\n--- Grocery Inventory Menu ---\n" +
                "1. View Inventory \n" +
                "2. Add Product \n" +
                "3. Check Product \n" +
                "4. Update Stock \n" +
                "5. Remove Product \n" +
                "6. Exit");
        System.out.print("Choose an option: ");
        return sc.next();
    }

    public static String viewInventory(HashMap<String, Integer> groceryInventory){
        System.out.println("\nCurrent Inventory:");
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No items to display.");
        }
        else {
            for (Map.Entry<String, Integer> entry : groceryInventory.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " pcs");
            }
        }
        return "Current Inventory";
    }

    public static String addProduct(String item, int qty){
        groceryInventory.put(item, qty);
        System.out.println("Product is added!");

        return "Product is added!";
    }

    public static String checkProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");;
        }
        else {
            if (groceryInventory.containsKey(item)){
                Integer qty = groceryInventory.get(item);
                System.out.println(item + " is in stock: " + qty);
                }
            else {
                System.out.println("Item is not in stock.");
            }
        }
        return "Item is in stock.";
    }

    public static String updateProduct(String item, int qty){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");;
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.put(item, qty);
                System.out.println("Product updated!");
            }
            else {
                System.out.println("Item is not in stock.");
            }
        }
        return "Product updated!";
    }

    public static String removeProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");;
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.remove(item);
                System.out.println("Product removed.");
            }
            else {
                System.out.println("Item is not in stock.");
            }
        }
        return "Product removed.";
    }
}