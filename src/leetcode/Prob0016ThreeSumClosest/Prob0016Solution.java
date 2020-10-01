package leetcode.Prob0016ThreeSumClosest;

import java.util.Arrays;

public class Prob0016Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int N = nums.length;
        if (N < 3) return 0;
        int diff =(int) Math.pow(2, 31) -1;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = (nums[left] + nums[right] + nums[i]);
                if (Math.abs(sum - target) == 0)
                {
                    return target;
                }

                else if(Math.abs(sum - target) < Math.abs(diff)){
                    diff = sum - target;
                }

                if(sum - target > 0){
                    right--;
                }
                else left++;
            }
        }
        return target+diff;
    }
}
class Test{
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(Prob0016Solution.threeSumClosest(nums, target));
    }
}
