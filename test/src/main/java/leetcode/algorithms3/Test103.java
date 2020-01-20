package leetcode.algorithms3;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/19 11:03
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class Test103 {
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        add(lists, 0, root);
        return lists;
    }

    private static void add (List<List<Integer>> lists, int index, TreeNode node) {
        if (null == node) {
            return;
        }
        if (lists.size() == index) {
            lists.add(new ArrayList<>());
        }
        if ((index+1)%2 == 0) {
            lists.get(index).add(0, node.val);
        } else {
            lists.get(index).add(node.val);
        }
        if (null != node.left) {
            add(lists, index+1, node.left);
        }

        if (null != node.right) {
            add(lists, index+1, node.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        List<List<Integer>> list = zigzagLevelOrder(TreeNode.create(nums, 0));
        for (List<Integer> list1 : list) {
            System.out.println(JSON.toJSONString(list1));
        }
        ArrayList<Object> list1 = Lists.newArrayList();
        list1.add(1);
        list1.add(0, 2);
        System.out.println(JSON.toJSONString(list1));
    }
}
