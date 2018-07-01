package main.java.com.concurrency.learning;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
    private Account accountFrom;
    private Account accountTo;
    private int amount;
    private static final long WAIT_SEC = 3;

    public Transfer(Account accountFrom, Account accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }


    @Override
    public Boolean call() throws Exception {
        if (accountFrom.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (accountFrom.getBalance() < amount) throw new InsufficientFundsException();
                if (accountTo.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        accountFrom.withdraw(amount);
                        accountTo.deposit(amount);
                        Thread.sleep(10000);
                        return true;
                    } finally {

                    }
                }
            } finally {
                accountFrom.getLock().unlock();
            }
        } else {
            System.out.println("Error waiting lock");
            accountFrom.incFailedTransferCount();
            accountTo.incFailedTransferCount();
            return false;
        }
        return false;
    }
}