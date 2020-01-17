package leetcode.algorithms3;

/**
 * @author huoxianwei
 * @date 2020/1/17 16:28
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    public static TreeNode create (int[] nums, int index) {
        TreeNode node = null;
        if (index < nums.length) {
            node = new TreeNode(nums[index]);
            node.left = create(nums, index*2+1);
            node.right = create(nums, index*2+2);
        }
        return node;
    }
}
