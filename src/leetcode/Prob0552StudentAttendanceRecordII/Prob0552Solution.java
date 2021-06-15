package leetcode.Prob0552StudentAttendanceRecordII;

import java.util.ArrayList;
import java.util.List;

/**
 * 只给出学生上课的天数，那么他有多少种可能会获奖呢？
 * 如何获奖，参看 Prob0551
 * <p>
 * 时间复杂度超出
 *
 * @author Okaeri
 */
public class Prob0552Solution {
    public int checkReward(int n) {
        char[] attendance = {'A', 'L', 'P'};
        int[] res = new int[1];
        backTrack(new StringBuilder(), res, attendance, 0, 0, n, 0);
        return res[0];
    }

    private void backTrack(StringBuilder sb, int[] res, char[] attendance, int absentNum, int contLateNum, int n, int start) {
        if (absentNum == 2 || contLateNum == 3) {
            return;
        }
        if (sb.length() == n) {
            ++res[0];
            return;
        }
        for (int i = start; i < attendance.length; i++) {
            char appendChar = attendance[i];
            sb.append(appendChar);
            if (appendChar == 'A') {
                contLateNum = 0;
                absentNum++;
                backTrack(sb, res, attendance, absentNum, contLateNum, n, 1);
            } else if (appendChar == 'L') {
                contLateNum++;
                backTrack(sb, res, attendance, absentNum, contLateNum, n, 0);
            } else {
                contLateNum = 0;
                backTrack(sb, res, attendance, absentNum, contLateNum, n, 0);
            }
            char deleteChar = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            if (deleteChar == 'A') {
                absentNum--;
            } else if (deleteChar == 'L') {
                contLateNum--;
            }
        }
    }
}

class Prob0552Solution2 {
    public int checkRecord(int n) {
        int mod = (int) (1e9 + 7);
        //[字符串个数][A的个数][L的个数]
        long[][][] dp = new long[n + 1][2][3];
        dp[1][1][0] = 1;  //1个A
        dp[1][0][1] = 1;  //1个L
        dp[1][0][0] = 1;  //1个P
        for (int i = 2; i < n + 1; i++) {
            //加A,L清0
            dp[i][1][0] += dp[i - 1][0][0] % mod;  //0A0L上加
            dp[i][1][0] += dp[i - 1][0][1] % mod;  //0A1L上加
            dp[i][1][0] += dp[i - 1][0][2] % mod;  //0A2L上加
            //加P,L清0
            dp[i][0][0] += dp[i - 1][0][0] % mod;  //0A0L上加
            dp[i][0][0] += dp[i - 1][0][1] % mod;  //0A1L上加
            dp[i][0][0] += dp[i - 1][0][2] % mod;  //0A2L上加
            dp[i][1][0] += dp[i - 1][1][0] % mod;  //1A0L上加
            dp[i][1][0] += dp[i - 1][1][1] % mod;  //1A1L上加
            dp[i][1][0] += dp[i - 1][1][2] % mod;  //1A2L上加
            //加L,L累加
            dp[i][0][1] += dp[i - 1][0][0] % mod;  //0A0L上加
            dp[i][0][2] += dp[i - 1][0][1] % mod;  //0A1L上加
            dp[i][1][1] += dp[i - 1][1][0] % mod;  //1A0L上加
            dp[i][1][2] += dp[i - 1][1][1] % mod;  //1A1L上加
        }
        long res = dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2];
        return (int) (res % mod);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0552Solution sol = new Prob0552Solution();
        int n = 25;
        int i = sol.checkReward(n);
        System.out.println(i);
    }
}


