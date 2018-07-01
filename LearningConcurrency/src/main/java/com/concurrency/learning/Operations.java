package main.java.com.concurrency.learning;

import java.util.concurrent.TimeUnit;

public class Operations {
    private static final long WAIT_SEC = 10;

    public static void main(String[] args) throws InsufficientFundsException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        transfer(b, a, 300);
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException {
        if (acc1.getBalance() < amount) throw new InsufficientFundsException();

//        synchronized (acc1) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Locked acc1");
//            synchronized (acc2) {
//                System.out.println("Locked acc2");
//                acc1.withdraw(amount);
//                acc2.deposit(amount);
//            }

        try {
            if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                try {
                    if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                        try {
                            acc1.withdraw(amount);
                            acc2.deposit(amount);
                        } finally {
                        }
                    }
                } finally {
                    acc1.getLock().unlock();
                }
            } else {
                System.out.println("Error waiting lock");
                acc1.incFailedTransferCount();
                acc2.incFailedTransferCount();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
