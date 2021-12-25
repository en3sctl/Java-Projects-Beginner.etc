import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {

        BankAccount object1 = new BankAccount("Enes Catal", "BA0001");
        object1.showMenu();
    }
}

class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    void deposit(int amount) {

        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {

        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    void showMenu() {

        char option = '\0';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID Is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {

            System.out.println("====================================================");
            System.out.println("Enter An Option");
            System.out.println("====================================================");
            option = scan.next().charAt(0);
            System.out.println("\n");

            switch (option) {

                case 'A':
                    System.out.println("===============================");
                    System.out.println("Balance = " + balance);
                    System.out.println("===============================");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("===============================");
                    System.out.println("Enter An Amount To Deposit: ");
                    System.out.println("===============================");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("===============================");
                    System.out.println("Enter An Amount To Withdraw: ");
                    System.out.println("===============================");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("===============================");
                    break;

                default:
                    System.out.println("Invalid Option !! Please Enter Again");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank You For Using Our Services");
    }
}






