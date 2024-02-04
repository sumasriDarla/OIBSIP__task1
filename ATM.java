import java.util.Scanner;

public class ATM {
    private static final String PIN = "1234"; // Sample PIN
    private static double balance = 100000.0; // Initial balance in rupees

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        // Prompt for PIN
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        // Verify PIN
        if (verifyPin(enteredPin)) {
            // Display menu if PIN is correct
            displayMenu(scanner);
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }

    private static boolean verifyPin(String enteredPin) {
        return enteredPin.equals(PIN);
    }

    private static void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    depositMoney(scanner);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void checkBalance() {
        System.out.println("Balance: Rs. " + balance);
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: Rs. " + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds. Withdrawal failed.");
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: Rs. ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: Rs. " + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }
}
