public class TestThread {

    final Object mLock = new Object();

    public static void main(String[] args) {
        new TestThread().start();
    }

    private void start() {
        System.out.println("main start");
        final Thread threadA = new Thread("subA") {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " run " + i);
                        try {
                            this.notify();
//                        mLock.notifyAll();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        threadA.start();
        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run");
        }, "subB");
        threadB.start();
        synchronized (threadA) {
            try {
                threadA.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end");
    }

}
