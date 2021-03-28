package leetcode.Prob0026RemoveDuplicatesfromSortedArray;

public class Prob0026Solution {
    public int removeDuplicates(int[] nums) {
        // 如果数组的长度小于 1，那么返回数组长度，为 1 或者 0
        if (nums.length <= 1) {
            return nums.length;
        }

        //数组长度大于 1，左右指针分别赋值给 0 和 1
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            //如果相等右指针增加
            if (nums[left] == nums[right]){
                right++;
            }
            //如果不等则赋值给左指针
            else {
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }
}

class Test{
    public static void main(String[] args) {
        Prob0026Solution sol = new Prob0026Solution();
        int[] nums = {1,1,2};
        System.out.println(sol.removeDuplicates(nums));
    }
}
