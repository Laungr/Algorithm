package leetcode.DailyChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形，从第 1 行开始，每一行的元素个数等于行号，每一行头尾的元素等于 1， 其他位置的元素等于上一行的相邻两元素之和
 * arr[i, j] = arr[i - 1][j - 1]+ arr[i - 1][j]
 *
 * @author Okaeri
 */
public class June22PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        // 遍历, i是行号
        for (int i = 0; i < numRows; i++) {
            List<Integer> addList = new ArrayList<>(i);
            //j 是列号，头尾元素为 1， 即 j == 0 || j == i
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    addList.add(1);
                }
                // 其他位置的元素就是上一行相邻两元素之和
                else {
                    // 上一行
                    List<Integer> lastRowList = res.get(i - 1);
                    addList.add(lastRowList.get(j - 1) + lastRowList.get(j));
                }
            }
            // 内部循环结束，即一行的填充结束，加入列表
            res.add(addList);
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        June22PascalsTriangle sol = new June22PascalsTriangle();
        int numRows = 5;
        List<List<Integer>> generate = sol.generate(numRows);
        for (List<Integer> list : generate) {
            System.out.println(list.toString());
        }

    }
}
