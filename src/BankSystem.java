/*
This program is to use synchronized Method instead of synchronized block
 */

class Bank{
    private int sum;
    //Object obj = new Object();
    public synchronized void add(int n){
        //synchronized (obj){
            sum = sum + n;
            try{Thread.sleep(10);}catch(Exception e){}
            System.out.println("Sum is " + sum);
        //}
    }
}

class Cus implements Runnable{
    private Bank b = new Bank();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Cus c = new Cus();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
