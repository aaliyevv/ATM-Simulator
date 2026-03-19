public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public String addInterest() {
        double interest = getCurrentBalance() * interestRate;
        super.deposit(interest);
        return "Interest added. Current balance: " + getCurrentBalance();
    }
}