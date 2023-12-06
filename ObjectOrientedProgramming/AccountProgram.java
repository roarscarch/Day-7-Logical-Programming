package ObjectOrientedProgramming;
class Account {
    private String accountName;
    private double balance;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credited $" + amount + " to account " + accountName);
        } else {
            System.out.println("Error: Credit amount must be greater than 0.");
        }
    }

    public void debit(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Debited $" + amount + " from account " + accountName);
            } else {
                System.out.println("Debit amount exceeded account balance. Transaction cancelled.");
            }
        } else {
            System.out.println("Error: Debit amount must be greater than 0.");
        }
    }
}


public class AccountProgram {
    public static void main(String[] args) {
        // Test the modified Account class with debit method
        Account account1 = new Account("John's Account", 1000.0);

        System.out.println("Initial Balance for " + account1.getAccountName() + ": $" + account1.getBalance());

        // Test debit with valid amount
        account1.debit(200.0);
        System.out.println("New Balance: $" + account1.getBalance());

        // Test debit with invalid amount
        account1.debit(1200.0);
        System.out.println("Balance after invalid debit: $" + account1.getBalance());
    }
}
