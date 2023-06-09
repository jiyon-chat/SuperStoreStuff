//this is what I was going for but failed and I'm too confused

import java.util.ArrayList;
import java.util.Scanner;

public class StoreGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = 50; // Starting money
        
        // Create the available products as Product objects
        Product singlePayer = new Product("Single-Payer Healthcare", 20);
        Product freeCollege = new EducationProduct("Free Public College", 1, "Bachelor's Degree");
        Product basicIncome = new Product("Universal Basic Income", 30);
        Product childCare = new ChildCareProduct("Universal Childcare", 2, 3);
        Product none = new Product("None", 0);
        
        // Add the available products to a list
        ArrayList<Product> productsAvailable = new ArrayList<Product>();
        productsAvailable.add(singlePayer);
        productsAvailable.add(freeCollege);
        productsAvailable.add(basicIncome);
        productsAvailable.add(childCare);
        productsAvailable.add(none);
        
        // Create a list to store the bought products
        ArrayList<Product> productsBought = new ArrayList<Product>();
        
        // Create the available government agencies as Product objects
        GovernmentAgency pentagonBudget = new GovernmentAgency("Pentagon Budget", 8, 8);
        GovernmentAgency medicareBudget = new GovernmentAgency("Medicare Budget", 7, 7);
        GovernmentAgency socialSecurity = new GovernmentAgency("Social Security", 10, 10);
        
        // Add the available government agencies to a list
        ArrayList<GovernmentAgency> agenciesAvailable = new ArrayList<GovernmentAgency>();
        agenciesAvailable.add(pentagonBudget);
        agenciesAvailable.add(medicareBudget);
        agenciesAvailable.add(socialSecurity);
        
        System.out.println("Welcome to the government spending game!");
        System.out.println("You have $" + money + " trillion to spend.");
        
        while (money > 0) {
            // Print the available products and their costs
            System.out.println("Universal Products:");
            int i = 1;
            for (Product product : productsAvailable) {
                System.out.println(i + ". " + product.getName() + " - $" + product.getPrice() + " trillion");
                i++;
            }
            
            // Print the available government agencies and their costs
            System.out.println("\nGovernment Agencies:");
            i = 1;
            for (GovernmentAgency agency : agenciesAvailable) {
                System.out.println(i + ". " + agency.getName() + " - $" + agency.getCost() + " trillion");
                i++;
            }
            
            // Ask the user to choose a universal public product or government agency
            System.out.print("\nWhich product or agency would you like to implement? (Enter a number or 0 to quit): ");
            int choice = input.nextInt();
            
            if (choice == 0) {
                // Quit the game if the user chooses 0
                System.out.println("Thanks for playing!");
                break;
            } else if (choice < 1 || choice > productsAvailable.size() + agenciesAvailable.size()) {
                // Invalid input
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            class GovernmentAgency extends Product {
                private int initialCost;
                private int currentCost;
                
                public GovernmentAgency(String name, int initialCost) {
                    super(name, initialCost);
                    this.initialCost = initialCost;
                    this.currentCost = initialCost;
                }
                
                public void updateCost(ArrayList<Product> productsBought) {
                    for (Product product : productsBought) {
                        if (product.getName().equals("Single-Payer Healthcare") && this.getName().equals("Medicare Budget")) {
                            this.currentCost = 0;
                            break;
                        } else if (product.getName().equals("Universal Basic Income") && this.getName().equals("Social Security")) {
                            this.currentCost = 0;
                            break;
                        } else if (product.getName().equals("Free Public College") && this.getName().equals("Pentagon Budget")) {
                            this.currentCost -= 1;
                            break;
                        } else if (product.getName().equals("Single-Payer Healthcare") && this.getName().equals("Social Security")) {
                            this.currentCost += 1;
                            break;
                        }
                    }
                }
                
                public int getInitialCost() {
                    return this.initialCost;
                }
                
                public int getCurrentCost() {
                    return this.currentCost;
                }
            }
            
            class BudgetStuff extends Product {
                private String effect;
                private int amount;
                
                public BudgetStuff(String name, int price, String effect, int amount) {
                    super(name, price);
                    this.effect = effect;
                    this.amount = amount;
                }
                
                public String getEffect() {
                    return this.effect;
                }
                
                public int getAmount() {
                    return this.amount;
                }
            }
            
            // Create the available products as Product objects
            Product raiseTaxes = new BudgetStuff("Raise Taxes", 2, "taxes", 2);
            Product addDebt = new BudgetStuff("Add to National Debt", -2, "debt", -2);
            Product cutMilitaryBudget = new BudgetStuff("Cut the Military Budget", 1, "military budget", 1);
            
            // Add the available products to a list
            ArrayList<Product> productsAvailablenow = new ArrayList<Product>();
            productsAvailable.add(singlePayer);
            productsAvailable.add(freeCollege);
            productsAvailable.add(basicIncome);
            productsAvailable.add(childCare);
            productsAvailable.add(pentagonBudget);
            productsAvailable.add(medicareBudget);
            productsAvailable.add(socialSecurity);
            productsAvailable.add(raiseTaxes);
            productsAvailable.add(addDebt);
            productsAvailable.add(cutMilitaryBudget);

            
            // Create a list to store the bought products
            ArrayList<Product> productsBoughtnow = new ArrayList<Product>();
            
            System.out.println("Welcome to the government spending game!");
            System.out.println("You have $" + money + " trillion to spend.");
            
            while (money > 0) {
                // Print the available products and their costs
                System.out.println("Products Available:");
                int i = 1;
                for (Product product : productsAvailable) {
                    System.out.print(i + ". " + product.getName() + " - $" + product.getPrice() + " trillion");
                }}}

  class Product {
                    private String name;
                    private int price;
                    
                    public Product(String name, int price) {
                        this.name = name;
                        this.price = price;
                    }}}}
    
