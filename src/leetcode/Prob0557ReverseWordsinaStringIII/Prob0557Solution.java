package leetcode.Prob0557ReverseWordsinaStringIII;

/**
 * 给定一个字符串，字符串包含多个单词，单词之间使用空格隔开，只反转单词的顺序
 * 1. 把字符串用空格分割获得一个字符串列表；
 * 2. 反转字符串函数
 * 3. 反转之后把新串合并起来
 */
public class Prob0557Solution {
    public String reverseWords(String s) {
        // 以“ ”把字符串分隔开，然后遍历一次，反转单词
        String[] wordsArray = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String word : wordsArray) {
            word = reverseaWord(word);
            sb.append(word).append(" ");
        }
        String res = new String(sb);
        return res.substring(0, res.length() - 1);

    }

    private String reverseaWord(String word) {
        // 使用双指针来反转
        int length = word.length();
        int left = 0;
        int right = length - 1;
        char[] chars = word.toCharArray();

        while (right > left) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }
}


class Test{
    public static void main(String[] args) {
        Prob0557Solution  sol = new Prob0557Solution();
        String s = "Let's";
        System.out.println(sol.reverseWords(s));
    }
}