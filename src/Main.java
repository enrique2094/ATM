import java.util.Scanner;

class ATM {
    private static double balance = 1000; // Initial account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu options
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> {
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                }
                case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to check account balance
    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    // Method to deposit money into the account
    private static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    // Method to withdraw money from the account
    private static void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal of $" + amount + " successful. New balance is: $" + balance);
            } else {
                System.out.println("Insufficient balance. Please try again.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }
}
