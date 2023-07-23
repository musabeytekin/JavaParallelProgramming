public class LivelockExample {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock1) {
                        System.out.println("Thread 1: Holding lock1...");
                        try {
                            Thread.sleep(100); // Küçük bir bekleme süresi ekleyelim.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread 1: Waiting for lock2...");
                        synchronized (lock2) {
                            System.out.println("Thread 1: Acquired lock2!");
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock2) {
                        System.out.println("Thread 2: Holding lock2...");
                        try {
                            Thread.sleep(100); // Küçük bir bekleme süresi ekleyelim.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread 2: Waiting for lock1...");
                        synchronized (lock1) {
                            System.out.println("Thread 2: Acquired lock1!");
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
