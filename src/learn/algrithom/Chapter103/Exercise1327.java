package learn.algrithom.Chapter103;


public class Exercise1327 {

    public static void main(String[] args) {
        ListNode root = new ListNode(10);
        ListNode curser = root;
        for (int i = 0; i < 10; i++) {
            curser.next = new ListNode(i);
            curser = curser.next;
        }
        //while (root.next != null) {System.out.println(root.val);root = root.next;}
        int max = max(root);
        System.out.println(max);

    }

//递归方法
    public static int max(ListNode root){
        if(root.next == null){
            return root.val;
        }
        return max(root.next)>root.val?max(root.next):root.val;
    }


//遍历方法
/*    public static int max(ListNode root){
        int max = root.val;
        while (root.next != null){
            root = root.next;
            max = max > root.val? max : root.val;

        }
        return max;
    }*/



    static class ListNode {
        int val;//节点的数据
        ListNode next;//指向下一个节点
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
