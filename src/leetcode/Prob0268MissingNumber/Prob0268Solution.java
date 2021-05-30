package leetcode.Prob0268MissingNumber;

/**
 * 给出一个无重复元素的、仅包含自然数的数组，找出第一个确实的正整数
 * 要求是 时间复杂度 O(N) 空间复杂度 O(1)
 * 相当于是用 0 替换了该出现的那个数字
 * @author Okaeri
 */
public class Prob0268Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        // 前 n 项和公式
        int nSum = (len + 1) * len / 2;
        // 数组所有元素求和
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        // 差值即是所求值
        return nSum - arraySum;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0268Solution sol = new Prob0268Solution();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int i = sol.missingNumber(nums);
        System.out.println(i);

    }
}
