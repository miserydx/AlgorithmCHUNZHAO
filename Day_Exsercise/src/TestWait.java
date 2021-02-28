public class TestWait {

    public static void main(String[] args) {
        new TestWait().go();
    }

    private final Object mLock = new Object();

    private void go() {
        new Thread(() -> {
            synchronized (mLock) {
                System.out.println(Thread.currentThread().getName() + " sync start");
                try {
                    mLock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " sync end");
            }
        }, "threadA").start();
        new Thread(() -> {
            synchronized (mLock) {
                System.out.println(Thread.currentThread().getName() + " sync start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " sync end");
//                mLock.notifyAll();
            }
        }, "threadB").start();
    }

}
