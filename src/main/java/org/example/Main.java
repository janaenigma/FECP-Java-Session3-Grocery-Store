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
                case "1":
                    viewInventory(groceryInventory);
                    break;
                case "2":
                    System.out.print("Enter product name: ");
                    String item = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    String qtyString = sc.nextLine();
                    int qty = Integer.parseInt(qtyString);
                    addProduct(item,qty);
                    break;
                case "3":
                    System.out.print("Enter product name to check: ");
                    String newItem = sc.nextLine();
                    checkProduct(newItem);
                    break;
                case "4":
                    System.out.print("Enter product name to update: ");
                    String itemToUpdate = sc.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    String newQtyString = sc.nextLine();
                    int newQty = Integer.parseInt(newQtyString);
                    updateProduct(itemToUpdate, newQty);
                    break;
                case "5":
                    System.out.print("Enter product name to remove: ");
                    String itemToRemove = sc.nextLine();
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

    public static String viewInventory(HashMap<String, Integer> groceryInventory){
        System.out.println("\nCurrent Inventory:");
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No items to display.");
        }
        else {
            groceryInventory.forEach((key, value) ->
                    System.out.println(key + " - " + value + " pcs"));
            }
        return "View Inventory";
    }

    public static String addProduct(String item, int qty){
        groceryInventory.put(item, qty);
        System.out.println("Product is added!");

        return "Product is added!";
    }

    public static String checkProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");
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
            System.out.println("Inventory is empty. No stock to check.");
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.replace(item, qty);
                System.out.println("Product updated!");
            }
            else {
                System.out.println("Product not found.");
            }
        }
        return "Product updated!";
    }

    public static String removeProduct(String item){
        if (groceryInventory.isEmpty()){
            System.out.println("Inventory is empty. No stock to check.");
        }
        else {
            if (groceryInventory.containsKey(item)){
                groceryInventory.remove(item);
                System.out.println("Product removed.");
            }
            else {
                System.out.println("Product not found.");
            }
        }
        return "Product removed.";
    }
}