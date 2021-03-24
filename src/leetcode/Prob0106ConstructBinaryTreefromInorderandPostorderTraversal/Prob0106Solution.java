package leetcode.Prob0106ConstructBinaryTreefromInorderandPostorderTraversal;


import java.util.HashMap;
import java.util.Map;

public class Prob0106Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen != postLen){
            throw new RuntimeException("中序遍历和后续遍历序列长度不一致，请检查输入！");
        }
        //为了方便查找，将中序遍历的结果和索引放在一个hashMap之中，下次查找根节点更快速
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorderMap, 0, inLen - 1, postorder, 0, postLen - 1);

    }

    /**
     *
     * @param inorderMap 将中序遍历的序列依次放在HashMap中，根据值可以返回索引位置
     * @param inLeft 中序遍历中（子）二叉树的起始索引
     * @param inRight 中序遍历中（子）二叉树的结束索引
     * @param postorder 后续遍历的序列
     * @param postLeft 后续遍历中（子）二叉树的起始索引
     * @param postRight 后序遍历中（子）二叉树的结束索引
     * @return root 返回root节点
     */

    public TreeNode buildTree(Map<Integer, Integer> inorderMap, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight){
            return null;
        }
        //root节点是后序遍历的最有一个
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);

        //pIndex是rootVal在中序遍历中的索引
        int pIndex = inorderMap.get(rootVal);

        //左子树的长度为 pIndex - inLeft - 1
        //右子树的长度为 inRight - pIndex - 1

        //中序和后序，左子树的索引为inLeft ~ pIndex - 1; postLeft ~ postLeft + pIndex - inLeft - 1
        //中序的右子树的索引为pIndex + 1 ~ inRight
        //后序的右子树的索引为 postLeft + pIndex - inLeft ~ postRight - 1
        root.left = buildTree(inorderMap, inLeft, pIndex - 1, postorder, postLeft, postLeft + pIndex - inLeft - 1);
        root.right = buildTree(inorderMap, pIndex + 1, inRight, postorder, postLeft + pIndex - inLeft , postRight - 1);

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

