package leetcode.Prob0084LargestRectangleinHistogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 暴力解法，时间复杂度 O(n * n)
 *
 * @author Okaeri
 */
public class Prob0084Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int result = heights[0];
        int[][] dp = new int[len][len];
        //[i, j]
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, heights[j]);
                dp[i][j] = (j - i + 1) * min;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}

/**
 * 使用单调栈
 * 数组前后补零的想法很妙，使得每一个height[i] 在栈中都能够弹出来
 */
class Prob0084Solution2{
    public int largestRectangleArea(int[] heights) {
        // height 数组长度
        int len = heights.length;
        // 要返回的结果，最大面积
        int maxArea = heights[0];
        // 创建一个新数组，比原来数组长度大 2， 在前后的位置补 0
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 单调栈，栈中的元素是递增的
        // 遍历新数组，如果新数组的元素 newHeights[i] 比栈顶元素要小，就弹出栈顶元素，直到栈顶元素小于 newHeights[i]，再压入栈中
        // 最后一个元素为0， 可以弹出所有的height[i]，但到最后栈不会为空，因为栈底元素为 0，每个元素不比 0 小
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < newHeights.length; i++) {
            while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){
                int cur = stack.pop();
                int left = stack.peek();
                maxArea = Math.max(maxArea, (i - left - 1) * newHeights[cur]);
            }
            stack.push(i);
        }
        return maxArea;
    }

}

class Test {
    public static void main(String[] args) {
        Prob0084Solution sol = new Prob0084Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        Arrays.fill(heights, 1);
        int i = sol.largestRectangleArea(heights);
        System.out.println(i);
    }
}
