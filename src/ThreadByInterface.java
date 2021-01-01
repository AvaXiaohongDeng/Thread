class InterfaceThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread"+Thread.currentThread().getId() + " " +
                    "run " + i);
        }

        //threads are running in concurrency
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadByInterface {
    public static void main(String[] args) {
        Thread t1 = new Thread(new InterfaceThread());
        Thread t2 = new Thread(new InterfaceThread());
        t1.start();
        t2.start();
    }
}
