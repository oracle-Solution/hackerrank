package airtelxlabs;

import java.util.List;

import java.util.*;
/*
 * Create the Account and Transaction classes here.
 */
public class Q2 {

}

class Transaction {
    Account account;
    List<String> transactions = new ArrayList<>();

    public Transaction(Account account){
        this.account = account;
    }

    public synchronized void deposit(int money) {
        String deposit = account.deposit(money);
        transactions.add(deposit);
    }

    public synchronized void withdraw(int money) {
        String withdraw = account.withdraw(money);
        transactions.add(withdraw);
    }

    public synchronized List<String> getTransaction() {
        return this.transactions;
    }
}

class Account {
    private int balance = 0;
    public static final String INSUFFICIENT_BALANCE_STRING = " (Insufficient Balance)";
    public static final String DEPOSITING_STRING = "Depositing $";
    public static final String WITHDRAW_STRING = "Withdrawing $";

    public synchronized String deposit(int money) {
        balance += money;
        return "Depositing $" + money;
    }

    public synchronized String withdraw(int money) {
        if(money > balance)
            return "Withdrawing $" + money + INSUFFICIENT_BALANCE_STRING;
        else
            balance -= money;
        return "Withdrawing $" + money;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class TransactionRunnable implements Runnable {