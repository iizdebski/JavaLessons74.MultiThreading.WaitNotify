package com.company;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread8 thread8 = new Thread8();
        thread8.start();
        synchronized (thread8) {
            thread8.wait();
        }
        System.out.println(thread8.total);
    }
    static class Thread8 extends Thread {
        int total;
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    total +=i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}

// wait - thread sleeps
// notify - informs
// both commands must be called from synchronized contexts
