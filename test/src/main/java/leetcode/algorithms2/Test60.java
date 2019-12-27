package leetcode.algorithms2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/12/27 16:58
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，返回第 k 个排列
 */
public class Test60 {

    private static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        getPosition(list, sb, k);
        return sb.toString();
    }

    private static void getPosition (List<Integer> list, StringBuilder sb, int k) {
        if (list.size() == 1) {
            sb.append(list.get(0));
            return;
        }
        int multiply = multiply(list.size()-1);
        for (int i = 0; i < list.size(); i++) {
            if (k > multiply*i && k<=multiply*(i+1)) {
                sb.append(list.get(i));
                list.remove(i);
                k = k - multiply*i;
                break;
            }
        }
        getPosition(list, sb, k);
    }

    private static int multiply (int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num = num * i;
        }
        return num;
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        String permutation = getPermutation(n, k);
        System.out.println(permutation);
    }
}
