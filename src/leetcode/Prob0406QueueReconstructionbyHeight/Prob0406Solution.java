package leetcode.Prob0406QueueReconstructionbyHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）
 *
 * @author Okaeri
 */
public class Prob0406Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        // 按照身高降序排序，如果身高相同，则按照ki 升序排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        // 然后遍历上述排序后的数组，按照 ki 直接进行插入
        ArrayList<int []> list = new ArrayList<>(len);
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[len][2]);


    }
}

class Test {
    public static void main(String[] args) {
        Prob0406Solution sol = new Prob0406Solution();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        sol.reconstructQueue(people);
    }
}