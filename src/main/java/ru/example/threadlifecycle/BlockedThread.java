package ru.example.threadlifecycle;

public class BlockedThread extends Thread {
    private final Object lock;

    public BlockedThread(Object lock) {
        super("BlockedThread");
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}