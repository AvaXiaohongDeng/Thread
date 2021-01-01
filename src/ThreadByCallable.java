import java.util.concurrent.*;

class CallableThread implements Callable<Boolean> {
    @Override
    public Boolean call() {
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
        return true;
    }
}

public class ThreadByCallable {
    public static void main(String[] args) {
        CallableThread t1 = new CallableThread();
        CallableThread t2 = new CallableThread();
        Boolean rs1 = false;
        Boolean rs2 = false;

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        //获取结果
        try {
            rs1 = r1.get();
            rs2 = r2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(rs1);
        System.out.println(rs2);

        //关闭服务
        ser.shutdownNow();
    }
}
