package common.classloader;

import java.util.Arrays;

/**
 * @Author huoxianwei
 * @Date 2018/12/21 11:31
 * @Description StackDetail
 */
public class StackDetail {
    public static void test1() {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        if (null != stackTrace) {
            Arrays.stream(stackTrace).forEach(key->{
                System.out.println(key.getClassName()+" "+key.getMethodName()+" "+key.getLineNumber());
            });
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
