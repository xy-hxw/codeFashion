package leetcode.algorithms3;

import java.util.HashMap;

/**
 * @author huoxianwei
 * @date 2020/1/20 11:21
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class Test105 {

    private int preIdx = 0;
    private int[] preorder;
    private HashMap<Integer, Integer> idxMap = new HashMap<>();

    private TreeNode buildTree (int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        preIdx++;
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        // 前序遍历
        int[] preorder = {3,9,20,15,7};
        // 中序遍历
        int[] inorder = {9,3,15,20,7};
        new Test105().buildTree(preorder, inorder);
    }
}
