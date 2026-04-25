class LessBalanceException extends Exception {
    LessBalanceException(String msg) {
        super(msg);
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) throws LessBalanceException {
        if (balance - amount < 1000) {
            throw new LessBalanceException(
                "Withdraw amount (" + amount + ") is not valid. Insufficient balance."
            );
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(5000);

        try {
            acc.deposit(2000);
            acc.withdraw(5500);
            acc.showBalance();
        } catch (LessBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e);
        }
    }
}
