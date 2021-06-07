package leetcode.Prob0075SortColors;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 相当于给只有包含{0, 1, 2} 三种元素的数组排序
 * <p>
 * 两遍 for 循环
 *
 * @author Okaeri
 */
public class Prob0075Solution {
    public void sortColors(int[] nums) {
        // 颜色数组，下标索引0, 1, 2 就分别表示 3 中颜色，其值表示这种颜色出现了多少次
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < colors[0]) {
                nums[i] = 0;
            } else if (i < colors[0] + colors[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}

/**
 * 使用双指针，用一次遍历即可
 */
class Prob0075Solution2 {
    public void sortColors(int[] nums) {
        // p0 表示 0 元素要插入的位置，p1 表示 1 元素要插入的位置
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums));
            // 如果元素等于 0，与 p0 指针位置元素互换，与 p0 交换之后要与p1 交换一次，保证有序，p0 和 p1 指针都右移
            if (nums[i] == 0) {
                swap(nums, p0, i);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
            // 如果元素等于 1，与 p1 指针位置的元素互换，指针右移
            else if (nums[i] == 1) {
                swap(nums, p1++, i);
            }
        }

    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0075Solution2 sol = new Prob0075Solution2();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

