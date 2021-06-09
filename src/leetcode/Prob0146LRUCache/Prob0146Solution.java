package leetcode.Prob0146LRUCache;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LRU 缓存实现
 *
 * @author Okaeri
 */
public class Prob0146Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}

/**
 * 用了ArrayDeque 和 HashMap，由于ArrayDeque 的 remove() 操作的时间复杂度是 O(N) 的，实现的例子全部通过，但时间复杂度超出
 */
class LRUCache {
    private final Deque<Integer> stack;
    private final HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        stack = new ArrayDeque<>(capacity);
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        // 判断 key 是否已经存在
        Integer integer = map.getOrDefault(key, -1);
        if (integer != -1) {
            stack.remove(key);
            stack.add(key);
        }
        return integer;
    }

    public void put(int key, int value) {
        // 判断 key 是否已经存在
        Integer integer = map.getOrDefault(key, -1);
        if (integer != -1) {
            map.put(key, value);
            stack.remove(key);
            stack.add(key);
        } else {
            if (map.size() < capacity) {
                stack.add(key);
            } else {
                Integer first = stack.removeFirst();
                stack.add(key);
                map.remove(first);
            }
            map.put(key, value);
        }
    }
}

/**
 * 使用 HashMap 和 双向链表 DLinkedNode 实现
 * Java 中有 LinkedHashMap 可以直接实现 LRUCache
 */
class LRUCache2 {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _val) {
            this.key = _key;
            this.val = _val;
        }
    }

    private LinkedHashMap<Integer, Integer> linkedHashMap;
    private final int capacity;
    private int size;
    private final HashMap<Integer, DLinkedNode> map;
    private final DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        //使用伪头部 和 伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, val);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    /**
     * 把 node 加到 head 的位置，head 前移动一位
     *
     * @param node 参数 node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除 node
     *
     * @param node 参数 node
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 把 node 移动到 head 的位置去
     *
     * @param node 参数 node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除末尾
     *
     * @return 末尾 node
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

