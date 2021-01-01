// Run() vs start()

class SubclassThread extends Thread{
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

public class ThreadBySubclass{
    public static void main(String[] args) {
        SubclassThread testThread11 = new SubclassThread();
        testThread11.start();
        SubclassThread testThread12 = new SubclassThread();
        //run at the same time
        testThread12.start();
        //run one thread then run another
        //testThread1.run();
    }
}
