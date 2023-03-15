import java.util.Scanner;

public class SuperStoreGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = 50; // Starting money
        int[] prices = {20, 1, 30, 2, 0}; // Prices of the universal programs
        String[] universal = {"Single-Payer Healthcare", "Free Public College", "Universal Basic Income", "Universal Childcare", "None"}; // Names of the programs
        String[] programsBought = new String[5]; // To store the bought programs
        
        System.out.println("Welcome to the government spending game!");
        System.out.println("You have $" + money + " trillion to spend.");
        
        while (money > 0) {
            // Print the available programs and their costs
            System.out.println("Universal Programs:");
            for (int i = 0; i < universal.length; i++) {
                System.out.println(i + 1 + ". " + universal[i] + " - $" + prices[i] + " trillion");
            }
            
            // Ask the user to choose a universal public program
            System.out.print("\nWhich program would you like to implement? (Enter a number or 0 to quit): ");
            int choice = input.nextInt();
            
            if (choice == 0) {
                // Quit the game if the user chooses 0
                System.out.println("Thanks for playing!");
                break;
            } else if (choice < 1 || choice > universal.length) {
                // Invalid input
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            int price = prices[choice - 1];
            
            if (price > money) {
                // The user can't afford the program
                System.out.println("You don't have enough money to buy this program. Please choose another program.");
            } else {
                // The user can afford the program
                money -= price;
                programsBought[choice-1] = universal[choice-1]; // Store the bought program
                System.out.println("Congratulations! You implemented " + universal[choice - 1] + " for $" + price + " trillion.");
                System.out.println("You have $" + money + " trillion left.");
            }
        }
        
        System.out.println("\nYou have bought the following programs:"); // Print the bought programs
        for (String program : programsBought) {
            if (program != null) {
                System.out.println("- " + program);
            }
        }
    }
}
