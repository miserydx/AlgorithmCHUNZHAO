import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Main {

    static class MyData {

        volatile int number = 0;

        public void addTo60() {
            this.number = 60;
        }
    }

    public static void main(String[] args) {
        System.out.println("dsadasdssss");
        MyData myData = new MyData();
        new Thread(() -> {
            long threadStartTime = System.currentTimeMillis();
            //假设在进行运算
            for(int i = 0;i<1000000;i++){

            }
            myData.addTo60();
        }).start();
        while (myData.number == 0) {

        }
        System.out.println("main end");
    }

}
