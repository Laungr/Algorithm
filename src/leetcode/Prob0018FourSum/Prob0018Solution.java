package leetcode.Prob0018FourSum;
import java.util.*;

public class Prob0018Solution {
    public Set<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ansSet = new HashSet<>();
        HashMap<Integer, Integer> numsMap = new HashMap<>();

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            numsMap.put(nums[i], i);
        }

        if (nums.length < 4) ansSet.add(null);

        for (int i = 0; i < nums.length - 3; i++) {
            int j = i + 1;
            int k = N -1;
            while (j < k){
                int diff = target- nums[i] - nums[j] - nums[k];
                if (numsMap.containsKey(diff) && numsMap.get(diff)!= i &&numsMap.get(diff)!= j && numsMap.get(diff)!= k ) {
                    ansSet.add(Arrays.asList(nums[i], nums[j], nums[k], diff));
                    j++;
                    k--;
                }
                else k--;

            }
        }
        return ansSet;
    }
}
