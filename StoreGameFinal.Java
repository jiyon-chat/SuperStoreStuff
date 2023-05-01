//this kinda works but isn't close to what I wanted compared to the other one
import java.util.ArrayList;
import java.util.Scanner;

public class StoreGameFinal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = 50; // Starting money
        
        // Create the available programs as Product objects
        Product singlePayer = new Product("Single-Payer Healthcare", 20);
        Product freeCollege = new Product("Free Public College", 1);
        Product basicIncome = new Product("Universal Basic Income", 30);
        Product childCare = new Product("Universal Childcare", 2);
        Product none = new Product("None", 0);
        
        // Add the available programs to a list
        ArrayList<Product> programsAvailable = new ArrayList<Product>();
        programsAvailable.add(singlePayer);
        programsAvailable.add(freeCollege);
        programsAvailable.add(basicIncome);
        programsAvailable.add(childCare);
        programsAvailable.add(none);
        
        // Create a list to store the bought programs
        ArrayList<Product> programsBought = new ArrayList<Product>();
        
        System.out.println("Welcome to the government spending game!");
        System.out.println("You have $" + money + " trillion to spend.");
        
        while (money > 0) {
            // Print the available programs and their costs
            System.out.println("Universal Programs:");
            int i = 1;
            for (Product program : programsAvailable) {
                System.out.println(i + ". " + program.getName() + " - $" + program.getPrice() + " trillion");
                i++;
            }
            
            // Ask the user to choose a universal public program
            System.out.print("\nWhich program would you like to implement? (Enter a number or 0 to quit): ");
            int choice = input.nextInt();
            
            if (choice == 0) {
                // Quit the game if the user chooses 0
                System.out.println("Thanks for playing!");
                break;
            } else if (choice < 1 || choice > programsAvailable.size()) {
                // Invalid input
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            Product selectedProgram = programsAvailable.get(choice - 1);
            
            if (selectedProgram.getPrice() > money) {
                // The user can't afford the program
                System.out.println("You don't have enough money to buy this program. Please choose another program.");
            } else {
                // The user can afford the program
                money -= selectedProgram.getPrice();
                programsBought.add(selectedProgram); // Store the bought program
                System.out.println("Congratulations! You implemented " + selectedProgram.getName() + " for $" + selectedProgram.getPrice() + " trillion.");
                System.out.println("You have $" + money + " trillion left.");
            }
        }
        
        System.out.println("\nYou have bought the following programs:"); // Print the bought programs
        for (Product program : programsBought) {
            System.out.println("- " + program.getName());
        }
    }
}

class Product {
    private String name;
    private int price;
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPrice() {
        return this.price;
    }
}
