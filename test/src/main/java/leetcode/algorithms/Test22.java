package leetcode.algorithms;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/7/11 9:25
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 */
public class Test22 {

    public static List<String> test1 (int n) {
        List<String> ans = new ArrayList();
        merge(ans, "", 0, 0, n);
        return ans;
    }

    private static void merge(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            merge(ans, cur+"(", open+1, close, max);
        }
        if (close < open) {
            merge(ans, cur+")", open, close+1, max);
        }
    }

    public static List<String> test2 (int n) {
        List<String> list = new ArrayList<>();
        if (0 == n) {
            list.add("");
        } else {
            for (int i = 0; i < n; i++) {
                List<String> list1 = test2(i);
                for (String left : list1) {
                    List<String> list2 = test2(n - 1 - i);
                    for (String right : list2) {
                        System.out.println("("+left+")"+right);
                        list.add("("+left+")"+right);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> list = test2(n);
        System.out.println(JSON.toJSONString(list));
    }
}
