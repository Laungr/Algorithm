package leetcode.Prob0454FourSumII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Prob0454Solution {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //定义返回结果，初始化为0
        int res = 0;
        //A所有元素+B所有元素的和作为键放进hashMap中去，如果有相同的键，则该键的值+1
        Map<Integer, Integer> mapAB = twoArraySum(A, B);
        Map<Integer, Integer> mapCD = twoArraySum(C, D);

        //取出mapAB的keySet然后遍历，并在mapCD中找它的负数
        Set<Integer> keySetAB = mapAB.keySet();


        for (Integer sumAB : keySetAB) {
            int countAB = mapAB.get(sumAB);
        }
        return res;
    }
    public static Map<Integer, Integer> twoArraySum(int[] a, int[] b){
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i : a) {
            for (int j : b) {
                int sum = i + j;
                resultMap.put(sum, resultMap.getOrDefault(sum, 0) + 1);
            }
        }
        return resultMap;
    }
}

class Test{
    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};

        int res = Prob0454Solution.fourSumCount(A, B, C, D);
        System.out.println(res);

    }
}
