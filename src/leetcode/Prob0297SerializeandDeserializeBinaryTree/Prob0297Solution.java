package leetcode.Prob0297SerializeandDeserializeBinaryTree;

public class Prob0297Solution {
    private final String SEP = ",";
    private final String NULL = "#";
    /**
     * 序列化采用先序遍历
     * @param root 传入的树 根节点
     * @return 序列化后的字符串
     */
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialBuilder(root,sb);
        return String.valueOf(sb);
    }
    //使用 StringBuilder 提高效率
    private void serialBuilder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null){
            stringBuilder.append(NULL).append(SEP);
            return ;
        }
        stringBuilder.append(root.val).append(SEP);

        serialBuilder(root.left, stringBuilder);
        serialBuilder(root.right,stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] values = data.split(SEP);
        return deserialBuilder(values, new int[1]);

    }

    /**
     * 要传入 id[] 数组
     * @param arr 数组
     * @param id 数组
     * @return 反序列化的二叉树
     */
    private TreeNode deserialBuilder(String[] arr, int []id) {
        String val = arr[id[0]++];
        //这个地方不能用==，要用equals()，原因不明
        if (val.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialBuilder(arr, id);
        root.right = deserialBuilder(arr, id);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));



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

