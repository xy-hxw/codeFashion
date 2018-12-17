package common.design.interpreter;

import java.util.Stack;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 18:12
 * @Description 计算类
 */
public class Calculator {
    private NodeI nodeI;

    public void build(String statement) {
        NodeI left = null;
        NodeI right = null;
        Stack<NodeI> stack = new Stack<>();
        if (null != statement) {
            String[] strs = statement.split(" ");
            for (int i = 0; i < strs.length; i++) {
                String value = strs[i];
                if ("*".equalsIgnoreCase(value)) {
                    left = stack.pop();
                    right = new ValueNodeImpl(Integer.valueOf(strs[++i]));
                    stack.push(new MulNodeImpl(left, right));
                } else {
                    stack.push(new ValueNodeImpl(Integer.valueOf(strs[i])));
                }
            }
            this.nodeI = stack.pop();
        }
    }

    public int compure() {
        return nodeI.interpret();
    }
}
