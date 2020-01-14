package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/13 20:07
 *
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 格雷编码简介：
 * 1位格雷码有两个码字
 * (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
 * (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1 [4]
 * n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
 */
public class Test89 {

    private static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head = head << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> list = grayCode(n);
        System.out.println(JSON.toJSONString(list));
    }
}
