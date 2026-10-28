package ru.example.threadlifecycle;

public class WaitingThread extends Thread {
    public WaitingThread() {
        super("WaitingThread");
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}