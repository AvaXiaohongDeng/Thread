public class Tickets implements Runnable{
    private int tick = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                if(tick >0)
                {
                    /*try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + ".." +
                            ".sale:" + tick--);
                }
            }
        }
    }

    public static void main(String[] args) {
        Tickets t = new Tickets();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
