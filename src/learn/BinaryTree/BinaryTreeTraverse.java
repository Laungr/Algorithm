package learn.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraverse {
    /**
     * 二叉树的前序遍历
     * @param root
     */
    public void preorderTraverse(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        //前序遍历先访问根节点，然后访问左子树和右子树。
        //对于任意node，第一部分直接访问其值，之后判断其左子树是否为空，不为空则重复上面的步骤，如果为空则要访问右子树
        //
        while (node != null || !treeNodeStack.isEmpty()) {
            //如果node的左子树不为空，那么访问其左子树，并将node压入栈
            if (node != null) {
                System.out.println(node.val);
                treeNodeStack.push(node);
                node = node.left;
            }

            //如果node的左子树为空了，说明node的所有左子树遍历完毕，开始访问node的右子树
            else {
                TreeNode popNode = treeNodeStack.pop();
                node = popNode.right;
            }
        }
    }

    /**
     * 二叉树的中序遍历
     * @param root
     */
    public void inorderTraverse(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        //中序遍历先访问左子树，然后访问根节点和右子树
        //对于任意节点，首先遍历访问左子树，如果左子树为空访问栈顶元素的值，
        while (node != null || !treeNodeStack.isEmpty()) {
            //如果左子树不为空，遍历访问左右的左子树，并将node压入栈中
            if (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //如果左子树为空了，那么弹出栈顶的值，然后遍历访问他的右子树
            else {
                TreeNode popNode = treeNodeStack.pop();
                System.out.println(popNode.val);
                node = popNode.right;
            }
        }
    }

    /**
     * 二叉树的后序遍历
     * @param root
     */
    public void postorderTraverse(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;

        //后序遍历是先访问左子树，然后访问右子树，最后访问根节点
        //对于任意节点,首先遍历访问左子树，如果左子树为空则访问栈顶元素的值，然后转入右子树
        //一定程度上相当于把前序遍历反过来写
        while (node != null || !treeNodeStack.isEmpty()) {
            //如果左子树不为空，遍历访问左子树，并将node压入栈中
            if (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            TreeNode peekNode = treeNodeStack.peek();
            //当左子树为空了，取栈顶元素的值但不弹出，判断栈顶元素的右子树是否为null
            //如果peekNode的右子树为null则打印该值，并把游标节点node赋值为null，否则遍历它的右子树
            //另一种打印出该值的情况是，需要打印根节点，根节点是有左右子树的，
            // 但是如果上一次打印的值是他的右子树的话，就打印出根节点
            if (peekNode.right == null || peekNode.right == lastVisit) {
                System.out.println(peekNode);
                treeNodeStack.pop();
                lastVisit = peekNode;
                node = null;
            }
            else{
                node = node.right;
            }
        }
    }

    public void levelTraverse(TreeNode root){
        TreeNode node = root;
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(node);

        //层次遍历时先访问根节点，然后访问左右子树；
        //如果左右子树都有子树，那么依次压入左右子树。

        //定义一个队列，将整个二叉树依次压入，然后取出的时候再压入他的左右子树，直到队列为空，就遍历完所有节点了
        while (!treeNodeQueue.isEmpty()){
            node = treeNodeQueue.poll();
            System.out.println(node.val);
            if (node.left != null){
                treeNodeQueue.offer(node.left);
            }
            if (node.right != null){
                treeNodeQueue.offer(node.right);
            }


        }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
