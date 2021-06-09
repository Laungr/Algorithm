package leetcode.Prob0146LRUCache;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

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

