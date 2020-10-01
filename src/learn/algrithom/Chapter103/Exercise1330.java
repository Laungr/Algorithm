package learn.algrithom.Chapter103;

public class Exercise1330 {

    public static void main(String[] args) {

        Node first = new Node(1);
        for (int i = 0; i < 10; i++) {
            Node newfirst = new Node(i);
            newfirst.next = first.next;
            first.next = newfirst;
        }
        first = first.next;

        ReverseNodes rNode = new ReverseNodes(first);
        Node  rfirst = rNode.getReverse();

        while (rfirst.next != null) {
            System.out.println(rfirst.val);
            rfirst = rfirst.next;
        }
    }
}

class  ReverseNodes{
    Node first, second, reverse;
    public  ReverseNodes(Node first){
        while (first.next != null){
            Node newreverse = null;//相当于在reverse加后继节点
            second = first.next;//第二个节点
            newreverse.val = second.val;//定义reverse节点的值
            if (reverse == null){
                reverse.next = first;
            }
            newreverse.next = reverse.next;
            reverse.next = newreverse;
            first = first.next;
        }
        }

    public Node getReverse() {
        return reverse;
    }
}

class Node<T>{
    T val;
    Node next;

    public Node(T t) {
        this.val = t;
    }
}