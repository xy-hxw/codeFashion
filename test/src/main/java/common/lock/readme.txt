锁
    1：fail-fast
    2：cas
    3：synchronized
    4：CountDownLatch
    5：ReentrantLock (AQS)

    AQS：AbstractQueuedSynchronizer 模板模式的应用
        CountDownLatch、FutureTask、Semaphore、ReentrantLock等都有一个内部类是这个抽象类的子类