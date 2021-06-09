package interview.pdd.Prob003;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 前缀和问题，时间复杂度超出 O(n*n)
 *
 * @author Okaeri
 */
public class Prob0003和谐区间的数量 {
    /**
     * @param m      输入数组的长度
     * @param n      前缀之和
     * @param values 输入数组
     * @return 前缀和等于 n 的前缀个数
     */
    public int solution(int m, int n, int[] values) {
        int result = 0;
        long[] dp = new long[m];
        // dp[i][j] 表示从 [values[i], values[j]]之和
        for (int i = 0; i < m; i++) {
            dp[i] = values[i];
            if (dp[i] % n == 0) {
                ++result;
            }
            for (int j = i + 1; j < m; j++) {
                dp[j] = dp[j - 1] + values[j];
//                System.out.println(dp[j]);
                if (dp[j] % n == 0) {
                    ++result;
                }
            }
        }
        return result;
    }
}

class ProbPreSum {
    /**
     * 最终返回的结果会超出 int 类型，所以用 long 来接受
     * @param m    输入数组的长度
     * @param n    前缀之和
     * @param nums 输入数组
     * @return 前缀和等于 n 的前缀个数
     */
    public long solution(int m, int n, int[] nums) {
        HashMap<Integer, Integer> preSum = new HashMap<>(n);
        preSum.put(0, 1);
        long ans = 0;
        // 前 i 项之和
        int sum0_i = 0;
        for (int i = 0; i < m; i++) {
            sum0_i = (sum0_i + nums[i]) % n;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_i)) {
                ans += preSum.get(sum0_i);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;

    }
}

class Test {
    public static void main(String[] args) {
        ProbPreSum sol = new ProbPreSum();
        Prob0003和谐区间的数量 sol2 = new Prob0003和谐区间的数量();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入 m 和 n： ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[m];
        System.out.println("和谐值: ");
        // 一个一个读取
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt() % n;
        }
        long solution = sol.solution(m, n, nums);
        System.out.println(solution);


    }
}
