package leetcode.DailyChallenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

/**
 * 子序列的个数
 * 暴力算法，时间复杂度超出
 *
 * @author Okaeri
 */
public class June23NumberofMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isMatchingSubSeq(s, word)) {
                res++;
            }
        }
        return res;

    }

    /**
     * 判断 word 是不是 s 的子序列
     *
     * @param s    输入的字符串
     * @param word 被判断的，是不是 s 的子序列
     * @return true or false
     */
    private boolean isMatchingSubSeq(String s, String word) {
        Queue<Character> queue = new ArrayDeque<>();
        // 把 word 的每个字符加进队列
        for (char c : word.toCharArray()) {
            queue.offer(c);
        }
        // 遍历 s 的所有字符，如果与队列第一个元素位置一致，就弹出第一个元素，最后判断队列是否为空
        for (char c : s.toCharArray()) {
            if (queue.isEmpty()) {
                return true;
            } else {
                if (c == queue.peek()) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty();
    }
}

/**
 * Java HashMap + Deque 方法
 *
 * 这个解法比较巧妙
 */

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // 定义一个 HashMap，key 为字符，value 放以 key 开头的 words
        HashMap<Character, Deque<String>> map = new HashMap<>();
        // 给 map 初始化，把 a - z 的字母添加进去
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new ArrayDeque<String>());
        }

        // 以哪个字符开头，就放进那个桶里面
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int res = 0;
        // 遍历 s，取出其中的每个字符
        for (char c : s.toCharArray()) {
            // 取出所有的以 c 打头的 word，并进行遍历
            Deque<String> deque = map.get(c);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                // 每次取出第一个元素，如果其长度为 1，就是子序列，如果不是 1，就往后移动一位，并加入map 中去
                String first = deque.removeFirst();
                if (first.length() == 1) {
                    res++;
                } else {
                    map.get(first.charAt(1)).addLast(first.substring(1));
                }
            }
        }
        return res;
    }
}

class Test23 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(sol.numMatchingSubseq(s, words));
    }
}

