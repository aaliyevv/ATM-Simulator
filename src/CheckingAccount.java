public class CheckingAccount extends BankAccount {
    public double overdraftLimit; // maximum withdrawable amount

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Amount must be greater than zero";
        }

        if (amount > overdraftLimit) {
            return "Cannot withdraw: exceeds overdraft limit of " + overdraftLimit;
        }

        if (amount > getCurrentBalance()) {
            return "Cannot withdraw: insufficient balance";
        }

        // Proceed with withdrawal
        setBalance(getCurrentBalance() - amount);
        return "Withdrawal successful. Current balance: " + getCurrentBalance();
    }
}