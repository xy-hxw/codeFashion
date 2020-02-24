package leetcode.algorithms3;

import java.util.HashMap;

/**
 * @author huoxianwei
 * @date 2020/2/24 12:08
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树（类似于105题）
 */
public class Test106 {

    private HashMap<Integer,Integer> memo = new HashMap<>();
    private int[] post;

    private TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) {
            return null;
        }
        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0;i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, post.length - 1);
    }

    public static void main(String[] args) {
        // 中序遍历
        int[] inorder = {9,3,15,20,7};
        // 后序遍历
        int[] postorder = {9,15,7,20,3};
        new Test106().buildTree(inorder, postorder);
    }
}
