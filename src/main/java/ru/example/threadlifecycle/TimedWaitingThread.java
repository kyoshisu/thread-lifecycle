package ru.example.threadlifecycle;

public class TimedWaitingThread extends Thread {
    public TimedWaitingThread() {
        super("TimedWaitingThread");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}