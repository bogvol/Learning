package main.java.com.concurrency.learning;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private AtomicInteger failCounter = new AtomicInteger(0);
    private int balance;

    public Lock getLock() {
        return l;
    }

    Lock l = new ReentrantLock();

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void incFailedTransferCount() {
        failCounter.incrementAndGet();
}

    public AtomicInteger getFailCounter() {
        return failCounter;
    }
}
