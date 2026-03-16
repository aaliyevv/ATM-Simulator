public class BankAccount implements IBankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String withdraw(double amount) {

        if (amount <= 0) {
            return "Amount must be greater than zero";
        }
        if (balance >= amount) {
            balance -= amount;
            return "Withdrawal successful. Current balance: " + balance;
        } else {
            return "Not enough balance";
        }
    }

    @Override
    public String deposit(double amount) {
        if (amount <= 0) {
            return "Deposit amount must be positive";
        }
        balance += amount;
        return "Deposit successful. Current balance: " + balance;
    }

    @Override
    public String displayBalance() {
        return "Current balance: " + balance;
    }
}