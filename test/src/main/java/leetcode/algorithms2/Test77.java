package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/2 16:20
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Test77 {

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<>();
        num(lists, new LinkedList<>(), n, k, 1);
        return lists;
    }

    private static void num (List<List<Integer>> lists, LinkedList<Integer> list, int n, int k, int num) {
        if (list.size() == k) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = num; i <= n; i++) {
            list.add(i);
            num(lists, list, n, k, num+1);
            list.removeLast();
        }
    }

    private static List<List<Integer>> combine1(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 1; i < k + 1; ++i) {
            nums.add(i);
        }
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<>();
        int j = 0;
        while (j < k) {
            output.add(new LinkedList<>(nums.subList(0, k)));
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                nums.set(j, j++ + 1);
            }
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        List<List<Integer>> lists = combine1(n, k);
        assert lists != null;
        for (List<Integer> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
