import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[10];
        accounts[0] = new BankAccount("4098", 2400);
        accounts[1] = new CheckingAccount("5844", 4600, 700);
        accounts[2] = new SavingsAccount("6020", 1200, 0.13);

        System.out.println("Welcome");
        System.out.println("Please enter account number:");
        String enteredAccountNumber = scanner.nextLine();
        IBankAccount currentAccount = null;

        