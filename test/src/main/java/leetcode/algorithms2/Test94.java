package leetcode.algorithms2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/15 17:24
 *
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class Test94 {

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        merge(root, list);
        return list;
    }

    private static void merge (TreeNode node, List<Integer> list) {
        if (null != node) {
            if (null != node.left) {
                merge(node.left, list);
            }
            list.add(node.val);
            if (null != node.right) {
                merge(node.right, list);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = null;
        TreeNode node1 = new TreeNode(2);
        node.right = node1;
        node1.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(node);
        System.out.println(JSON.toJSONString(list));
    }
}
