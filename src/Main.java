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
                case 2:
                    System.out.print("Enter the amount to be withdrawn: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(currentAccount.withdraw(withdrawAmount));
                    break;
                case 3:
                    System.out.print("Enter the amount to be deposited: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(currentAccount.deposit(depositAmount));
                    break;
                case 4:
                    if (currentAccount instanceof SavingsAccount) {
                        SavingsAccount sa = (SavingsAccount) currentAccount;
                        System.out.println(sa.addInterest());
                    } else {
                        System.out.println("This operation is only available for Savings Accounts.");
                    }
                    break;
                case 5:
                    if (currentAccount instanceof CheckingAccount) {
                        CheckingAccount ca = (CheckingAccount) currentAccount;
                        System.out.println("Your overdraft limit is: " + ca.overdraftLimit);
                    } else {
                        System.out.println("This operation is only available for Checking Accounts.");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection, try again");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}