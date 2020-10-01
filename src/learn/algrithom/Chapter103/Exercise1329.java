package learn.algrithom.Chapter103;


import java.util.NoSuchElementException;

public class Exercise1329 {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
//        queue.enqueue(5);
//        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}

class Queue<T>{
    RingNode ringLast;
    int N;

    public boolean isEmpty(){return ringLast == null;}
    public int size(){return N;}

    public void enqueue(T t){
        RingNode oldRingLast = ringLast;
        if (isEmpty()) {
            ringLast = new RingNode(t);
            ringLast.next = ringLast;
        }
        else {
            ringLast = new RingNode(t, oldRingLast.next);
            oldRingLast.next = ringLast;
        }

        N++;
    }

    public T dequeue(){
        T enqueueVal = null;
        if (isEmpty()) throw new NoSuchElementException();
        if (size() == 1) {
            enqueueVal = (T) ringLast.val;
            ringLast.next.next = null;
        }
        else{
            enqueueVal = (T) ringLast.next.val;
            ringLast.next = ringLast.next.next;
            N--;
        }
        return enqueueVal;

    }
}

class RingNode<T>{
    T val;
    RingNode next;
    //用来创建第一个节点
    public RingNode(T t){
        this.val = t;
        this.next = this;
    }
    //用来创建后续节点
    public RingNode(T t, RingNode node) {
        this.val = t;
        this.next = node;
    }

}

//教材上的实现方法
/*
class Queue<T>{
    Node first;
    Node last;
    int N;

    public boolean isEmpty(){        return N == 0;    }
    public int size(){        return N;    }
    public void enqueue(T t){
        Node oldLast = last;
        last = new Node(t);
        if(isEmpty())   first.next = last;
        else oldLast.next = last;
        N++;

    }
    public T dequeue(){
        T dequeueVal = (T) first.val;
        first = first.next;
        if (isEmpty()) last = null;
        else last =null;
        N--;
        return dequeueVal;
    }

}

class Node<T>{
    T val;
    Node next;

    public Node(T t) {
        this.val = t;
    }
}
*/


