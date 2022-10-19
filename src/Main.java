package src;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Bank GlobantBank = new Bank("Globant Bank");
        System.out.println("Welcome to " + GlobantBank.getName());
        Scanner myScanner = new Scanner(System.in);
        int bankAuth;
        do {
            System.out.println("Select your profile");
            System.out.println("    1. Administrator");
            System.out.println("    2. Client");
            System.out.println("    3. Exit");
            bankAuth = myScanner.nextInt();
            myScanner = new Scanner(System.in);
            if (bankAuth < 1 || bankAuth > 3 ) {
                System.out.println("Invalid option. Insert a number between 1 and 3\n");
            } else if (bankAuth >= 1 && bankAuth <= 3) {
                switch (bankAuth) {
                    case 1:
                        GlobantBank.bankUserLogin();
                        GlobantBank.clientInformation();
                        break;
                    case 2:
                        GlobantBank.clientUserLogin();
                        int option;
                        do {
                            System.out.println("Select your option");
                            System.out.println("    1. Check current balance");
                            System.out.println("    2. Deposit");
                            System.out.println("    3. Withdraw");
                            System.out.println("    4. Transfer");
                            System.out.println("    5. Exit");
                            option = myScanner.nextInt();
                            myScanner = new Scanner(System.in);
                            if (option < 1 || option > 5) {
                                System.out.println("Invalid option. Insert a number between 1 and 5\n");
                            } else if (option >= 1 && option <= 5) {
                                switch (option) {
                                    case 1:
                                        System.out.println("Your current balance is USD " + GlobantBank.Ana.anaAccount.getBalance() + ".\n");
                                        break;
                                    case 2:
                                        GlobantBank.userDeposit();
                                        break;
                                    case 3:
                                        GlobantBank.userWithdraw();
                                        break;
                                    case 4:
                                        GlobantBank.userTransfer();
                                        break;
                                    case 5:
                                        System.out.println("Have a great day!\n");
                                        break;
                                }
                            }
                        } while (option != 5);
                        break;
                    case 3:
                        System.out.println("Have a great day!\n");
                        break;
                }
            }
        } while (bankAuth != 3);
    }
}