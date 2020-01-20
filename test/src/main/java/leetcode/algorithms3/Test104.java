package leetcode.algorithms3;

/**
 * @author huoxianwei
 * @date 2020/1/20 11:05
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Test104 {

    private static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right)+1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int i = maxDepth(TreeNode.create(nums, 0));
        System.out.println(i);
    }
}
