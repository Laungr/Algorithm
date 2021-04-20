package leetcode.Prob0032LongestValidParentheses;

import java.util.Stack;

/**
 * 动态规划的解法1
 * 时间复杂度 O(n*n)
 */
public class Prob0032Solution {
    public static int longestValidParentheses(String s) {
        //字符串长度
        int len = s.length();

        //dp数组
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;

        //i,j分别表示start和end，开始遍历
        //从递归方程里面可以看出，dp[i][j] 与它左下角的元素有关系，所以矩阵要按列填充，保证每个空格的左下角元素已经被填充了。
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //不以'(' 开头 ')' 结尾的都不是有效的，子串的长度为奇数的都不是有效的
                if (s.charAt(i) != '(' || s.charAt(j) != ')' || (j - i) % 2 == 0) {
                    dp[i][j] = false;
                } else {
                    //说明是一对括弧，有效匹配
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}

/**
 * 动态规划的第一种解法比较容易理解，但是时间复杂度高
 * 这种方法只需要遍历一次字符串即可
 */
class Prob0032Solution1{
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int maxLen = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')'){
                // 如果是 ()()() 这种形式的
                if (s.charAt(i - 1) == '('){
                    dp[i] = i > 2 ? 2 + dp[i - 2] : 2;
                }
                // 或者是((())) 这种形式的
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[ i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}

class Test {
    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = "(()";
        System.out.println(Prob0032Solution.longestValidParentheses(s1));
        System.out.println(Prob0032Solution.longestValidParentheses(s2));
    }
}

/**
 * 第二种解法用了一个栈
 * 先在栈底压入一个元素，防止 stack.peek() 取不到元素；
 * 遍历整个字符串的每个字符，如果是左括号 '('，就把这个索引压入栈
 *                      如果是右括号 ')'，从栈里面弹出一个元素
 *                      同时在这个时候去判断，如果栈为空了，说明有效匹配已经完了，是一个多余的 ')'，把当前索引压入栈，相当于最开始入栈的 -1,给下一个有效匹配来用
 *                                        如果栈不为空，有效长度就是当前索引减去栈顶的索引
 */
class Prob0032Solution2 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}

