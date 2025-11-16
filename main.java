import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    float balance;

    public Account(int accountNumber, String name, float balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}

public class BankManagementSystem {

    private static final int MAX_ACCOUNTS = 100;
    private static Account[] accounts = new Account[MAX_ACCOUNTS];
    private static int numAccounts = 0;
    private static Scanner scanner = new Scanner(System.in);

    // Function to create a new account
    public static void createAccount() {
        if (numAccounts >= MAX_ACCOUNTS) {
            System.out.println("Cannot create more accounts. Limit reached.");
            return;
        }

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter name: ");
        String name = scanner.next();  // reads single word like scanf("%s")

        System.out.print("Enter initial balance: ");
        float balance = scanner.nextFloat();

        accounts[numAccounts] = new Account(accountNumber, name, balance);
        numAccounts++;

        System.out.println("Account created successfully.");
    }

    // Function to deposit money
    public static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter amount to deposit: ");
        float amount = scanner.nextFloat();

        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                accounts[i].balance += amount;
                System.out.printf("Deposit successful. New balance: %.2f\n", accounts[i].balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Function to withdraw money
    public static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();

        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                if (accounts[i].balance >= amount) {
                    accounts[i].balance -= amount;
                    System.out.printf("Withdrawal successful. New balance: %.2f\n", accounts[i].balance);
                } else {
                    System.out.println("Insufficient balance.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Function to check balance
    public static void checkBalance() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                System.out.printf("Account balance: %.2f\n", accounts[i].balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Function to display all account details
    public static void displayAll() {
        if (numAccounts == 0) {
            System.out.println("No accounts to display.");
            return;
        }
        for (int i = 0; i < numAccounts; i++) {
            System.out.printf("Account number: %d, Name: %s, Balance: %.2f\n",
                    accounts[i].accountNumber, accounts[i].name, accounts[i].balance);
        }
    }

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
