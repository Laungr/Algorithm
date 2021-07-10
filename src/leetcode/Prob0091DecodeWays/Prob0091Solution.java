package leetcode.Prob0091DecodeWays;

import java.util.Arrays;

/**
 * 一串密码的解码方式
 * 一个解码内容为一个 item, 我们只关心「位置 i 自己能否形成独立 item 」和「位置 i 能够与上一位置（i-1）能否形成 item」，
 * 而不关心 i-1 之前的位置。
 * <p>
 * 官方的递归解法
 *
 * @author Okaeri
 */
public class Prob0091Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        s = "0" + s;

        for (int i = 1; i <= length; i++) {
            int a = s.charAt(i) - '0';
            int b = (s.charAt(i - 1) - '0') * 10 + a;
            // 需要理解这两个 if
            if (a >= 1 && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (b >= 10 && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}

/**
 * 递归解法
 */
class Prob0091Solution2 {
    public int numDecodings(String s) {
        //增加了一个哨兵节点，末尾加 0 是不影响整个结果的，只是为了能够遍历到源字符串的最后一个位置
        s = s + "0";
        // memo 数组，做备忘录用的，如果 index 位置的值已经计算过，就直接取出不用再次计算了，初始化填充 -1
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        // 调用递归方法
        helper(s, 0, dp);
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    private int helper(String s, int index, int[] dp) {
        int len = s.length();
        // 两种 base case，如果索引超出 len 返回 0，如果等于 len，则返回 1
        if (index > len - 1) {
            return 0;
        }
        if (index == len - 1) {
            return 1;
        }
        // 从 memo 中取数据
        if (dp[index] != -1) {
            return dp[index];
        }
        // 加哨兵节点，正式为了防止计算 b 的时候索引越界
        int a = s.charAt(index) - '0';
        int b = a * 10 + s.charAt(index + 1) - '0';
        boolean flag1 = a >= 1 && a <= 9;
        boolean flag2 = b >= 10 && b <= 26;
        // 开始递归，总共有三种情况
        // 第一种是 flag && flag2 为 true，也就是[index] [index, index + 1] 都能解码
        // 第二种是 flag && !flag2 为 true，也就是只有[index] 能解码，[index, index + 1] 不能解码
        // 不存在[index, index + 1] 能解码，但 [index] 不能解码的情况
        // 因此 flag1 == false && flag2 == false 直接返回 0
        if (flag1 && flag2) {
            dp[index] = helper(s, index + 1, dp) + helper(s, index + 2, dp);
        } else if (flag1 && !flag2) {
            dp[index] = helper(s, index + 1, dp);
        } else {
            dp[index] = 0;
        }
        return dp[index];
    }
}

class Test {
    public static void main(String[] args) {
        Prob0091Solution2 sol2 = new Prob0091Solution2();
        String s = "0";
        System.out.println(sol2.numDecodings(s));
    }
}


