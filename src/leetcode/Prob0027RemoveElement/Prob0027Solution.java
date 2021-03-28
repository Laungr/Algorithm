package leetcode.Prob0027RemoveElement;

public class Prob0027Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] == val){
                right++;
            }
            else {
                nums[left++] = nums[right++];
            }
        }
        return left;

    }
}

class Test{
    public static void main(String[] args) {
        Prob0027Solution sol = new Prob0027Solution();
        int []nums = {3,2,2,3};
        int val = 2;
        System.out.println(sol.removeElement(nums,val));
    }
}
