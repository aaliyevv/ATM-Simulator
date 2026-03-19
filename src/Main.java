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

        for (BankAccount ba : accounts) {
            if (ba != null && ba.getAccountNumber().equals(enteredAccountNumber)) {
                currentAccount = ba;
                break;
            }
        }

        if (currentAccount == null) {
            System.out.println("There is no account with this number");
            scanner.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Add interest (only for Savings Account)");
            System.out.println("5. Show overdraft limit (only for Checking Account)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(currentAccount.displayBalance());
                    break;
                
}