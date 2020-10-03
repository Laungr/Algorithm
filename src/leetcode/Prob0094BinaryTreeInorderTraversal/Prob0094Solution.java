package leetcode.Prob0094BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob0094Solution {
    List<Integer> ansList;
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ansList = new ArrayList<>();
        TreeNode pNode = root;
        Stack<TreeNode> treeNodeStack = new Stack<>();

        //中序遍历是先访问左子树，然后根节点，最后右子树
        while(pNode != null || !treeNodeStack.isEmpty()){
            if(pNode != null){
                treeNodeStack.push(pNode);
                pNode = pNode.left;
            }
            else{
                pNode = treeNodeStack.pop();
                ansList.add(pNode.val);
                pNode = pNode.right;
            }
        }

        return ansList;

    }
}
class TreeNode{
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