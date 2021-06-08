package leetcode.Prob0077Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题的递归出口是字符串长度为 n，组合的出口是长度为 k
 * 回溯算法
 *
 * @author Okaeri
 */
public class Prob0077Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> subList, int n, int k, int start) {
        if (subList.size() == k) {
            result.add(new ArrayList<>(subList));
            return;
        }
        // 优化 i <= n ===> i <=  n - (k - subList.size() - 1)
        for (int i = start; i <= n - (k - subList.size() - 1); i++) {
            subList.add(i);
            helper(result, subList, n, k, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0077Solution sol = new Prob0077Solution();
        List<List<Integer>> combine = sol.combine(7, 4);
        for (List<Integer> list : combine) {
            System.out.println(list.toString());
        }
    }
}
