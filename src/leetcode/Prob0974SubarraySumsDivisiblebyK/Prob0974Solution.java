package leetcode.Prob0974SubarraySumsDivisiblebyK;

import java.util.HashMap;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * @author Okaeri
 */
public class Prob0974Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>(k);
        preSum.put(0, 1);
        int ans = 0;
        // 前 i 项之和
        int sum0_i = 0;
        for (int num : nums) {
            // 注意数组中包含负数，-5 也可以被 5整除，因此计算前缀和时先 +k 使之成为正数再取余
            sum0_i = ((sum0_i + num) % k + k) % k;
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

/**
 * 同余定理
 * 由:（preSum[j+1] - preSum[i]）% K = 0
 * 得：preSum[j+1] % K - preSum[i] % K = 0
 * 得：preSum[j+1] % K = preSum[i] % K
 */
class Prob0974Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        // 哈希表的键是 前缀和的余数，值是该余数出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(k);
        map.put(0, 1);
        int result = 0;
        // 前缀和
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            int mod = (preSum + k) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        // 余数有 n 个，则不同的排列有 n*(n-1)/2 个
        for (Integer integer : map.keySet()) {
            Integer value = map.get(integer);
            result += value * (value - 1) / 2;
        }
        return result;

    }
}

class Test {
    public static void main(String[] args) {
        Prob0974Solution2 sol = new Prob0974Solution2();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int i = sol.subarraysDivByK(nums, k);
        System.out.println(i);

    }
}
