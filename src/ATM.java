// File: ATM.java
import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    public ATM(int pin) {
        this.pin = pin;
        this.balance = 0.0;
    }

    // login method
    public boolean login(int enteredPin) {
        return this.pin == enteredPin;
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: Rs." + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // check balance
    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1234); // default PIN

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.login(enteredPin)) {
            System.out.println("Incorrect PIN. Access Denied!");
            return;
        }

        System.out.println("\nLogin Successful!\n");

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    atm.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    atm.withdraw(wit);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option! Try again.");
            }
        }
    }
}