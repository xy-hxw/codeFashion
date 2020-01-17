package leetcode.algorithms2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2020/1/16 16:08
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * Morris算法用到了“线索二叉树”的概念，利用叶节点的左右空指针指向某种遍历顺序的前驱节点或后继节点。
 */
public class Test99 {

    private static void recoverTree1(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;

        TreeNode mostRight = null;
        TreeNode cur = root;

        TreeNode pre = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {  // 第二次遍历到了
                    mostRight.right = null;
                }
            }

            if (pre != null && pre.val > cur.val) {
                node1 = node1 == null ? pre : node1;
                node2 = cur;
            }

            pre = cur;
            cur = cur.right;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> nodeList = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        dfs(root, nodeList, arr);
        List<Integer> copy = new ArrayList<>(arr);
        arr.sort((a, b) -> a >= b ? 1 : -1);
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(copy.get(i))) {
                nodeList.get(i).val = arr.get(i);
            }
        }
    }
    private void dfs(TreeNode root, List<TreeNode> list, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, list, arr);
        list.add(root);
        arr.add(root.val);
        dfs(root.right, list, arr);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = treeNode1;
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(5);
        recoverTree1(treeNode);
    }
}
