package interview.pdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 给出数字n，另外有一个数字 m，且 m 的各位之和刚好等于 n，求 m 最小是多少
 *
 * @author Okaeri
 */
public class NumbersCombination {
    public int solution(int n) {
        int[] nums = new int[10];
        boolean[] used = new boolean[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        List<Integer> result = new ArrayList<>();
        dfs(result, nums, used, new StringBuilder(), n);

        if (result.isEmpty()) {
            return -1;
        }
        result.sort(Comparator.comparingInt(o -> o));
        return result.get(0);
    }

    private void dfs(List<Integer> result, int[] nums, boolean[] used, StringBuilder sb, int target) {
        if (target == 0) {
            result.add(new Integer(sb.toString()));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            sb.append(i);
            used[i] = true;
            dfs(result, nums, used, sb, target - i);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}


class Test {
    public static void main(String[] args) {
        NumbersCombination sol = new NumbersCombination();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(sol.solution(n));
        }
    }
}