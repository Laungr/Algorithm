package leetcode.Prob0038CountandSay;

/**
 * count and say 给出一个字符串，把里面的每个字符从前到后数着说出来
 *
 * @author Okaeri
 */
public class Prob0038Solution {
    public String countAndSay(int n) {
        // 递归出口
        if (n == 1) {
            return "1";
        }
        // 递归调用
        return countAndSayString(countAndSay(n - 1));
    }

    /**
     * count and say 一个字符串
     * @param str 输入的字符串
     * @return count and say str 之后的结果
     */
    private String countAndSayString(String str) {
        int length = str.length();
        // 为了提高效率使用一个 StringBuffer
        StringBuilder sb = new StringBuilder();

        //如果字符串长度为 1，则直接返回，否则的话就进行遍历
        if (length == 1) {
            return "1" + str;
        }
        // 计数器，表示当前这个字符重复了多少此
        int count = 1;
        for (int i = 1; i < length; i++) {
            // 如果与前一个字符重复，那么计数器加 1，然后继续循环，即进行 count
            if (str.charAt(i) == str.charAt(i - 1)){
                count++;
                continue;
            }
            // 否则，把计数器 count 置为 1，然后把前面的 say 出来
            sb.append(count).append(str.charAt(i - 1));
            count = 1;
        }
        // 把最后一个位置 say 出来
        sb.append(count).append(str.charAt(length - 1));
        // 返回字符串
        return new String(sb);
    }
}

class Test{
    public static void main(String[] args) {
        Prob0038Solution sol = new Prob0038Solution();
        System.out.println(sol.countAndSay(10));
    }
}
