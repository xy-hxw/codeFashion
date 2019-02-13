package common.jdk8.lambda;

/**
 * @author huoxianwei
 * @date 2019/2/13 15:58
 */
public class TestInterface {

    /**
     * 需要函数的接口
     */
    interface MethodOperation {
        /**
         * 需要函数的接口
         * @param a 参数
         * @param b 参数
         * @return 返回值
         */
        int operation (int a, int b);
    }

    /**
     * 不需要函数的接口
     */
    interface GreetingService {
        /**
         * 不需要函数的接口
         * @param message 参数
         */
        void sayMessage (String message);
    }

    private int operation (int a, int b, MethodOperation methodOperation) {
        return methodOperation.operation(a,b);
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        TestInterface testInterface = new TestInterface();
        MethodOperation operation = (a, b) -> a+b;
        System.out.println("5+10="+testInterface.operation(num1, num2, operation));

        GreetingService greetingService = System.out::println;
        greetingService.sayMessage("张三");
    }
}
