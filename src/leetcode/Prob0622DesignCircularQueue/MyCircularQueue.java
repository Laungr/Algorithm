package leetcode.Prob0622DesignCircularQueue;


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
/**
 * 设计一个环形队列
 * 环形队列的
 * @author Okaeri
 */
public class MyCircularQueue {
    /**
     * 已经添加的元素个数
     */
    private int size;
    /**
     *     设置的容量
     */
    private int capacity;
    /**
     * q对象
     */
    private int[] arr;
    /**
     *     队列头索引
     */
    private int headIndex;
    /**
     *     队列尾索引
      */
    private int tailIndex;

    /**
     * 构造函数
     * @param k 循环队列的容量
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.headIndex = 0;
        this.tailIndex = -1;
        this.size = 0;
        arr = new int[capacity];
    }
    /**
     * 往队列中新增元素
     * @param value 元素的值
     * @return 新增成功与否
     */
    public boolean enQueue(int value) {
        //如果队列满了，返回 false
        if (!isFull()) {
            size ++;
            tailIndex = ++tailIndex % capacity;
            arr[tailIndex] = value;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 从队列头删除元素
     * @return 删除成功与否
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            size--;
            headIndex = ++headIndex % capacity;
            return true;
        } else {
            return false;
        }
    }

    public int front() {
        if (isEmpty()){
            return -1;
        }
        else {
            return arr[headIndex];
        }
    }

    public int rear() {
        if (isEmpty()){
            return -1;
        }
        else {
            return arr[tailIndex];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}


