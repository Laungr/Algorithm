package leetcode.Prob0551StudentAttendanceRecordI;

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场 *
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * @author Okaeri
 */
public class Prob0551Solution {
    public boolean checkRecord(String s) {
        int absentNum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                absentNum++;
            } else if (i + 2 < s.length() && chars[i] == 'L') {
                if (chars[i] == chars[i + 1] && chars[i] == chars[i + 2]) {
                    return false;
                }
            }
        }
        return absentNum <= 1;
    }
}
