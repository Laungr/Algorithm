package leetcode.Prob0105ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 依据前序遍历和中序遍历的结果，重建二叉树。
 */
public class Prov0105Solution {

}

class Prob0105Solution2{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            inorderMap.put(inorder[i] , i);
        }
        return buildTree(preorder, 0, preLen -1, inorderMap, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inorderMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);

        int pIndex = inorderMap.get(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, pIndex + preLeft - inLeft, inorderMap, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex + preLeft - inLeft + 1, preRight, inorderMap, pIndex + 1, inRight);
        return root;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
