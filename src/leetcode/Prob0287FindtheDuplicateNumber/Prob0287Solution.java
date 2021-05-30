package leetcode.Prob0287FindtheDuplicateNumber;

import java.util.HashSet;

/**
 * 利用 HashSet 中不包含重复元素的特性
 *
 * @author Okaeri
 */
public class Prob0287Solution {
    public int findDuplicate(int[] nums) {
        int result = -1;
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            // 因为题目中说明了只包含一个重复的数字，所以找到这个数字之后，就中断循环
            if (set.contains(num)) {
                result = num;
                break;
            }
            set.add(num);
        }
        return result;
    }
}
