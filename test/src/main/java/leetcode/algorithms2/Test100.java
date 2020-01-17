package leetcode.algorithms2;

/**
 * @author huoxianwei
 * @date 2020/1/17 16:16
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Test100 {

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.left = new TreeNode(6);
        treeNode.right = treeNode1;
        treeNode1.right = new TreeNode(5);
        treeNode1.left = new TreeNode(2);
        boolean sameTree = isSameTree(treeNode, treeNode);
        System.out.println(sameTree);
    }
}
