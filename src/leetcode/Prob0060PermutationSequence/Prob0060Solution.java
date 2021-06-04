package leetcode.Prob0060PermutationSequence;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。,返回第 k 个排列
 * 结合全排列问题，使用回溯算法求解
 * 解题的关键核心是 n 个元素的全排列有 n! 种，若 k < (n-1)!
 *
 * @author Okaeri
 */
public class Prob0060Solution {
    private int[] fact;

    public String getPermutation(int n, int k) {
        // 状态数组，表示 数字 i 有没有使用过
        boolean[] used = new boolean[n + 1];
        // 阶乘数组
        fact = fact(n);
        StringBuilder sb = new StringBuilder();
        getPermutation(sb, used, n, k, 1);
        return sb.toString();
    }

    /**
     * 回溯算法
     *
     * @param sb    最后返回给主函数的字符串
     * @param used  判定第 n 个数是否已经被用过
     * @param n     冗余变量，used.length - 1
     * @param k     全排列的第 k 个元素
     * @param index 表示正在使用的第几个数字，或者是 index - 1 表示当前已经append 的数字的个数
     */
    private void getPermutation(StringBuilder sb, boolean[] used, int n, int k, int index) {
        // 递归出口
        if (sb.length() == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
            int cnt = fact[n - index];
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            sb.append(i);
            used[i] = true;
            getPermutation(sb, used, n, k, index + 1);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            //used[i] = false;
            return;
        }
    }

    /**
     * 求前 n 个数的阶乘值，返回数组
     *
     * @param n 输入数 n
     * @return i 的阶乘值为 res[i]
     */
    private int[] fact(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            res[i] = i * res[i - 1];
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();

        Prob0060Solution sol = new Prob0060Solution();
        int n = 9;
        int k = 331987;
        String permutation = sol.getPermutation(n, k);
        System.out.println(permutation);

        final long stop = System.currentTimeMillis();
        System.out.println("cost time： " + (stop - start));

    }
}
