package leetcode.algorithms3;

/**
 * @author huoxianwei
 * @date 2020/1/17 16:25
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Test101 {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,3};
        TreeNode treeNode = TreeNode.create(nums, 0);
        boolean b = isSymmetric(treeNode);
        System.out.println(b);
    }
}
