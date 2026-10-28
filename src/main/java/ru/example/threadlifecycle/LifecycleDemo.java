package ru.example.threadlifecycle;

public class LifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Демонстрация жизненного цикла потоков");

        Object lock = new Object();

        TimedWaitingThread timedWaiting = new TimedWaitingThread();
        WaitingThread waiting = new WaitingThread();
        BlockedThread blocked = new BlockedThread(lock);

        synchronized (lock) {

            System.out.println("\n[Состояние ДО запуска]");
            System.out.println("TimedWaitingThread: " + timedWaiting.getState());
            System.out.println("WaitingThread:      " + waiting.getState());
            System.out.println("BlockedThread:      " + blocked.getState());

            timedWaiting.start();
            waiting.start();
            blocked.start();

            System.out.println("\n[Наблюдение за состояниями (каждые 500 мс)]");
            for (int i = 1; i <= 4; i++) {
                Thread.sleep(500);

                System.out.printf("Секунда %d: %s | %s | %s%n",
                        i,
                        timedWaiting.getState(),
                        waiting.getState(),
                        blocked.getState()
                );
            }
        }

        timedWaiting.join();
        waiting.join();
        blocked.join();

        System.out.println("\n[Состояние ПОСЛЕ завершения]");
        System.out.println("TimedWaitingThread: " + timedWaiting.getState());
        System.out.println("WaitingThread:      " + waiting.getState());
        System.out.println("BlockedThread:      " + blocked.getState());
        System.out.println("Демонстрация завершена");
    }
}