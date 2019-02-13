package common.threa.forkjoin;

import java.util.concurrent.*;

/**
 * @author huoxianwei
 * @date 2019/1/15 10:19
 * 实现fork--join两种方式
 * 1：继承 RecursiveTask   有返回值
 * 2：继承 RecursiveAction 无返回值
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THREAD_HOLD = 2;

    private int start;

    private int end;

    private CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 停止任务拆分的条件
        boolean b =  (end - start) <= THREAD_HOLD;
        if (b) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            CountTask left = new CountTask(start, middle);
            CountTask right = new CountTask(middle+1, end);
            left.fork();
            right.fork();
            sum = left.join() + right.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            CountTask countTask = new CountTask(1, 100);
            Future<Integer> submit = forkJoinPool.submit(countTask);
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}