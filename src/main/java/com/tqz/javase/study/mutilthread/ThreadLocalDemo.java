package com.tqz.javase.study.mutilthread;

/**
 * @author tianqingzhao
 * @since 2023-05-22 18:59
 */
public class ThreadLocalDemo {

    static Demo demo = new Demo();

    // ThreadLocal并一定说是线程之间隔离的，要看initialValue初始化的值
//    private static ThreadLocal<Demo> threadLocalDemo = ThreadLocal.withInitial(() -> demo);
    // 每个线程的副本变量都用不同的对象可以保证线程之间是隔离的
//    private static ThreadLocal<Demo> threadLocalDemo = ThreadLocal.withInitial(Demo::new);

    private static ThreadLocal<Integer> threadLocalInt = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private static ThreadLocal<String> threadLocalStr = ThreadLocal.withInitial(() -> "Hello ");

    public static void main(String[] args) {
        int total = 1;

        Thread[] threads = new Thread[total];
        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                Integer num = threadLocalInt.get();
                num = num + 5;
                threadLocalInt.set(num);
                System.out.println(threadLocalInt.get());

                String localStr = threadLocalStr.get();
                threadLocalStr.set(localStr + "World");
                System.out.println(Thread.currentThread().getName() +
                        ":"
                        +
                        threadLocalInt.get() +
                        "->"
                        +
                        threadLocalStr.get());

//                Demo demo1 = threadLocalDemo.get();
//                System.out.println(demo1.incr());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
