package leetcode.Prob0998MaximumBinaryTreeII;

import java.util.ArrayList;
import java.util.List;


public class Prob0998Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        List<Integer> arrayList = new ArrayList<>();
        inorderTraversal(arrayList, root);
        arrayList.add(val);

        return build(arrayList, 0, arrayList.size() - 1);
    }

    //递归中序遍历，放入List
    private void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }

    //根据List还原出一棵最大树出来，同 Prob0654
    private TreeNode build(List<Integer> nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums.get(i) > maxValue) {
                maxValue = nums.get(i);
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, lo, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, hi);
        return root;
    }
}

class Prob0998Solution2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //如果 root 为 null，直接返回 val 节点
        if (root == null) {
            return new TreeNode(val);
        }

        //如果 root 的值小于 val，那么 root 为新节点的左子树
        if (root.val < val) {
            root = new TreeNode(val, root, null);
        }

        //如果 root 的值大于 val，那么递归调用到 root 右子树
        else{
            root.right = insertIntoMaxTree(root.right, val);
        }


        return root;
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