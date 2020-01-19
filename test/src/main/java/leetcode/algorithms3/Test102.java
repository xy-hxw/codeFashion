package leetcode.algorithms3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/17 16:56
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Test102 {
    private static List<List<Integer>> levelOrder(TreeNode root) {
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
        lists.get(index).add(node.val);
        if (null != node.left) {
            add(lists, index+1, node.left);
        }
        if (null != node.right) {
            add(lists, index+1, node.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        List<List<Integer>> list = levelOrder(TreeNode.create(nums, 0));
        for (List<Integer> list1 : list) {
            System.out.println(JSON.toJSONString(list1));
        }
    }
}
