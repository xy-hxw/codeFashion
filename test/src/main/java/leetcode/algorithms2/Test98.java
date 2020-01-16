package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/16 15:49
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Test98 {

    private static boolean isValidBST(TreeNode root) {
        return judge(root, null, null);
    }

    private static boolean judge(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!judge(node.right, val, upper)) {
            return false;
        }
        return judge(node.left, lower, val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = treeNode1;
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(6);
        boolean b = isValidBST(treeNode);
        System.out.println(b);
    }
}
