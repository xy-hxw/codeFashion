package leetcode.algorithms1;

import java.util.*;

/**
 * @author huoxianwei
 * @date 2019/7/8 11:12
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 */
public class Test15 {

    /**
     * 暴力破解发
     * @param array 数组
     * @return 符合条件的三元组集合
     */
    public static List test (int[] array) {
        if (null == array || array.length < 3) {
            return new ArrayList<>();
        }
        Map<String, List<Integer>> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length-2; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                for (int k = j+1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        List<Integer> temp = new ArrayList<>(3);
                        temp.add(array[i]);
                        temp.add(array[j]);
                        temp.add(array[k]);
                        Collections.sort(temp);
                        StringBuilder sb = new StringBuilder();
                        for (Integer num : temp) {
                            sb.append(num).append("_");
                        }
                        map.putIfAbsent(sb.toString(), temp);
                    }
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 双指针
     * @param array 数组
     * @return 符合条件的三元组集合
     */
    public static List test1 (int[] array) {
        Arrays.sort(array);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length-2; i++) {
            if (i > 0 && array[i] == array[i-1]) {
                continue;
            }
            int l = i + 1, r = array.length - 1;
            if (array[l] < 0 && Integer.MIN_VALUE - array[l] > array[i]) {
                continue;
            }
            if (array[i] > 0 && Integer.MAX_VALUE - array[l] < array[i]) {
                break;
            }
            while (l < r) {
                if (array[r] > -array[i] - array[l]) {
                    while (l < r && array[l+1] == array[l]) {
                        l++;
                    }
                    r --;
                } else if (array[r] < -array[i] - array[l]) {
                    while (l < r && array[l+1] == array[l]) {
                       l++;
                    }
                    l++;
                } else {
                    list.add(Arrays.asList(array[i],array[l],array[r]));
                    while (l < r && array[r-1] == array[r]) {
                        r--;
                    }
                    while (l < r && array[l+1] == array[l]) {
                        l++;
                    }
                    r--;
                    l++;
                }
            }
        }
        return list;
    }

    /**
     * 超时版
     * @param array 数组
     * @return 结果
     */
    public static List<List<Integer>> test2 (int[] array) {
        Arrays.sort(array);
        int size = array.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < size-2; i++) {
            int start = array[i];
            int k = i + 1;
            int r = size - 1;
            while (k < r) {
                int left = array[k];
                int right = array[r];
                int sum = start + left + right;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(left);
                    list.add(right);
                    Collections.sort(list);
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : list) {
                        sb.append(num).append("_");
                    }
                    map.put(sb.toString(), list);
                    k++;
                    r--;
                } else if (sum < 0) {
                    k++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        List test = test2(num);
        System.out.println(test);
    }
}
